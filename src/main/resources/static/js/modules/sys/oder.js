$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/oder/list1',
        datatype: "json",
        colModel: [
            {label: '订单号', name: 'orderSn', index: 'order_sn', width: 50},
            {label: '商品id', name: 'goodsId', index: 'goods_id', width: 40},
            {label: '商品名', name: 'goodsName', index: 'goods_name', width: 50},

            {label: '数量', name: 'goodsQuantity', index: 'goods_quantity', width: 15},
            {label: '单价', name: 'goodsPrice', index: 'goods_price', width: 15, formatter: function (value) {
                    return value / 100;
                }},
            {
                label: '金额', name: 'orderAmount', index: 'order_amount', width:20, formatter: function (value) {
                    return value / 100;
                }
            },
            // {label: '推广位ID', name: 'p_id', index: 'p_id', width: 40},
            {label: '佣金比例', name: 'promotionRate', index: 'promotion_rate', width: 20, formatter: function (value) {
                    var mutil=value/10;
                    return mutil+"%";
                }},
            {label: '佣金金额', name: 'promotionAmount', index: 'promotion_amount', width: 20, formatter: function (value) {
                    return value / 100;
                }},
            {
                label: '订单状态： -1 未支付;0-已支付；1-已成团；2-确认收货；3-审核成功；4-审核失败（不可提现）；5-已经结算；8-非多多进宝商品（无佣金订单）',
                name: 'orderStatus',
                index: 'order_status',
                width: 21,
                formatter: function (value) {
                    if (value == 0) {
                        return "已支付";
                    }
                    else if (value == 1) {
                        return "已成团";
                    }
                    else if (value == 2) {
                        return "确认收货";
                    } else if (value == 3)
                        return "审核成功";
                    else if (value == 5) {
                        return "已经结算";
                    }
                }
            },
            {label: '订单状态描述', name: 'orderStatusDesc', index: 'order_status_desc', width: 20},
            {label: '订单生成时间', name: 'orderCreateTime', index: 'order_create_time', width: 30, formatter: function(value){
                    if(value == 0){
                        return '';
                    } else {
                        var date = new Date(value*1000);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
                        Y = date.getFullYear() + '-';
                        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
                        D = (date.getDate() < 10 ? '0'+(date.getDate()) :date.getDate()) + ' ';
                        h = (date.getHours() < 10 ? '0'+(date.getHours()) :date.getHours()) + ':';
                        m = (date.getMinutes() < 10 ? '0'+(date.getMinutes()) :date.getMinutes()) + ':';
                        s = (date.getSeconds() < 10 ? '0'+(date.getSeconds()) :date.getSeconds());
                        return Y+M+D+h+m+s;
                    }

                } },
            {label: '支付时间', name: 'orderPayTime', index: 'order_pay_time', width: 30, formatter: function(value){
                    if(value == 0){
                        return '';
                    } else {
                        var date = new Date(value*1000);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
                        Y = date.getFullYear() + '-';
                        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
                        D = (date.getDate() < 10 ? '0'+(date.getDate()) :date.getDate()) + ' ';
                        h = (date.getHours() < 10 ? '0'+(date.getHours()) :date.getHours()) + ':';
                        m = (date.getMinutes() < 10 ? '0'+(date.getMinutes()) :date.getMinutes()) + ':';
                        s = (date.getSeconds() < 10 ? '0'+(date.getSeconds()) :date.getSeconds());
                        return Y+M+D+h+m+s;
                    }

                }},
            {label: '成团时间', name: 'orderGroupSuccessTime', index: 'order_group_success_time', width: 30, formatter: function(value){
                    if(value == 0){
                        return '';
                    } else {
                        var date = new Date(value*1000);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
                        Y = date.getFullYear() + '-';
                        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
                        D = (date.getDate() < 10 ? '0'+(date.getDate()) :date.getDate()) + ' ';
                        h = (date.getHours() < 10 ? '0'+(date.getHours()) :date.getHours()) + ':';
                        m = (date.getMinutes() < 10 ? '0'+(date.getMinutes()) :date.getMinutes()) + ':';
                        s = (date.getSeconds() < 10 ? '0'+(date.getSeconds()) :date.getSeconds());
                        return Y+M+D+h+m+s;
                    }

                }},
            // { label: '审核时间', name: 'orderVerifyTime', index: 'order_verify_time', width: 80 },
            {label: '最后更新时间', name: 'orderModifyAt', index: 'order_modify_at', width: 30, formatter: function(value){
                    if(value == 0){
                        return '';
                    } else {
                        var date = new Date(value*1000);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
                        Y = date.getFullYear() + '-';
                        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
                        D = (date.getDate() < 10 ? '0'+(date.getDate()) :date.getDate()) + ' ';
                        h = (date.getHours() < 10 ? '0'+(date.getHours()) :date.getHours()) + ':';
                        m = (date.getMinutes() < 10 ? '0'+(date.getMinutes()) :date.getMinutes()) + ':';
                        s = (date.getSeconds() < 10 ? '0'+(date.getSeconds()) :date.getSeconds());
                        return Y+M+D+h+m+s;
                    }

                }},
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
$(function () {
    $("#jqGrid").on('click', ".pimg", function () {
        var _this = $(this);//将当前的pimg元素作为_this传入函数

        imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);
    });
});

function imgShow(outerdiv, innerdiv, bigimg, _this) {
    var src = _this.attr("src");//获取当前点击的pimg元素中的src属性
    $(bigimg).attr("src", src);//设置#bigimg元素的src属性

    /*获取当前点击图片的真实大小，并显示弹出层及大图*/
    $("<img/>").attr("src", src).load(function () {
        var windowW = $(window).width();//获取当前窗口宽度
        var windowH = $(window).height();//获取当前窗口高度
        var realWidth = this.width;//获取图片真实宽度
        var realHeight = this.height;//获取图片真实高度
        var imgWidth, imgHeight;
        var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放

        if (realHeight > windowH * scale) {//判断图片高度
            imgHeight = windowH * scale;//如大于窗口高度，图片高度进行缩放
            imgWidth = imgHeight / realHeight * realWidth;//等比例缩放宽度
            if (imgWidth > windowW * scale) {//如宽度扔大于窗口宽度
                imgWidth = windowW * scale;//再对宽度进行缩放
            }
        } else if (realWidth > windowW * scale) {//如图片高度合适，判断图片宽度
            imgWidth = windowW * scale;//如大于窗口宽度，图片宽度进行缩放
            imgHeight = imgWidth / realWidth * realHeight;//等比例缩放高度
        } else {//如果图片真实高度和宽度都符合要求，高宽不变
            imgWidth = realWidth;
            imgHeight = realHeight;
        }
        $(bigimg).css("width", imgWidth);//以最终的宽度对图片缩放

        var w = (windowW - imgWidth) / 2;//计算图片与窗口左边距
        var h = (windowH - imgHeight) / 2;//计算图片与窗口上边距
        $(innerdiv).css({"top": h, "left": w});//设置#innerdiv的top和left属性
        $(outerdiv).fadeIn("fast");//淡入显示#outerdiv及.pimg
    });

    $(outerdiv).click(function () {//再次点击淡出消失弹出层
        $(this).fadeOut("fast");
    });
};

var vm = new Vue({
    el: '#rapp',
    data: {
        q: {
            keyword: null
        },
        showList: true,
        title: null,
        oder: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.oder = {};
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
            var url = vm.oder.id == null ? "sys/oder/save" : "sys/oder/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.oder),
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
                    url: baseURL + "sys/oder/delete",
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
            $.get(baseURL + "sys/oder/info/" + id, function (r) {
                vm.oder = r.oder;
            });
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'keyword': vm.q.keyword},
                page: page
            }).trigger("reloadGrid");

        },
        refresh: function () {
            vm.showList = true;
            window.location.reload();
        }
    }
});