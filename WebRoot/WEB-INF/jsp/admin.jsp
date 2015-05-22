<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
  
  	<meta charset="utf-8">
  
    <jsp:include page="top.jsp" flush="true"></jsp:include>
	<link rel="stylesheet" href="js/plug-in/bootstrap-table/bootstrap-table.min.css">
	 
   
    <base href="<%=basePath%>"/>
    <title>后台管理</title>
  
  </head>
  
  <body>
 
  	 <div class="container">
  	      
      	<div id="manage-list" class="col-md-2">
          <div class="list-group">
            <a id="classes" href="admin-classes?operObject=Classes" class="list-group-item text-center action">班级管理</a>
            <a id="classroom" href="admin-classroom?operObject=Classroom" class="list-group-item text-center">教室管理</a>
            <a id="course" href="admin-course?operObject=Course" class="list-group-item text-center">课程管理</a>
            <a id="student" href="admin-student?operObject=Student" class="list-group-item text-center">学生管理</a>
            <a id="teacher" href="admin-teacher?operObject=Teacher" class="list-group-item text-center">教师管理</a>
            <a id="teachBuild" href="admin-teachBuild?operObject=TeachBuild" class="list-group-item text-center">教学楼管理</a>
            <a id="timeTable" href="admin-timeTable?operObject=TimeTable" class="list-group-item text-center">授课管理</a>
            <a id="user" href="admin-user?operObject=User" class="list-group-item text-center">用户管理</a>
            <a id="j" class="list-group-item text-center">
             	 教室申请批准<span class="badge">3</span>
            </a>
          </div>      
         </div>
         
         <div id="main"  class="col-md-10">
         	<h1> 这是后台控制主面板 </h1>
         </div>
         
         <button id="add" data-toggle="modal"  data-target="#update" class="btn btn-primary"> 添加  </button>
         
         <div id="ctbale" class="col-md-10">
         	<table id="table" data-toggle="table" data-show-toggle="true" data-toolbar="#add" data-search="true" data-show-columns="true" data-click-to-select="true" data-url='json-find<s:property value="operObject"/>' data-pagination="true" data-show-refresh="true">
   	 			<thead>
        			<tr>
	
	        			<th data-field="state" data-checkbox="true"></th>
	        			<s:iterator value="thead" var="th">	
	        				<th data-field='<s:property value="#th.key"/>' ><s:property value="#th.value"/></th>
	        			</s:iterator>
	       			
	       				<th data-field="operate" data-formatter="operateFormatter" data-events="operateEvents">操作</th>
	       				
                    </tr>
    			</thead>
			</table>
		


<!-- 模态框（Modal） -->
<div class="modal fade" id="update" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title text-center" id="myModalLabel">
               	更新 
            </h4>
         </div>
         <div id="modal-body" class="modal-body">            
            <form class="form-horizontal"  id="update-form" role="form">		  	
	            <s:iterator value="thead" var="th">	
	            	<div class="form-group">
		        		<label class="col-sm-2 control-label"> <s:property value="#th.value"/> </label>
		        		<div class="col-sm-8">
      						<input id= "update-<s:property value='#th.key'/>" class="form-control">
  					 	</div>
		        	</div>
		        </s:iterator>
            </form>           
         </div>
         <div class="modal-footer">	
         	<p id="modal-error" class="text-info text-center" ></p>
            <button type="button" class="btn btn-default" data-dismiss="modal">
            	关闭
            </button>
            <button id="modal-edit-submit" type="button" data-url="update" class="btn btn-primary">
               	提交
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
			
            
  		
  
  	<script src="js/plug-in/bootstrap-table/bootstrap-table.min.js"></script>
  	<script src="js/plug-in/stickUp.min.js"></script>
  	
  	<script>
  		$(function(){

  			$("#main").hide();
  		//	$("#modal-error").hide();
  			// $('.navbar').stickUp();
  			
			
			$("#modal-edit-submit").click(function() {
				var oper = $(this).attr("data-url");
				$.post('<%=basePath%><s:property value="operObject"/>Action!' + oper, {
						<s:iterator value="thead" var="th">		
							<s:property value='#th.key'/>: $("#update-<s:property value='#th.key'/>").val(),						
	       				</s:iterator>
						contentType:"application/x-www-form-urlencoded; charset=utf-8",
					} ,
					function(data) {	
						if(data=='true') {
							$('#table').bootstrapTable('refresh', {url: 'json-find<s:property value="operObject"/>'});
							$("#modal-error").text( oper + "成功");
						} else {
							$("#modal-error").text(data);
						}	
					}
				);					
			});


			$("#add").click(function(){
				$("#update .modal-title").text("添加");
				$("#update-form input").val("");
				
				$("#modal-edit-submit").attr("data-url","add");

			});


			$('#update').on('hide.bs.modal', function () {
				$("#modal-error").text("");
				$("#modal-body input").removeAttr("disabled");
			})

			$('#update').on('show.bs.modal', function () {
				
			})
			
  	  	});


  		window.operateEvents = {
		        'click .like': function (e, value, row, index) {
		           // alert('You click like icon, row: ' + JSON.stringify(row));
		            console.log(value, row, index);
		        },
		        'click .edit': function (e, value, row, index) {
		        	$("#update .modal-title").text("更新");
					$("#modal-edit-submit").attr("data-url","update");		
		        	<s:iterator value="thead" var="th">		
						$("#update-<s:property value='#th.key'/>").val(row.<s:property value="#th.key"/>);					
		       		</s:iterator>
		       		$("#modal-body input:eq(0)").attr("disabled","");
					
		        	//$("#edit .modal-body").text(JSON.stringify(row) + "" + row.id + "---" + value);
		        		        	
		            console.log(value, row, index);
		        },
		        'click .remove': function (e, value, row, index) {
			        
		        	$("#update .modal-title").text("你确定删除这条记录！");
		        	$("#modal-body input").attr("disabled","");
					$("#modal-edit-submit").attr("data-url","delete");		
		        	<s:iterator value="thead" var="th">		
						$("#update-<s:property value='#th.key'/>").val(row.<s:property value="#th.key"/>);					
		       		</s:iterator>
		            console.log(value, row, index);
		        }
		    };


		function operateFormatter(value, row, index) {
  	        return [
  	            '<a class="edit ml10" href="javascript:void(0)" data-toggle="modal" data-target="#update" title="Edit">',
  	                '<i class="glyphicon glyphicon-edit"></i>',
  	            '</a> &nbsp;&nbsp;',
  	            '<a class="remove ml10" href="javascript:void(0)" data-toggle="modal" data-target="#update" title="Remove">',
  	                '<i class="glyphicon glyphicon-remove"></i>',
  	            '</a>'
  	        ].join('');
  	    }


		
  	</script>
  	
  </body>
</html>
