$(function() {
	$("#jqGrid").jqGrid({
		url: baseURL + 'sys/userinfo/list',
		datatype: "json",
		colModel: [{
				label: 'id',
				name: 'id',
				index: 'id',
				width: 12,
				key: true
			},

			{
				label: '用户名称',
				name: 'username',
				index: 'userName',
				width: 30
			},
			{
				label: '预估总收入',
				name: 'income',
				index: 'income',
				width: 20,
				formatter: function(value) {
					return value / 100;
				}
			},
			{
				label: '手机',
				name: 'userphone',
				index: 'userPhone',
				width: 30
			},
			{
				label: '身份',
				name: 'roleid',
				index: 'roleId',
				width: 14
			},
			{
				label: '佣金比率',
				name: 'score',
				index: 'score',
				width: 14
			},
			// { label: '密码', name: 'loginpwd', index: 'loginPwd', width: 80 },
			{
				label: '积分',
				name: 'userscore',
				index: 'userScore',
				width: 20
			},
			// { label: '账号状态', name: 'userstatus', index: 'userStatus', width: 20 },
			{
				label: '京东pid',
				name: 'jdpid',
				index: 'jdPid',
				width: 50
			},
			{
				label: '拼多多pid',
				name: 'pddpid',
				index: 'pddPid',
				width: 50
			},
			{
				label: '淘宝pid',
				name: 'tbpid',
				index: 'tbPid',
				width: 50
			},
			// { label: '唯品会pid', name: 'wphpid', index: 'wphPid', width: 50 },
			// { label: '账号', name: 'loginname', index: 'loginName', width: 20 },
			// { label: '用户头像', name: 'userphoto', index: 'userPhoto', width: 80 },
			{
				label: '消费积分',
				name: 'usertotalscore',
				index: 'userTotalScore',
				width: 14
			},
			// { label: '安全码', name: 'loginsecret', index: 'loginSecret', width: 80 },
			{
				label: '性别',
				name: 'usersex',
				index: 'userSex',
				width: 14
			},
			{
				label: '创建时间',
				name: 'createtime',
				index: 'createTime',
				width: 30
			},
			{
				label: '修改时间',
				name: 'updatetime',
				index: 'updateTime',
				width: 30
			},
			// { label: '微信openid', name: 'wxopenid', index: 'wxOpenId', width: 40 },
			{
				label: '激活状态',
				name: 'status',
				index: 'status',
				width: 19
			}
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
		gridComplete: function() {
			//隐藏grid底部滚动条
			$("#jqGrid").closest(".ui-jqgrid-bdiv").css({
				"overflow-x": "hidden"
			});
		}
	});
});

var vm = new Vue({
	el: '#rapp',
	data: {
		showList: 1,
		title: null,
		userinfo: {},
		q: {
			title: null,
			mime_type: null,
			coupon: null,
			commiss: null,
			opt: null,
			volume: null,
			cat: null,
			goodType: null
		},
		
	},
	methods: {
		query: function() {
			vm.reload();
		},
		add: function() {
			vm.showList = 2;
			vm.title = "新增";
			vm.userinfo = {};
		},
		update: function() {
			var id = getSelectedRow();
			if (id == null) {
				return;
			}
			vm.showList = 3;
			vm.title = "修改";

			vm.getInfo(id)
		},
		saveOrUpdate: function() {
			var url = vm.userinfo.id == null ? "sys/userinfo/save" : "sys/userinfo/update";
			$.ajax({
				type: "POST",
				url: baseURL + url,
				contentType: "application/json",
				data: JSON.stringify(vm.userinfo),
				success: function(r) {
					if (r.code === 0) {
						alert('操作成功', function() {
							vm.reload();
						});
					} else {
						alert(r.msg);
					}
				}
			});
		},
		del: function() {
			var ids = getSelectedRows();
			if (ids == null) {
				return;
			}

			confirm('确定要删除选中的记录？', function() {
				$.ajax({
					type: "POST",
					url: baseURL + "sys/userinfo/delete",
					contentType: "application/json",
					data: JSON.stringify(ids),
					success: function(r) {
						if (r.code == 0) {
							alert('操作成功', function() {
								vm.reload();
							});
						} else {
							alert(r.msg);
						}
					}
				});
			});
		},

		getInfo: function(id) {
			$.get(baseURL + "sys/userinfo/info/" + id, function(r) {
				vm.userinfo = r.userinfo;
			});
		},
		reload: function() {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
			 postData: {'title': vm.q.title},
				page: page
			}).trigger("reloadGrid");
		},
		refresh: function() {
			vm.showList = true;
			window.location.reload();
		}
	}
});
