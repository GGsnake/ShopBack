$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/jhjdgood/list',
        datatype: "json",
        colModel: [			
            {
                label: '商品图片', name: 'picturl', index: 'pictUrl', width: 32, formatter: function (value) {
                    return '<a href="javascript:void(0)"><img class="pimg" style="width: 60px;height: 60px;" src="' + value + '" ></a>';
                }
            },
			{ label: '店铺名', name: 'shoptitle', index: 'shopTitle', width: 40 },
			{ label: '标题', name: 'title', index: 'title', width: 60 },
			{ label: '佣金比例', name: 'commissionrate', index: 'commissionRate', width: 20 },
			{ label: '优惠卷金额', name: 'coupon', index: 'coupon', width: 20 },
			{ label: '推客的预估佣金额', name: 'zkfinalprice', index: 'zkFinalPrice', width: 20 },
			{ label: '销量', name: 'volume', index: 'volume', width: 20 },
			{ label: '商品id', name: 'numiid', index: 'numIid', width: 45 },
			{ label: '类目属性', name: 'opt', index: 'opt', width: 20 },
			{ label: '创建时间', name: 'createtime', index: 'createTime', width: 50 },
			{ label: '', name: 'commission', index: 'commission', width: 10 },
			{ label: 'cid', name: 'cid', index: 'cid', width: 10 }
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
    data: {
        q: {
            title: null,
            mime_type: '',
            coupon: '',
            commission: '',
            volume: '',
            opt: ''
        },
        showList: true,
        title: null,
        attachment: {},
        mimeType: 'image/jpeg',
        uploadFileResource: uploadFileResource,
        baseURL: baseURL
    },
	methods: {
		query: function () {
			vm.reload();
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

		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/jhjdgood/delete",
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
			$.get(baseURL + "sys/jhjdgood/info/"+id, function(r){
                vm.jhJdGood = r.jhJdGood;
            });
		},
		reload: function () {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData: {'title': vm.q.title, 'volume': vm.q.volume, 'coupon': vm.q.coupon, 'commission': vm.q.commission, 'opt': vm.q.opt},
                page:page
            }).trigger("reloadGrid");
		},
        refresh: function () {
            vm.showList = true;
            window.location.reload();
        }
	}
});