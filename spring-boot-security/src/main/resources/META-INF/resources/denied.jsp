<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>denied</title>
</head>
<body>
	<div style="text-align: center">
		<h1>你的权限不够!</h1>
		<div id="login-error">当前账号：${loginName}</div>
		<p>只有拥有Admin权限才能访问!</p>
		<br /> 
		<br /> 
		<a href="${pageContext.request.contextPath }/main/common"> Go Common Page </a>
		<br/>
		<br/>
		<a href="${pageContext.request.contextPath }/auth/logout">退出登录</a>
	</div>
</body>
</html>