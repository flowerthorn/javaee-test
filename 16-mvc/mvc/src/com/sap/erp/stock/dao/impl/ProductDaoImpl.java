package com.sap.erp.stock.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sap.erp.stock.dao.IProductDao;
import com.sap.erp.stock.factory.ConnectionFactory;
import com.sap.erp.stock.model.ProductModel;

public class ProductDaoImpl implements IProductDao {


	public List<ProductModel> getListBySearch(double lowPrice, double highPrice)
			throws Exception {
		List<ProductModel> productlist=new ArrayList<ProductModel>();
		try{
			String sql="select ProductID,ProductName,UnitPrice,UnitsInStock from Products where UnitPrice between ? and ?";
			Connection cn=ConnectionFactory.getConnection();
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setDouble(1, lowPrice);
			ps.setDouble(2, highPrice);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			ProductModel pm=new ProductModel();
			pm.setId(rs.getInt("ProductID"));
			pm.setName(rs.getString("ProductName"));
			pm.setPrice(rs.getDouble("UnitPrice"));
			pm.setStock(rs.getInt("UnitsInStock"));
			productlist.add(pm);
				}
				rs.close();ps.close();
				cn.close();	
			}catch(Exception e ){
			e.printStackTrace();
		}
	return productlist;
	}

}
