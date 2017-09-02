<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据库列表</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
</head>
<body>	
	<div class="container well" style="margin-top:50px;width:550px;" >
		<input type="button" class="btn btn-primary pull-right" name="" value="添加" onclick="addDB()" />
		<center><h3>数据库列表</h3></center>	
		<table class="table">
			<thead>
				<th>数据库名</th>
				<th>操作</th>			
			</thead>
			<tbody>
				<c:forEach var="db" items="${dbList}">
					<tr>
						<td><a href="tablelist/${db.id}">${db.showName }</a></td>
						<td><a href="tablelist/${db.id}">查看数据库中表</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>	
	<script type="text/javascript">
		function addDB(){
			window.location.href="/db/addDB";
		}	
	</script>
</body>
</html>