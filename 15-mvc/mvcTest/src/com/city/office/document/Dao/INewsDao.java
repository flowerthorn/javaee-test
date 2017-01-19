package com.city.office.document.Dao;

import com.city.office.document.model.NewsModel;
//DAO接口
public interface INewsDao {
	//功能是将值类对象表达的新闻增加到表News中
	public void create(NewsModel nm) throws Exception;;
}
