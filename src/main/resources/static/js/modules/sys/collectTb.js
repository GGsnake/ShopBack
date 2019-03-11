// $(function () {
//     $("#jqGrid").jqGrid({
//         url: baseURL + 'sys/jhpaylog/list',
//         datatype: "json",
//         colModel: [
// 			{ label: '用户名', name: 'username', index: 'username', width: 50 },
// 			{ label: '平台订单号', name: 'ordersn', index: 'orderSn', width: 80 },
// 			{ label: '是否同意', name: 'accept', index: 'accept', width: 30 },
// 			{ label: '付款时间', name: 'createtime', index: 'createTime', width: 80 }
//         ],
// 		viewrecords: true,
//         height: "100%",
//         rowNum: 10,
// 		rowList : [10,30,50],
//         rownumbers: true,
//         rownumWidth: 25,
//         autowidth:true,
//         multiselect: true,
//         pager: "#jqGridPager",
//         jsonReader : {
//             root: "page.list",
//             page: "page.currPage",
//             total: "page.totalPage",
//             records: "page.totalCount"
//         },
//         prmNames : {
//             page:"page",
//             rows:"limit",
//             order: "order"
//         },
//         gridComplete:function(){
//         	//隐藏grid底部滚动条
//         	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
//         }
//     });
// });
//
// var vm = new Vue({
// 	el:'#rapp',
// 	data:{
// 		showList: true,
// 		title: null,
// 		jhPayLog: {}
// 	},
// 	methods: {
// 		query: function () {
// 			vm.reload();
// 		},
// 		add: function(){
// 			vm.showList = false;
// 			vm.title = "新增";
// 			vm.jhPayLog = {};
// 		},
// 		update: function () {
// 			var id = getSelectedRow();
// 			if(id == null){
// 				return ;
// 			}
// 			vm.showList = false;
//             vm.title = "修改";
//
//             vm.getInfo(id)
// 		},
// 		saveOrUpdate: function () {
// 			var url = vm.jhPayLog.id == null ? "sys/jhpaylog/save" : "sys/jhpaylog/update";
// 			$.ajax({
// 				type: "POST",
// 			    url: baseURL + url,
//                 contentType: "application/json",
// 			    data: JSON.stringify(vm.jhPayLog),
// 			    success: function(r){
// 			    	if(r.code === 0){
// 						alert('操作成功', function(){
// 							vm.reload();
// 						});
// 					}else{
// 						alert(r.msg);
// 					}
// 				}
// 			});
// 		},
// 		del: function () {
// 			var ids = getSelectedRows();
// 			if(ids == null){
// 				return ;
// 			}
//
// 			confirm('确定要删除选中的记录？', function(){
// 				$.ajax({
// 					type: "POST",
// 				    url: baseURL + "sys/jhpaylog/delete",
//                     contentType: "application/json",
// 				    data: JSON.stringify(ids),
// 				    success: function(r){
// 						if(r.code == 0){
// 							alert('操作成功', function(){
//                                 vm.reload();
// 							});
// 						}else{
// 							alert(r.msg);
// 						}
// 					}
// 				});
// 			});
// 		},
// 		getInfo: function(id){
// 			$.get(baseURL + "sys/jhpaylog/info/"+id, function(r){
//                 vm.jhPayLog = r.jhPayLog;
//             });
// 		},
// 		reload: function () {
// 			vm.showList = true;
// 			var page = $("#jqGrid").jqGrid('getGridParam','page');
// 			$("#jqGrid").jqGrid('setGridParam',{
//                 page:page
//             }).trigger("reloadGrid");
// 		},
//         refresh: function () {
//             vm.showList = true;
//             window.location.reload();
//         }
// 	}
// });