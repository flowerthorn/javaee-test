package com.city.office.document.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.city.office.document.Dao.INewsDao;
import com.city.office.document.factory.ConnectionFactory;
import com.city.office.document.model.NewsModel;
//编写新闻DAO接口实现类：NewsDaoImpl 
//实现Dao接口INewsDao的所有方法.
public class NewsDaoImpl implements INewsDao {

	@Override
	public void create(NewsModel nm) throws Exception {
		// TODO Auto-generated method stub
		try{
		String sql="insert into OA_News values(?,?,?,?,?)";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1,nm.getNewsno());
		ps.setString(2, nm.getSubject());
		ps.setString(3,nm.getContent());
		ps.setString(4,nm.getNewsdate());
		ps.setString(5, nm.getAuthor());
		ps.executeUpdate();
		ps.close();
		cn.close();}catch(Exception e){
			e.printStackTrace();
			System.out.println("数据库连接错误！");
		}
	}

}
