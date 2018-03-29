<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>登录</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>

	<div class="error">错误消息: ${error}</div>
	<form action="login" method="post">
		用户名：<input type="text" name="un" value="develop"><br /> 
		密码：<input type="password" name="ps" value="123456"><br /> 
		token: <input type="text" name="tks" value="654321"><br /> 
			<input type="submit" value="登录">
	</form>

</body>
</html>
