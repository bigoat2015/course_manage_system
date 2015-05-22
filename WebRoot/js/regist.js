/**
 * register.jsp javascript
 * date: 2014-11-27	
 * 
 */

$(function(){

	$("#registForm").validate({
		
		rules: {
			
			username: {
				required: true,
				digits: true,
				minlength: 12
//				remote: {
//				    url: "http://20141004-2214:8080/registerAndLoginDemo/ajax-findUserById",   //后台处理程序
//				    type: "get",               //数据发送方式
//				    dataType: "json",    	 //接受数据格式   
//			    	data: {                     //要传递的数据
//			        	username: function() {
//			            return $("#username").val();
//			        }
//    			}
//			}				
			},
			
			password: {
					required: true,
					minlength: 6
				},
				
			confirmPassword: {
					required: true,
					minlength: 6,
					equalTo: "#password"
				},
				
			phoneNumber: {
				digits: true,
				rangelength: [11,11]
			},
			
			email: {
				email: true
			},
			
			
			answer: {
				required: function(){		
					return false//$("#question").val()!="";
					
				}
			},
			
			verificationCode: {
				required: true,
				digits: true,
				minlength: 4,
				maxlength: 4
			}
			
		},

		messages:{
			
				username: {
					remote: "用户名已经存在"
				},
				
				phoneNumber: {
					rangelength: "请输入11手机号号码"
				},
				
				answer: {
					required: "必须填写问题的答案"
				},
				
				verificationCode: {
					minlength: "请输入 4 位 数字",
					maxlength: "请输入 4 位 数字"
				}
			}
			
		
	});
	
	
	laydate({
		elem: '#birthday', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
    	event: 'focus' //响应事件。如果没有传入event，则按照默认的click
	});
	
	
});


