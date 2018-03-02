<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<style type="text/css">
	table{
		border-collapse: collapse;
	}
	th,td{
		border:1px solid red;
	}
</style>
</head>
<body>
<form action="${pageContext.request.contextPath }/items/deleteItemsByids.do" method="post">
	<table>
		<tr>
			<th>ID</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品描述</th>
			<th>商品日期</th>
			<th>图片</th>
			<th>删除</th>
		</tr>
		<c:forEach var="item" items="${items }">
			<tr>
				<td>
					<input type="checkbox" name="ids" value="${item.id }" />
					${item.id }
				</td>
				<td>${item.name }</td>
				<td>${item.price }</td>
				<td>${item.detail }</td>
				<td>
					<fmt:formatDate value="${item.createtime }" pattern="yyyy-MM-dd" />
				</td>
				<td>${item.pic }</td>
				<td>
					<a href="updateItemsByID.do?id=${item.id}">修改</a>
					<a href="deleteItemsByID.do?id=${item.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7">
			<input type="submit" value="批量删除" />
			</td>
		</tr>
	</table>
	</form>
</body>
</html>