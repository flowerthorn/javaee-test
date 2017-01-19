<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,com.sap.erp.value.*"%>
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
<form action="search.do">
<table width=%100>
<h1>产品检索</h1>

</table>


名称<input type="text" name="name"/> 最高库存<input type="text" name="stock"/><br/>
最低价<input type="text" name="low"/>最高价<input type="text" name="high"/><br/>
<button type="submit">提交</button>
</form>
<table width=100% >
<tr>检索结果</tr>
<tr bgcolor="#FFDAB9">
<td width="25%"><div align="center">产品编号</div></td>
<td width="25%"><div align="center">产品名称</div></td>
<td width="25%"><div align="center">产品单价</div></td>
<td width="25%"><div align="center">库存数量</div></td>
</tr>
<c:forEach var="product" items="${list}">
<tr>
<td>${product.id}</td>
<td>${product.name}</td>
<td>${product.price}</td>
<td>${product.stock}</td>
</tr>
</c:forEach>
</table>
</div>
</div><div id="footer"><%@ include file="../include/footer.jsp" %></div>
</body>
</html>