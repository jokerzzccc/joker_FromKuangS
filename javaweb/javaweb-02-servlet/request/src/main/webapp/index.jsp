<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<title>Login</title>
</head>
<body>

<h1>Login</h1>
<div>
	<!-- 用post方式提交表单，提交到我们的login请求 -->
	<form action="${pageContext.request.contextPath}/login" method="post">
		用户名：<input type="text" name="username"><br>
		密码：<input type="password" name="password"><br>
		爱好：
		<input type="checkbox" name="hobbies" value="女孩">女孩
		<input type="checkbox" name="hobbies" value="男孩">男孩
		<input type="checkbox" name="hobbies" value="lol">lol
		<input type="checkbox" name="hobbies" value="basketball">篮球

		<br>
		<input type="submit">
	</form>
</div>
</body>
</html>