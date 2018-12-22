    $(function () {
    	var i=0;
        $('.tip-container').click(function () {
        	var alphabet=String.fromCharCode((65+i));
        	i++;
            var tipcon = '<div style="margin-left:120%;" class="tip-input">'+alphabet+
                '<input name="itembankOption" type="text" class="house-tip" placeholder="答案选项">' +
                '<span class="del"></span>' +
                '</div>';
//            $('.col-sm-10').prepend(tipcon);
                $('#daan').append(tipcon);
            // 删除表单
            $('.del').click(function () {
            	$(this).parent().remove();
            	if(i!=0){
            		i--;
            	}
            });
        });

    });
