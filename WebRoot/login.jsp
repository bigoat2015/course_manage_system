<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <jsp:include page="footer.jsp" flush="true"></jsp:include>
    
    <title>login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script src="js/plug-in/jquery-1.11.1.js"></script>
	<script src="js/plug-in/jquery.validate.js"></script>
	<script src="js/plug-in/messages_zh.min.js"></script>
	<script src="js/unslider.js"></script>
	
	<script src="js/login.js"></script>
	
	<style>
		.banner { position: relative; overflow: auto; }
   		.banner li { list-style: none; }
       	.banner ul li { float: left; width:100%; height:406px;}
		
		.container{
			padding-left: 100px;
			padding-top: 50px;
		}
		
		#verificationCode{
		width: 68px;
		height: 35px;}
		
	</style>

  </head>
  
  <body>
    
	 
	  <div class="container">
	  
			 
			<form id="loginForm" action="login" class="form-horizontal" method="post" role="form">
				
				<fieldset>
					<legend> 登录 </legend>
				
				<div class="form-group">
					<div class="col-sm-3">
						<input class="form-control" type="text" name="username" value="<s:property value='#parameters.username'/>" id="username" placeholder="用户名"/> <s:property value="fieldErrors.username[0]"/>			
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-3">
						<input class="form-control" type="password" name="password" value="<s:property value='#parameters.password'/>" id="password" placeholder="密码"/> <s:property value="fieldErrors.password[0]"/>
					</div>
				</div>
				
				<div class="form-group">
			    	<div class="col-sm-2">
			      		<input type="text" class="form-control" name="verificationCode" placeholder="验证码"> 
			   		</div>
			   		<div id="cy" class="col-sm-1">
			   			<img id="verificationCode" src="validateCodeAction"/>
			   		</div>
			   		<span><s:property value="fieldErrors.verificationCode[0]"/></span>
				</div>
	
				<div class="form-group>	
					<label for="answer" class="col-sm-3 control-label"><s:property value="fieldErrors.error[0]"/></label>	
				</div>
		
				<div class="form-group">
		    		<div class="col-sm-3">
						<button type="submit" class="btn btn-default btn-block">登录</button>
		    		</div>
				</div>
							
				<div class="form-group">
					<div class="col-sm-1">
						<a href="regist.jsp">注册</a>
					</div>
					<div class="col-sm-offset-1 col-md-1">
						<a href="javascript:void(0)">找回密码</a>
					</div>
				</div>
							
				<input type="hidden" name="login" value="login" />				
			
				</fieldset>
			
			</form>
		
		
	</div>   

  </body>
</html>
