package com.city.office.document.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.city.office.document.Dao.INewsDao;
import com.city.office.document.factory.ConnectionFactory;
import com.city.office.document.factory.DaoFactory;
import com.city.office.document.model.NewsModel;
import com.city.office.document.service.INewsService;
//编写新闻业务接口实现类：NewsServiceImpl
//实现新闻业务接口INewsService定义的方法.
public class NewsServiceImpl implements INewsService {
//业务实现类中主要调用DAO层的方法，完成数据持久化 操作
//不能直接操作数据库，而是要通过调用DAO层对象来实现
//通过此业务实现类代码，看到由于连接数据库执行SQL的操作已经封装在DAO层对象中
//业务代码的编写相当容易，非常易于修改和维护，提高 了系统随业务变化的适应能力
	@Override
	public void add(NewsModel nm) throws Exception {
		
		DaoFactory.createINewsDao().create(nm);
	/* 代码示例  
	 * INewsDao idao=DaoFactory.createINewsDao();
		idao.create(nm);*/
	
	
	}

}
