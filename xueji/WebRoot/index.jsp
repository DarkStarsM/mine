<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Sign in</title>
		<link rel="stylesheet" type="text/css"href="<%=path %>/css/index.css"/>
		<link rel="stylesheet" type="text/css"href="<%=path %>/css/iconfont.css"/>
	</head>
	<body>
		<div id="login-box">
			<h1>Login</h1>
			<div class="input-box">
				<i class="iconfont">&#xe609;</i>
				
				<input type="text" placeholder="UserName" />
			</div>
			<div class="input-box">
				<i class="iconfont">&#xe605;</i>
				<input type="password" placeholder="UserPassword" />
			</div>
			<button>Sign in</button>
		</div>
		
	</body>
</html>