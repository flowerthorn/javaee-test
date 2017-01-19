<%@page import="com.city.oa.model.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="../css/oa.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="top">
<%@ include file="../include/top.jsp" %>
</div>

<div id="left"><%@ include file="../include/left.jsp" %></div>
<div id="main">
<h1>增加员工</h1>
<form action="add.action">
账号：<input type="text" name="id"/><br/>
姓名：<input type="text" name="name"/><br/>
性别：<input name="sex "type="radio"  value="boy" />男
     <input name="sex "type="radio"  value="girl" />女<br/>
年龄：<input type="text" name="age"/><br/>
工资：<input type="text" name="sal"/><br/>
<br/>
<br/>
 <button type='submit'>提交</button>
 </form>
</div>
<%-- <div id="right"><%@ include file="../include/right.jsp" %></div> --%>

<div id="footer"><%@ include file="../include/footer.jsp" %></div>
</body>
</html>