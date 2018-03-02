<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.form.js"></script>

<script type="text/javascript">
     function submitImgUpload(){
    	 
    	 //使用ajax提交表单
    	 $("#itemsForm").ajaxSubmit({
    		 type:'POST',
    		 url:'${pageContext.request.contextPath }/upload/uploadPic.do',
    		 dataType:'text',
    		 data:{
    			 fileName:'imgFile'
    		 },
    		 success:function(data){
    			 //把json格式的字符串 转换成json对象
    			 var jsonObj = $.parseJSON(data);
    			 
    			 //把返回的服务器图片路径设置给img标签
    			 $('#itemsImgSrc').attr("src",jsonObj.fullPath);
    			 
    			 //数据库保存相对路径
    			 $('#itemsImg').val(jsonObj.relativePath);
    			 
    		 }
    		 
    	 })
    	 
     }
</script>
</head>
<body>
	<form id="itemsForm" action="${pageContext.request.contextPath }/items/addItems.do" method="post">
		<table>
			<tr>
				<td>商品名称</td>
				<td> <input type="text" name="name" /> </td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td> <input type="text" name="price" /> </td>
			</tr>
			<tr>
				<td>商品图片</td>
				<td> <input type="file" name="imgFile" onchange='submitImgUpload()'  /> </td>
			</tr>
			<tr>
				<td></td>
				<td> 
					<img id='itemsImgSrc' src='${picPath }${items.pic }'  height="100" width="100" />
					<input type='hidden' id='itemsImg' name='pic' value='' reg="^.+$" tip="亲！您忘记上传图片了。" /> 
				</td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td> <input type="text" name="createtime" /> </td>
			</tr>
			<tr>
				<td>商品描述</td>
				<td> <textarea rows="10" cols="30" name="detail"></textarea> </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>