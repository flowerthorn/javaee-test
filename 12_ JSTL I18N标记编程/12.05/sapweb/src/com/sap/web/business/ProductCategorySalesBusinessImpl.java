package com.sap.web.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sap.web.value.ProductCategorySalesValue;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class ProductCategorySalesBusinessImpl {
	
	public List< ProductCategorySalesValue > getSalesList() throws Exception{
		String sql="select c.CategoryID cid,c.CategoryName cname,SUM(od.UnitPrice*od.Quantity) ouq from Products p,[Order Details] od,Categories c where p.CategoryID=c.CategoryID and od.ProductID=p.ProductID group by c.CategoryID,c.CategoryName";
		List<ProductCategorySalesValue> values=new ArrayList<>();
		try{
		    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    Connection cn=DriverManager.getConnection("jdbc:odbc:oa");
	 		PreparedStatement ps=cn.prepareStatement(sql);
   		    ResultSet rs=ps.executeQuery();
	    	while(rs.next()){
	    		ProductCategorySalesValue value=new ProductCategorySalesValue();
	    		value.setId(rs.getInt("cid"));
	    		value.setName(rs.getString("cname"));
	    		value.setSalary(rs.getFloat("ouq"));
	    		values.add(value);
	    	}
	    	rs.close();
	    	ps.close();
	    	cn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return values;
	}
}
