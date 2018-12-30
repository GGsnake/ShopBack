$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/oder/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '订单号', name: 'orderSn', index: 'order_sn', width: 80 }, 			
			{ label: '商品id', name: 'goodsId', index: 'goods_id', width: 80 }, 			
			{ label: '商品名', name: 'goodsName', index: 'goods_name', width: 80 }, 			
			{ label: '商品图片url', name: 'goodsThumbnailUrl', index: 'goods_thumbnail_url', width: 80 }, 			
			{ label: '购买商品的数量', name: 'goodsQuantity', index: 'goods_quantity', width: 80 }, 			
			{ label: '订单中sku的单件价格，单位为分', name: 'goodsPrice', index: 'goods_price', width: 80 }, 			
			{ label: '实际支付金额，单位为分', name: 'orderAmount', index: 'order_amount', width: 80 }, 			
			{ label: '推广位ID', name: 'pId', index: 'p_id', width: 80 }, 			
			{ label: '佣金比例，千分比', name: 'promotionRate', index: 'promotion_rate', width: 80 }, 			
			{ label: '佣金金额，单位为分', name: 'promotionAmount', index: 'promotion_amount', width: 80 }, 			
			{ label: '订单状态： -1 未支付;0-已支付；1-已成团；2-确认收货；3-审核成功；4-审核失败（不可提现）；5-已经结算；8-非多多进宝商品（无佣金订单）', name: 'orderStatus', index: 'order_status', width: 80 }, 			
			{ label: '订单状态描述', name: 'orderStatusDesc', index: 'order_status_desc', width: 80 }, 			
			{ label: '订单生成时间，UNIX时间戳', name: 'orderCreateTime', index: 'order_create_time', width: 80 }, 			
			{ label: '支付时间', name: 'orderPayTime', index: 'order_pay_time', width: 80 }, 			
			{ label: '成团时间', name: 'orderGroupSuccessTime', index: 'order_group_success_time', width: 80 }, 			
			{ label: '审核时间', name: 'orderVerifyTime', index: 'order_verify_time', width: 80 }, 			
			{ label: '最后更新时间', name: 'orderModifyAt', index: 'order_modify_at', width: 80 }, 			
			{ label: '', name: 'updatetime', index: 'updateTime', width: 80 }, 			
			{ label: '0正常;1冻结', name: 'status', index: 'status', width: 80 }			
        ],
		viewrecords: true,
        height: "100%",
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rapp',
	data:{
		showList: true,
		title: null,
		oder: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.oder = {};
		},
		update: function () {
			var id = getSelectedRow();
			if(id == null){
				return ;
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
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/oder/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(){
                                vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "sys/oder/info/"+id, function(r){
                vm.oder = r.oder;
            });
		},
		reload: function () {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
        refresh: function () {
            vm.showList = true;
            window.location.reload();
        }
	}
});