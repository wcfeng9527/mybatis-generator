<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表的字段明细</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
</head>
<body>
	<br>
	
	<table class="table">
		<c:forEach var="cl" items="${columns }">
			<tr>
				<td>${cl.table_schema }</td>
				<td>${cl.table_name }</td>
				<td>${cl.column_name }</td>
				<td>${cl.ordinal_position }</td>
				<td>${cl.column_default }</td>
				<td>${cl.is_nullable }</td>
				<td>${cl.data_type }</td>
				<td>${cl.column_type }</td>
				<td>${cl.column_comment }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>