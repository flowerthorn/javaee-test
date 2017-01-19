<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,com.sap.erp.model.*"%>
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
<form action="main.do">
<input type="text" name="low"/>到<input type="text" name="high"/>
<button type="submit">检索</button></form>
<table width=100% >
<tr bgcolor="#99ffff">
<td width="10%"><div align="center">产品号</div></td>
<td width="15%"><div align="center">产品名称</div></td>
<td width="15%"><div align="center">产品单价</div></td>
<td width="15%"><div align="center">库存数量</div></td>
<td width="15%"><div align="center">库存金额</div></td>
<td width="15%"><div align="center">单价情况</div></td>
<td width="15%"><div align="center">库存情况</div></td>
</tr>
<c:forEach var="product" items="${productlist}">
<tr>
<td>${product.id}</td>
<td>${product.name}</td>
<td>${product.price}</td>
<td>${product.stock}</td>
<td>${product.sum}</td>
<td>
<c:if test="${product.stock>100}">
高库存
</c:if>
<c:if test="${product.stock>20&&product.stock<100}">
中等库存
</c:if>
<c:if test="${product.stock<20 }">
低库存
</c:if>
</td>
<td>
<c:if test="${ product.sum>100}">
高价
</c:if>
<c:if test="${ product.sum>20&&product.sum<100}">
中价
</c:if>
<c:if test="${ product.sum<20}">
低价
</c:if>
</td>
</tr>
</c:forEach>
</table>
</div>
<div id="footer"><%@ include file="../include/footer.jsp" %></div>
</body>
</html>