<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>登陆页面</h1>
<form action="login.do" method="post">
ID:<input type="text" name="userid"/><br/>
密码：<input type="password" name="ps"><br/>
ID选项：<input type="radio" name="choice" value="day">保存一日
<input type="radio" name="choice" value="week">保存一周<br/>
<input type="submit" value="提交"/>

</form>
</body>
</html>