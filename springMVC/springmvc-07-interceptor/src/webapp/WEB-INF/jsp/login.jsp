<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title></title>
</head>
<body>
<!-- 在web-inf 下的所有页面或者资源，只能通过controller,或者servlet进行访问  -->

<h1>登录页面</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">
	用户名<input type="text" name="username">
	密码<input type="text" name="password">
	<input type="submit" value="提交">
</form>
</body>
</html>