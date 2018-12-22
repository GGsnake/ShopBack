$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/tboder/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '推广位Id', name: 'adzoneId', index: 'adzone_id', width: 80 }, 			
			{ label: '推广位名称', name: 'adzoneName', index: 'adzone_name', width: 80 }, 			
			{ label: '付款金额', name: 'alipayTotalPrice', index: 'alipay_total_price', width: 80 }, 			
			{ label: '推广者获得的收入金，', name: 'commission', index: 'commission', width: 80 }, 			
			{ label: '平台类型', name: 'orderType', index: 'order_type', width: 80 },
			{ label: '商品标题', name: 'itemTitle', index: 'item_title', width: 80 }, 			
			{ label: '商品数量', name: 'itemNum', index: 'item_num', width: 80 }, 			
			{ label: '商品id', name: 'numIid', index: 'num_iid', width: 80 }, 			
			{ label: '实际支付金额', name: 'payPrice', index: 'pay_price', width: 80 }, 			
			{ label: '淘客订单状态，3：订单结算，12：订单付款， 13：订单失效，14：订单成功', name: 'tkStatus', index: 'tk_status', width: 80 },
			{ label: '  淘宝订单号', name: 'tradeId', index: 'trade_id', width: 80 },
			{ label: '淘宝父订单号', name: 'tradeParentId', index: 'trade_parent_id', width: 80 },
			{ label: '订单创建时间', name: 'odercreateTime', index: 'odercreate_time', width: 80 },
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
		tboder: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tboder = {};
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
			var url = vm.tboder.id == null ? "sys/tboder/save" : "sys/tboder/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.tboder),
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
				    url: baseURL + "sys/tboder/delete",
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
			$.get(baseURL + "sys/tboder/info/"+id, function(r){
                vm.tboder = r.tboder;
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