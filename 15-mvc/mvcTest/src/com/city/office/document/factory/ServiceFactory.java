package com.city.office.document.factory;

import com.city.office.document.service.INewsService;
import com.city.office.document.service.impl.NewsServiceImpl;

//有静态方法取得业务新闻业务接口对象。
//CO 要得到业务层SO对象，需要通过业务工厂类的静态方法取得指定的业务接口对象

public class ServiceFactory {
public static INewsService createINewsService(){
	return new NewsServiceImpl();
}
}
