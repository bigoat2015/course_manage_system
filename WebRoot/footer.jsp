<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<meta http-equiv="description" content="This is my page">
	
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
    
<%--   		<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">--%>
<%--			<div class="container-fluid">--%>
<%--		    	<h5 class="text-center"><span class="glyphicon glyphicon-copyright-mark"></span> 版本信息 </h5> --%>
<%--			</div>--%>
<%--		</nav>--%>
    
  </body>
</html>
