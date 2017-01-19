package com.city.office.document.service;

import com.city.office.document.model.NewsModel;
//编写新闻业务接口
public interface INewsService {
	public void add(NewsModel nm) throws Exception;
}
