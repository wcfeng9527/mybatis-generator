<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
<%-- 	<a href="<%=request.getContextPath()%>/auth/users">跳转到users</a> --%>
	<br>
	<c:forEach var="code" items="${codeList}">
		${code }
		<br>
		<br>
		<br>
	</c:forEach>
	<br>
</body>
</html>