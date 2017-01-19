<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>增加企业</h1>
<hr/>
<form action="add.do">
编号：<input type="text" name="id"/><br/>
名称：<input type="password" name="password"/><br/>
企业简介：<textarea rows="6" cols="8" type="text" name="jianjie"></textarea><br/>
员工人数：<input type="text" name="number"/>人<br/>
年销售额：<input type="text"name="total">万元<br/>
客户类型：<input name="customertype" type="radio" value="one">国有
<input name="customertype" type="radio" value="two">独资
<input name="customertype" type="radio" value="three">合资
<input name="customertype" type="radio" value="four">个体<br/>
经营范围：<input name="fanwei" type="checkbox" value="first">钢铁
 <input name="fanwei" type="checkbox" value="second">煤炭
 <input name="fanwei" type="checkbox" value="third">棉花
 <input name="fanwei" type="checkbox" value="fourth">食品<br/>
 <button type='submit'>提交</button>
<button type='button'>取消</button>


</body>
</html>