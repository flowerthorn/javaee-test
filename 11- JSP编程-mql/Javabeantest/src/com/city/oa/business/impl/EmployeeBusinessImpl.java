package com.city.oa.business.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.city.oa.model.EmployeeModel;


public class EmployeeBusinessImpl {
	public void add(EmployeeModel em) throws Exception{
		String sql="insert into emp values(?,?,?,?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cityoa","root","root");
		PreparedStatement ps=cn.prepareStatement(sql);
	    ps.setString(1,em.getId());
	    ps.setString(2, em.getName());
	    ps.setString(3, em.getSex());
	    ps.setInt(4, em.getAge());
		ps.setDouble(5, em.getSal());
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}
}
