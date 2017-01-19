<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,com.sap.erp.stock.model.*"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="../css/oa.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="top"><%@ include file="../include/top.jsp" %></div>
<div id="left"><%@ include file="../include/left.jsp" %></div>
<div id="main">
产品检索：价格在
<form action="tomain.do">
<input type="text" name="low"/>到<input type="text" name="high"/>
<button type="submit">检索</button></form>
<table width=100% >
<tr bgcolor="#99ffff">
<td width="25%"><div align="center">产品号</div></td>
<td width="25%"><div align="center">产品名称</div></td>
<td width="25%"><div align="center">销售数量</div></td>
<td width="25%"><div align="center">销售金额</div></td>
</tr>
<c:forEach var="product" items="${productlist}">
<tr>
<td>${product.id}</td>
<td>${product.name}</td>
<td>${product.stock}</td>
<td>${product.price}</td>
</tr>
</c:forEach>
</table>
</div>
<div id="footer"><%@ include file="../include/footer.jsp" %></div>
</body>
</html>