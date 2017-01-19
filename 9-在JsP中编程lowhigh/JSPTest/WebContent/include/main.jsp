<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="java.util.*,java.sql.*"%>
产品检索：价格在
<html>
<form action="search.jsp" >
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
Connection cn=null;
try{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	cn=DriverManager.getConnection("jdbc:odbc:db2");
	String sql="select ProductID,ProductName,UnitPrice,UnitsInStock from Products where UnitPrice between ? and ?";
	
	PreparedStatement ps=cn.prepareStatement(sql);
	double low=0;double high=0;
	String slow=request.getParameter("low");
	if(slow!=null){
		low=Double.parseDouble(slow);	
	}
	String shigh=request.getParameter("high");
	if(shigh!=null){
		high=Double.parseDouble(shigh);
	}
	ps.setDouble(1, low);
	ps.setDouble(2, high);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
{  String ProductID=rs.getString("ProductID");
String ProductName=rs.getString("ProductName");
String UnitPrice=rs.getString("UnitPrice");
String UnitsInStock=rs.getString("UnitsInStock");%>
<tr><td><%=ProductID %></td>
<td><%=ProductName %></td>
<td><%=UnitPrice%></td>
<td><%=UnitsInStock %></td>
</tr>
<%
		}}catch(Exception e){
			e.printStackTrace();
 %>
 <h4>出现错误</h4>
 <% 
		}finally{
			cn.close();
		}
%>
</table>
</html>