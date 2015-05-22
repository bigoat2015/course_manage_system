<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.cms.util.RandomValidateCode"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <jsp:include page="footer.jsp" flush="true"></jsp:include>
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	

  </head>
  
  <body>
 
 	 <div class="container">
  	
		<form id="registForm" class="form-horizontal" action="regist" role="form" method="post">
			<fieldset>
				<legend>注册</legend>
				
				<div class="form-group">
				    <label for="username" class="col-sm-2 control-label">学号</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="username" name="username" value="<s:property value='#parameters.username'/>" placeholder=""> <span><s:property value="fieldErrors.username[0]"/></span>
				    </div>
				</div>
				
				<div class="form-group">
				    <label for="nickname" class="col-sm-2 control-label">昵称</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="nickname" name="nickname" value="<s:property value='parameters.nickname'/>" placeholder=""> <span><s:property value="fieldErrors.nickname[0]"/></span>
				    </div>
				</div>
				
				<div class="form-group">
				    <label for="password" class="col-sm-2 control-label">密码</label>
				    <div class="col-sm-3">
				      <input type="password" class="form-control" id="password" name="password" value="<s:property value='parameters.password'/>" placeholder=""> <span><s:property value="fieldErrors.password[0]"/></span>
				    </div>
				</div>
				
				<div class="form-group">
				    <label for="confirmPassword" class="col-sm-2 control-label">确定密码</label>
				    <div class="col-sm-3">
				      <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" value="<s:property value='parameters.confirmPassword'/>" placeholder=""> <span><s:property value="fieldErrors.confirmPassword[0]"/></span>
				    </div>
				</div>
				
				<div class="form-group">
		        	<label name="sex" class="col-sm-2 control-label">性别</label>
		          	<div class="col-sm-3">
		            	<select class="form-control" name="sex">
		      				<option value=""></option>
		      				<option value="男">男</option>
		     			 	<option value="女">女</option>
		     			 </select>
		     			 <span><s:property value="fieldErrors.sex[0]"/></span> 
		          	</div>  	
		        </div>
				
				
				<div class="form-group">
				    <label for="phoneNumber" class="col-sm-2 control-label">手机号码</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="<s:property value='parameters.phoneNumber'/>" placeholder=""> <span><s:property value="fieldErrors.phoneNumber[0]"/></span>
				    </div>
				</div>
				
				<div class="form-group">
				    <label for="email" class="col-sm-2 control-label">邮箱</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="email" name="email" value="<s:property value='parameters.email'/>" placeholder=""> <span><s:property value="fieldErrors.email[0]"/></span>
				    </div>
				</div>

				<div class="form-group">
				    <label for="address" class="col-sm-2 control-label">生日</label>
				    <div class="col-sm-3">
				      <input type="text" class="laydate-icon form-control" style="height: 35px" id="birthday" name="birthday" value="<s:property value='parameters.birthday'/>" placeholder=""> <span><s:property value="fieldErrors.birthday[0]"/></span>
				    </div>
				</div>
				
				<div class="form-group">
				    <label for="address" class="col-sm-2 control-label">地址</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="address" name="address" value="<s:property value='parameters.address'/>" placeholder=""> <span><s:property value="fieldErrors.address[0]"/></span>
				    </div>
				</div>

				
				<div class="form-group">
		        	<label name="question" class="col-sm-2 control-label">问题</label>
		          	<div class="col-sm-3">
		            	<select class="form-control" name="question" value="<s:property value='#parameters.question'/>">
		      				<option value=""> </option>
							<option value="我的母亲是谁？">我的母亲是谁？</option>
							<option value="我的女朋友是谁？">我的女朋友是谁？</option>
							<option value="我的小学班主任是谁？">我的小学班主任是谁？</option>
							<option value="我最爱的动漫是？">我最爱的动漫是？</option>
							<option value="我的出生地是？">我的出生地是？</option>
		     			 </select>
		     			 <span><s:property value="fieldErrors.question[0]"/></span> 
		          	</div>  	
		        </div>
		        

				<div class="form-group">
				    <label for="answer" class="col-sm-2 control-label">答案</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="answer" name="answer" value="<s:property value='parameters.answer'/>" placeholder=""> <span><s:property value="fieldErrors.answer[0]"/></span>
				    </div>
				</div>
				
				<div class="form-group">
			    	<label for="verificationCode" class="col-sm-2 control-label">验证码</label>
			    	<div class="col-sm-2">
			      		<input type="text" class="form-control" name="verificationCode" placeholder=""> 
			   		</div>
			   		<div class="col-sm-1">
			   			<img id="verificationCode" src="validateCodeAction"/>  <span><s:property value="fieldErrors.verificationCode[0]"/></span>
			   		</div>
				</div>
							
				<div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">注册</button> <a class="btn btn-default" href="index">有账户登录</a>
				    </div>
				</div>
				

			
				
		<!--  	
				<ul>
					<li><label for="username">学号：</label><input type="text" name="username" value="<s:property value='#parameters.username'/>" id="username"/> <spen><s:property value="fieldErrors.username[0]"/></b></spen> </li>
					<li><label for="nickname">昵称：</label><input type="text" name="nickname" value="<s:property value='#parameters.nickname'/>" id="nickname"/> <spen><s:property value="fieldErrors.nickname[0]"/></b></spen> </li>
					<li><label for="password">密码：</label><input type="password" name="password" id="password" value="<s:property value='#parameters.password'/>" /> <spen><s:property value="fieldErrors.password[0]"/></b></spen> </li>
					<li><label for="confirmPassword">确定密码：</label><input type="password" name="confirmPassword" value="<s:property value='#parameters.confirmPassword'/>" /> <spen><s:property value="fieldErrors.confirmPassword[0]"/></b></spen> </li>
					<li>
						<label>性别：</label>
						<select name="sex"  value="<s:property value='#parameters.sex'/>">
							<option value=""> </option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
						 <spen><s:property value="fieldErrors.sex[0]"/></b></spen> 
					</li>
					<li><label for="phoneNumber">手机号码：</label><input type="text" name="phoneNumber" value="<s:property value='#parameters.phoneNumber'/>"/> <spen><s:property value="fieldErrors.phoneNumber[0]"/></b></spen> </li>
					<li><label for="email">邮箱：</label><input type="text" name="email" value="<s:property value='#parameters.email'/>"/> <spen><s:property value="fieldErrors.email[0]"/></b></spen> </li>
					<li><label for="birthday">生日：</label><input type="text" class="laydate-icon" value="<s:property value='#parameters.birthday'/>" name="birthday" id="birthday"/> <spen><s:property value="fieldErrors.birthday[0]"/></b></spen> </li>
					<li>
						<label for="address">住址：</label>
						<select name="address" value="<s:property value='#parameters.address'/>">
							<option value=""> </option>
							<option value="guiZhou">贵州</option>
							<option value="huNan">湖南</option>
							<option value="chongQing">重庆</option>
							<option value="siChuan">四川</option>
							<option value="beiJing">北京</option>
						</select>
						 <spen><s:property value="fieldErrors.address[0]"/></b></spen> 
					</li>
					<li>
						<label for="question">问题：</label>
						<select name="question" id="question" value="<s:property value='#parameters.question'/>">
							<option value=""> </option>
							<option value="我的母亲是谁？">我的母亲是谁？</option>
							<option value="我的女朋友是谁？">我的女朋友是谁？</option>
							<option value="我的小学班主任是谁？">我的小学班主任是谁？</option>
							<option value="我最爱的动漫是？">我最爱的动漫是？</option>
							<option value="我的出生地是？">我的出生地是？</option>
						</select>
						 <spen><s:property value="fieldErrors.question[0]"/></b></spen> 	
					</li>
					<li><label for="answer">答案：</label><input type="text" name="answer" value="<s:property value='#parameters.answer'/>"/> <spen><s:property value="fieldErrors.answer[0]"/></b></spen> </li>
					
					<li><label for="verificationCode">验证码：</label><input type="text" name="verificationCode" /><img id="verificationCode" src="validateCodeAction"/> <spen><s:property value="fieldErrors.verificationCode[0]"/></b></spen> </li>

				</ul>
			 	
				<input type="submit" value="注册"/> <input type="reset" value="重置"/>
				
			</fieldset>
		
		</form>
		
		-->	
  
    
		
    
   	</div>
   	
   
   	
    <script type="text/jscript" src="js/plug-in/jquery.validate.js"></script>
	<script type="text/javascript" src="js/plug-in/messages_zh.min.js"></script>
	<script type="text/javascript" src="js/plug-in/laydate/laydate.js"></script>	
	<script type="text/javascript" src="js/regist.js"></script>
    
  </body>
</html>
