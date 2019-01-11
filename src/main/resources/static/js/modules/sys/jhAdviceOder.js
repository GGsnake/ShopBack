$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/jhadviceoder/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '用户id', name: 'userid', index: 'userId', width: 80 }, 			
			{ label: '订单编号', name: 'odersn', index: 'oderSn', width: 80 }, 			
			{ label: '平台类型', name: 'src', index: 'src', width: 80 }, 			
			{ label: '平台名称', name: 'srcName', index: 'src_name', width: 80 }, 			
			{ label: '订单标题', name: 'name', index: 'name', width: 80 }, 			
			{ label: '推广位', name: 'pid', index: 'pid', width: 80 }, 			
			{ label: '订单状态', name: 'orderStatus', index: 'order_status', width: 80 }, 			
			{ label: '订单状态描述', name: 'orderStatusDesc', index: 'order_status_desc', width: 80 }, 			
			{ label: '订单的创建时间', name: 'oderCreatetime', index: 'oder_createTime', width: 80 }, 			
			{ label: '创建时间', name: 'createtime', index: 'createTime', width: 80 }			
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
		jhAdviceOder: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.jhAdviceOder = {};
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
			var url = vm.jhAdviceOder.id == null ? "sys/jhadviceoder/save" : "sys/jhadviceoder/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.jhAdviceOder),
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
				    url: baseURL + "sys/jhadviceoder/delete",
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
			$.get(baseURL + "sys/jhadviceoder/info/"+id, function(r){
                vm.jhAdviceOder = r.jhAdviceOder;
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