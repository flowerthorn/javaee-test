package com.sap.erp.business.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;






import com.sap.erp.factory.ConnectionFactory;
import com.sap.erp.value.ProductValue;

public class ProductImpl {
	public List<ProductValue> getListBySearch(String name, 
			int highStock, double lowPrice, 
			double highPrice) throws Exception{
		List<ProductValue> list=new ArrayList<ProductValue>();
		String sql="select ProductID,ProductName,UnitPrice,UnitsInStock from Products where UnitPrice between ? and ? and ProductName like '%"+name+"%' and UnitsInStock<=?";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setDouble(1, lowPrice);
		ps.setDouble(2, highPrice);
		
		ps.setInt(3, highStock);
		
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			ProductValue pv=new ProductValue();
			pv.setId(rs.getInt("ProductID"));
			pv.setName(rs.getString("ProductName"));
			pv.setPrice(rs.getDouble("UnitPrice"));
			pv.setStock(rs.getInt("UnitsInStock"));
			list.add(pv);
		}
		rs.close();
		ps.close();
		cn.close();	
		return  list;
		
		
	}
}
