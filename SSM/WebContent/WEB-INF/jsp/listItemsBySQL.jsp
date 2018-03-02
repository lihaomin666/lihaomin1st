<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>条件查询</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/items/selectItemsBySQL.do" method="post">
		用户名：<input type="text" name="name" />
		评价：<input type="text" name="detail" />
		<input type="submit" value="提交" />
	</form>
	<table>
		<tr>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品描述</th>
			<th>商品日期</th>
			<th>图片</th>
		</tr>
		<c:forEach var="item" items="${listItems }">
			<tr>
				<td>${item.name }</td>
				<td>${item.price }</td>
				<td>${item.detail }</td>
				<td>
					<fmt:formatDate value="${item.createtime }" pattern="yyyy-MM-dd" />
				</td>
				<td>${item.pic }</td>
			</tr>
		</c:forEach>
</body>
</html>