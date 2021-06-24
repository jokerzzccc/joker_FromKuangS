<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title></title>
</head>
<body>
<h1>首页</h1>

<span>${username}</span>
<p>
	<a href="${pageContext.request.contextPath}/user/logout">注销</a>
</p>
</body>
</html>