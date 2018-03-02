<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/items/updateItems.do" method="post">
		<input type="hidden" name="id" value="${items.id }" >
		<table>
			<tr>
				<td>商品名称</td>
				<td> <input type="text" name="name" value="${items.name }" /> </td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td> <input type="text" name="price" value="${items.price }" /> </td>
			</tr>
			<tr>
				<td>商品图片</td>
				<td> <input type="file" name="pic" /> </td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td> <input type="text" name="createtime" value="<fmt:formatDate value="${items.createtime }" pattern="yyyy/MM/dd" />" /> </td>
			</tr>
			<tr>
				<td>商品描述</td>
				<td> <textarea rows="10" cols="30" name="detail" >${items.detail }</textarea> </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>