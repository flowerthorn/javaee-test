package com.city.erp.business.impl;

import java.sql.DriverManager;

import com.city.erp.model.ProductModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ProductBusinessImpl {
	//功能：增加产品到产品表
	public void add(ProductModel pm) throws Exception{
	String sql="insert into Products values(?,?,?,?,?)";
	Class.forName("com.mysql.jdbc.Driver");
	Connection cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cityerp","root","root");
	PreparedStatement ps=(PreparedStatement) cn.prepareStatement(sql);
	ps.setString(1,pm.getPid());
    ps.setString(2,pm.getPname() );
    ps.setDouble(3,pm.getPrice());
    ps.setInt(4,pm.getQty());
	ps.setInt(5,pm.getCno());
	ps.executeUpdate();
	ps.close();
	cn.close();
		
	}
}
