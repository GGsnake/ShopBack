$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/jhpddall/list',
        datatype: "json",
        colModel: [
            // {label: 'id', name: 'id', index: 'id', width: 50, key: true},
            {
                label: '商品图片', name: 'picturl', index: 'pictUrl', width: 35, formatter: function (value) {
                    return '<a href="javascript:void(0)"><img class="pimg" style="width: 60px;height: 60px;" src="' + value + '" ></a>';
                }
            },
            {label: '店铺名', name: 'shoptitle', index: 'shopTitle', width: 20},
            {label: '标题', name: 'title', index: 'title', width: 29},
            {
                label: '佣金比例', name: 'commissionrate', index: 'commissionRate', width: 15, formatter: function (value) {
                    return value + "%";

                }
            },
            {label: '佣金', name: 'commission', index: 'commission', width: 16},
            {label: '优惠卷金额', name: 'coupon', index: 'coupon', width: 17},
            {label: '折后价', name: 'zkfinalprice', index: 'zkFinalPrice', width: 18},
            {label: '券后价', name: 'couponprice', index: 'couponPrice', width: 17},
            {label: '销量', name: 'volume', index: 'volume', width: 25},
            {label: '商品id', name: 'numiid', index: 'numIid', width: 39},
            {label: '模块', name: 'opt', index: 'opt', width: 11},
            {label: '类目', name: 'cat', index: 'cat', width: 17},
            {label: '创建时间', name: 'createtime', index: 'createTime', width: 45}
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
        q: {
            title: null,
            mime_type: '',
            coupon: '',
            commiss: '',
            opt: '',
            volume: '',
            cat: '',
            goodType: ''
        },
        showList: true,
        title: null,
        jhPddAll: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.jhPddAll = {};
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
            var url = vm.jhPddAll.id == null ? "sys/jhpddall/save" : "sys/jhpddall/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.jhPddAll),
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
        query: function () {
            vm.reload();
        },
        del: function () {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/jhpddall/delete",
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
            $.get(baseURL + "sys/jhpddall/info/" + id, function (r) {
                vm.jhPddAll = r.jhPddAll;
            });
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'title': vm.q.title, 'mime_type': vm.q.mime_type, 'volume': vm.q.volume, 'cat': vm.q.cat, 'opt': vm.q.opt, 'coupon': vm.q.coupon, 'commiss': vm.q.commiss},
                page: page
            }).trigger("reloadGrid");
        },
        refresh: function () {
            vm.showList = true;
            window.location.reload();
        }
    }
});