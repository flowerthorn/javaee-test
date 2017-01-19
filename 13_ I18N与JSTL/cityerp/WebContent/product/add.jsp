<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<link rel="stylesheet" type="text/css" href="../css/oa.css">
<head>
<fmt:setBundle basename="com.city.erp.message.message.MessageText"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="top">
<%@ include file="../include/top.jsp" %></div>
<div id="left"><%@ include file="../include/left.jsp" %></div>
<div id="main">
<h1><fmt:message key="product.add.h1"></fmt:message></h1>
<form action="add.action">
<fmt:message key="product.add.id"></fmt:message><input type="text" name="pid"/><br/>
<fmt:message key="product.add.name"></fmt:message><input type="text" name="name"/><br/>
<fmt:message key="product.add.price"></fmt:message><input type="text" name="price"/><br/>
<fmt:message key="product.add.qty"></fmt:message><input type="text" name="qty"/><br/>
<fmt:message key="product.add.cno"></fmt:message>
<select name="cno" >
<option value="1"><fmt:message key="product.add.clothes"></fmt:message></option>
<option value="2"><fmt:message key="product.add.th"></fmt:message></option>
</select><br/>
 <button type='submit'><fmt:message key="product.add.submit"></fmt:message></button>
</form>
</div>
<div id="footer"> <%@ include file="../include/footer.jsp" %></div>
</body>
</html>