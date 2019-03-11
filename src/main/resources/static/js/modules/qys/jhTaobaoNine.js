$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/jhtaobaoall/hot/3',
        datatype: "json",
        colModel: [
            {
                label: '商品图片', name: 'picturl', index: 'pictUrl', width: 32, formatter: function (value) {
                    return '<a href="javascript:void(0)"><img class="pimg" style="width: 60px;height: 60px;" src="' + value + '" ></a>';
                }
            },
            {
                label: '平台', name:
                    'istamll', index:
                    'istamll', width:
                    15, formatter: function (value) {
                    if (value == 0) {
                        return "淘宝";
                    }
                    return "天猫";
                }
            },
            {label: '店铺名', name: 'shoptitle', index: 'shopTitle', width: 40},
            {label: '标题', name: 'title', index: 'title', width: 120},
            {
                label: '佣金比例', name: 'commissionrate', index: 'commissionRate', width: 25, formatter: function (value) {
                    var v = value / 100;
                    return v + "%"
                }
            },

            {
                label: '佣金', name:
                    'commission', index:
                    'commission', width:
                    21
            }
            ,
            {
                label: '优惠卷金额', name:
                    'coupon', index:
                    'coupon', width:
                    25
            }
            ,
            {
                label: '折后价', name:
                    'zkfinalprice', index:
                    'zkFinalPrice', width:
                    25
            }
            ,
            {
                label: '券后价', name:
                    'couponprice', index:
                    'couponPrice', width:
                    25
            }
            ,
            {
                label: '销量', name:
                    'volume', index:
                    'volume', width:
                    25
            }
            ,
            {
                label: '商品id', name:
                    'numiid', index:
                    'numIid', width:
                    50
            }
            ,
            {
                label: '淘宝类目', name:
                    'cat', index:
                    'cat', width:
                    20
            }
            ,
            {
                label: '创建时间', name:
                    'createtime', index:
                    'createTime', width:
                    80
            }
            ,

        ],
        viewrecords: true,
        height:
            "100%",
        rowNum:
            10,
        rowList:
            [10, 30, 50],
        rownumbers:
            true,
        rownumWidth:
            25,
        autowidth:
            true,
        multiselect:
            true,
        pager:
            "#jqGridPager",
        jsonReader:
            {
                root: "page.list",
                page:
                    "page.currPage",
                total:
                    "page.totalPage",
                records:
                    "page.totalCount"
            }
        ,
        prmNames: {
            page: "page",
            rows:
                "limit",
            order:
                "order"
        }
        ,
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
        jhTaobaoAll: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.jhTaobaoAll = {};
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
            var url = vm.jhTaobaoAll.id == null ? "sys/jhtaobaoall/save" : "sys/jhtaobaoall/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.jhTaobaoAll),
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
                    url: baseURL + "sys/jhtaobaoall/delete",
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
            $.get(baseURL + "sys/jhtaobaoall/info/" + id, function (r) {
                vm.jhTaobaoAll = r.jhTaobaoAll;
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