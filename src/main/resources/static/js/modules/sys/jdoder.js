$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/jdoder/list',
        datatype: "json",
        colModel: [
            {label: '京东pid', name: 'positionid', index: 'positionId', width: 24},
            {label: '佣金', name: 'actualfee', index: 'actualFee', width: 15},
            {label: '佣金比例', name: 'commissionrate', index: 'commissionRate', width: 20, formatter: function(value){
                  return value+"%";

                }},
            {label: '预估佣金额', name: 'estimatefee', index: 'estimateFee', width: 26},
            {label: '商品单价', name: 'price', index: 'price', width: 25},
            {label: '商品名称', name: 'skuname', index: 'skuName', width: 60},
            {label: '订单ID', name: 'orderid', index: 'orderId', width: 50},
            {label: '结算时间', name: 'paymonth', index: 'payMonth', width:50},
            {label: '订单完成时间', name: 'finishtime', index: 'finishTime', width: 50, formatter: function(value){
                    if(value == 0){
                        return '';
                    } else {
                        var date = new Date(value);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
                        Y = date.getFullYear() + '-';
                        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
                        D = (date.getDate() < 10 ? '0'+(date.getDate()) :date.getDate()) + ' ';
                        h = (date.getHours() < 10 ? '0'+(date.getHours()) :date.getHours()) + ':';
                        m = (date.getMinutes() < 10 ? '0'+(date.getMinutes()) :date.getMinutes()) + ':';
                        s = (date.getSeconds() < 10 ? '0'+(date.getSeconds()) :date.getSeconds());
                        return Y+M+D+h+m+s;
                    }

                } },
            {
                label: '订单状态', name: 'validcode', index: 'validCode', width: 30, formatter: function (value) {
                    if (value == 15) {
                        return "待付款";
                    }
                    else if (value == 16) {
                        return "已付款";
                    }
                    else if (value == 17) {
                        return "已完成";
                    } else if (value == 18)
                        return "已结算";
                }
            },
            {label: '创建时间', name: 'createtime', index: 'createTime', width: 40},
            {label: '修改时间', name: 'updatetime', index: 'updateTime', width: 40},
            {label: '结算状态', name: 'settle', index: 'settle', width: 25, formatter: function (value) {
                    if (value == 0) {
                        return "平台未结算";
                    }
                    else if (value == 1) {
                        return "平台已结算";
                    }
                }}
        ],
        viewrecords: true,
        height: "100%",
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

var vm = new Vue({
    el: '#rapp',
    data: {
        showList: true,
        title: null,
        jdoder: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.jdoder = {};
        },
        update: function () {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },
        saveOrUpdate: function () {
            var url = vm.jdoder.id == null ? "sys/jdoder/save" : "sys/jdoder/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.jdoder),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function () {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        del: function () {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/jdoder/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function () {
                                vm.reload();
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function (id) {
            $.get(baseURL + "sys/jdoder/info/" + id, function (r) {
                vm.jdoder = r.jdoder;
            });
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                page: page
            }).trigger("reloadGrid");
        },
        refresh: function () {
            vm.showList = true;
            window.location.reload();
        }
    }
});