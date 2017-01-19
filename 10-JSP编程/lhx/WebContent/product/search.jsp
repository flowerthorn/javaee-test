<%@page import="com.city.erp.model.ProductModel"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,java.sql.*,com.city.erp.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/oa.css">
</head>
<body>
<div id="top">
<%@ include file="../include/top.jsp" %>
</div>
<div id="mainarea" >
<div id="left"><%@ include file="../include/left.jsp" %></div>
<div id="main">
<% List<ProductModel> list=(List<ProductModel>)request.getAttribute("emplist"); %>
产品检索：价格在
<form action="search.do" >
<input type="text" name="low"/>到<input type="text" name="high"/>
<button type="submit">检索</button></form>
<table width=100% >
<tr bgcolor="#99ffff">
<td width="25%"><div align="center">编号</div></td>
<td width="25%"><div align="center">名称</div></td>
<td width="25%"><div align="center">单价</div></td>
<td width="25%"><div align="center">库存数量</div></td>
</tr>
<% 
if(list!=null){
for(ProductModel pm:list) {%>
<tr>
<td><%=pm.getProductID()%></td>
<td><%=pm.getProductName()%></td>
<td><%=pm.getUnitPrice()%></td>
<td><%=pm.getUnitsInStock()%></td>
</tr>
<%}} %>
</table>
</div>
<div id="right"><%@ include file="../include/right.jsp" %></div>
<%-- <div id="main"><%@ include file="../include/main.jsp" %></div> --%>
</div>
<div id="footer"><%@ include file="../include/footer.jsp" %></div>
</body>
</html>