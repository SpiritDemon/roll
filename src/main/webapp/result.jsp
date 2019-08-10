<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<base href="<%=basePath%>">
		<title>Insert title here</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${flag==0}">
				${r.username}，你是第${r.id}位，你在
				<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${r.time}"/>
				抽到数字
				<font size='16px' color='red'>
					${r.rollValue}
				</font>
				<hr />
				<table style="margin: 0px auto;">
					<tr height='27px'>
						<th width='32px'>ID</th>
						<th width='120px'>名称</th>
						<th width='50px'>roll点</th>
						<th width='170px'>时间</th>
					</tr>
					<c:forEach items="${list}" var="roll">
						<tr height='27px'>
						<td>${roll.id}</td>
						<td>${roll.username}</td>
						<td>${roll.rollValue}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${roll.time}"/></td>
					</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:when test="${flag==1}">
				必须输入名称！
			</c:when>
			<c:when test="${flag==2}">
				你已经roll过了，不要用别人的名称再roll一次，可输入自己的名称查看结果
			</c:when>
			<c:when test="${flag==3}">
				服务器繁忙，请稍后再试！
			</c:when>
			<c:when test="${flag==null}">
				<c:redirect url="index.jsp"/>
			</c:when>
		</c:choose>
	</body>
</html>
