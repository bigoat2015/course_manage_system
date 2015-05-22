<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
	<link rel="stylesheet" href="js/plug-in/bootstrap/css/bootstrap.min.css">
	
	<!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
      	<!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
      	<!--[if lt IE 9]>
         	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
	
	<script src="js/plug-in/jquery-1.11.1.js"></script>
	<script src="js/plug-in/bootstrap/js/bootstrap.min.js"></script>


  </head>
  
  <body>
  	
  	<nav class="navbar navbar-default" role="navigation">
        	<div class="container-fluid">
            
            	<div class="navbar-header">
               		<a class="navbar-brand" href="#">CMS</a>
        		</div>
                <p class="navbar-text navbar-right">
                	<s:property value="#session.logined"/> 
                	<a href="logout" class="navbar-link">退出</a><span>&nbsp;&nbsp;</span>
                </p>		
                
            </div>
            
        </nav>  
  
  </body>
</html>
