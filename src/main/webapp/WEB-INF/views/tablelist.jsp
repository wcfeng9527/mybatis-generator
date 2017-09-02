<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据库中的表列表</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
</head>
<body>
	<div class="container well" style="margin-top:50px;">
		<center><h3>数据库所有表</h3></center>
		<table class="table">
			<thead>
				<th>库名</th>
				<th>表名</th>
				<th>描述</th>
				<th></th>
				<th>创建时间</th>
				<th>查看代码</th>
				<th>导出代码</th>
			</thead>
			<tbody>
				<c:forEach var="tb" items="${tables }">
					<tr>
						<td>${tb.table_schema }</td>
						<td><a href="../columnlist/${tb.dbId}/${tb.table_name }">${tb.table_name }</a></td>
						<td>${tb.table_comment }</td>
						<td>${tb.auto_increment }</td>
						<td>${tb.create_time }</td>
						<td><a href="../codelist/${tb.dbId }/${tb.table_name }">查看代码</a></td>
						<td><a href="javascript:void(0);" onclick="openExportModal(${tb.dbId },'${tb.table_name }')">导出代码</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">导出代码</h4>
	      </div>
	      <div class="modal-body">
	      	<div style="width:400px;margin:0 auto;margin-top:30px;">
	      	  <input type="hidden" id="dbId" value=""/>
	      	  <input type="hidden" id="tableName" value=""/>
			  <div class="form-group">
			    <label for="projectName">项目名称</label>
			    <input type="text" class="form-control" id="projectName" name="projectName" value="scm"/>
			  </div>
			  <div class="form-group">
			    <label for="moduleName">模块名称</label>
			    <input type="text" class="form-control" id="moduleName" name="moduleName" value="rtn"/>
			  </div>	
			  <center><span id="result" style="color:red;"></span></center>
			</div> 
	      </div>
	      <div class="modal-footer">
	        <center>
	        <button type="button" class="btn btn-primary" onclick="exportCode()">生成</button>
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        </center>
	      </div>
	    </div>
	  </div>
	</div>
	<script>
		var openExportModal = function(dbId,tableName){
			$("#myModal").modal("show");
			$("#dbId").val(dbId);
			$("#tableName").val(tableName);
		}
		var exportCode = function(){
			var dbId = $("#dbId").val();
			var tableName= $("#tableName").val();
			var projectName = $("#projectName").val();
			if(projectName==""){
				$("#projectName").focus();
				$("#projectName").css("border-color","red");
				return;
			}
			var moduleName = $("#moduleName").val();
			if(moduleName==""){
				$("#moduleName").focus();
				$("#moduleName").css("border-color","red");
				return;
			}
			$.ajax({
				'type': 'post',
				'url': "/exportCode?dbId="+dbId+"&tableName="+tableName+"&moduleName="+moduleName+"&projectName="+projectName,
				'dataType': 'json',
				'success': function(data) {
					var result = data.result?"生成成功":"生成失败";
					$("#result").text(result);
					$("#result").fadeIn("fast");
					$("#result").fadeOut(3000);
				},
				'error': function(data) {
					
				}
			});			
		}

	</script>
</body>
</html>