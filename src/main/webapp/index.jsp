<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<base href="<%=basePath%>">
		<title>Spirit Demon roll奖系统</title>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<script src="js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/ajax.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<h3 align="center">Spirit Demon roll奖系统</h3>
		<div id="div01">
			请输入你的名称：<input type="text" name="username" id="username" value=""/>
			<input type="button" id="roll" value="roll"/><br />
		</div>
		<div id="div02"></div>
	</body>
</html>
