<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML">
<html>
  <head>
    <jsp:include page="top.jsp" flush="true"></jsp:include>
    
    <base href="<%=basePath%>">
    <title>主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	
  
    <div class="container-fluid">
    
	    <div class="col-md-7">
	    
	    </div>
	  	      <tr rowspan="2">    <td colspan="2" >两行两列  </td>  </tr>
      	<div id="course" class="col-md-5"> 
			<table class="table table-bordered">
				<caption>课程表</caption>
				<tr> <th></th><th>星期一</th><th>星期二</th><th>星期三</th><th>星期四</th><th>星期五</th><th>星期六</th><th>星期天</th> </tr>
				<tr> <th>1</th><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td> </tr>
				<tr> <th>2</th>
				<tr> <th>3</th><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td> </tr>
				<tr> <th>4</th>
				<tr> <th>5</th><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td> </tr>
				<tr> <th>6</th>
				<tr> <th>7</th><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td> </tr>
				<tr> <th>8</th>
				<tr> <th>9</th><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td><td rowspan="2">&nbsp;</td> </tr>
				<tr> <th>10</th>
			
			</table>
			
   		</div>
   		
	</div>
    
    <div> <a href="admin"> 后台管理 </a> </div>
    
    <s:debug></s:debug>
    
  </body>
</html>
