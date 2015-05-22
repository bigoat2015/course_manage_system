/**
 * register.jsp javascript
 * date: 2014-11-27	
 * 
 */

$(function(){
	
	$("#verificationCode").hover(function () {
	    $(this).css("cursor","pointer");
	  },
	  function () {
	    $(this).css("cursor","");
	  });	

	$("#loginForm").validate({
		
		rules: {
		
			username: {
				required: true,
				digits: true,
				minlength: 12			
			},
			
			password: {
					required: true,
					minlength: 6
				},
			
			verificationCode: {
					required: true,
					minlength: 4,
					maxlength: 4
				}
				
		
		},
		
		messages:{
			
			verificationCode: {
				minlength: "请输入 4 位 数字",
				maxlength: "请输入 4 位 数字"
			}
		}
				
	});
	
	
//
//	$("#submit").click(function(){
//		// 改变提交方式
//		var n = $.trim($("#username").val());
//		var p = $.trim($("#password").val());
//		if(!n || !p){
//			//alert("is null ");
//			return false;
//		} else {
//			//alert("is not null ");
//			return true;
//		}
//		
//	});

	
});