package com.sap.erp.business.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sap.erp.model.ProductModel;

public class ProductBusinessImpl {
	public List<ProductModel> getListBySearch(double low,double high) throws Exception{
		List<ProductModel> productlist=new ArrayList<ProductModel>();
		String sql="select ProductID,ProductName,UnitPrice,UnitsInStock,SUM(UnitPrice*UnitsInStock)as sum from Products where UnitPrice between ? and ? group by ProductID,ProductName,UnitPrice,UnitsInStock";
		Connection cn=null;
		try {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		cn=DriverManager.getConnection("jdbc:odbc:db");
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setDouble(1, low);
		ps.setDouble(2, high);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
		ProductModel pm=new ProductModel();
		pm.setId(rs.getInt("ProductID"));
		pm.setName(rs.getString("ProductName"));
		pm.setPrice(rs.getDouble("UnitPrice"));
		pm.setStock(rs.getInt("UnitsInStock"));
		pm.setSum(rs.getDouble("sum"));
		productlist.add(pm);
			}
			rs.close();ps.close();
			cn.close();	
		} catch (Exception e) {
		e.printStackTrace();
		}
			return productlist;
		}		
	}

