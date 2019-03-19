$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/jhcashapply/list',
        datatype: "json",
        colModel: [

            { label: '用户名', name: 'username', index: 'username', width: 30 , key: true},
            {label: '身份', name: 'roleid', index: 'roleId', width: 24, formatter: function(value){
                    if (value==1){
                        return "运营商";
                    }
                    else if (value==2) {
                        return "代理";
                    }

                    else if (value==3) {
                        return "粉丝";
                    }

                }},
			{ label: '提现金额', name: 'money', index: 'money', width: 30 },
			{ label: '处理状态', name: 'audit', index: 'audit', width: 20 , formatter: function(value){
				if (value==0){
                    return "未处理";
				}
				else {
                    return "已处理";
				}

                }},
			{ label: '支付宝账号', name: 'account', index: 'account', width: 60 },
			{ label: '姓名', name: 'name', index: 'name', width: 50 },
			{ label: '创建时间', name: 'createtime', index: 'createTime', width: 40 },
			{ label: '更新时间', name: 'updatetime', index: 'updateTime', width: 40 }
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
        jhCashApply: {}
    },
    methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.jhCashApply = {};
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
			var url = vm.jhCashApply.id == null ? "sys/jhcashapply/save" : "sys/jhcashapply/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.jhCashApply),
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
				    url: baseURL + "sys/jhcashapply/delete",
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
			$.get(baseURL + "sys/jhcashapply/info/"+id, function(r){
                vm.jhCashApply = r.jhCashApply;
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