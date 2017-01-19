package com.city.erp.business.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.erp.model.ProductModel;

public class ProductBusinessImpl {

	public List<ProductModel> getListBySearch(double low,double high) throws Exception{
		Connection cn=null;
		List<ProductModel> list=new ArrayList<ProductModel>();
		String sql="select ProductID,ProductName,UnitPrice,UnitsInStock from Products where UnitPrice between ? and ?";
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		cn=DriverManager.getConnection("jdbc:odbc:db");
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setDouble(1, low);
		ps.setDouble(2, high);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
		ProductModel pm=new ProductModel();
		pm.setProductID(rs.getInt("ProductID"));
		pm.setProductName(rs.getString("ProductName"));
		pm.setUnitPrice(rs.getDouble("UnitPrice"));
		pm.setUnitsInStock(rs.getInt("UnitsInStock"));
		list.add(pm);
		}rs.close();
		ps.close();
		cn.close();
		return list;
	}
}
