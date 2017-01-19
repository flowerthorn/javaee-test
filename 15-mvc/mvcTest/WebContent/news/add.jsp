<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 编写表单输入新闻表对应的所有字段.
表单内容根据表自动确定，提交后到增加新闻Servlet. -->
	<form action="add.action">
		编号<input type="text" name="no" /><br /> 
		标题<input type="text"name="subject" /><br /> 
		内容<input type="text" name="content" /><br />
		日期<input type="text" name="date" /><br /> 
		作者<input type="text"name="author" /><br />
		<button type="submit">提交</button>
	</form>
</body>
</html>