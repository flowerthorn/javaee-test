package com.city.office.document.factory;

import com.city.office.document.Dao.impl.NewsDaoImpl;
import com.city.office.document.Dao.INewsDao;

public class DaoFactory {
//取得DAO接口的对象 为上层业务SO对象提供服务
//避免了上层对象SO直接使用new DAO实现类的模式
//解除了上层业务层SO实现类对象与DAO实现类对象的耦合，提高了系统的可维护性
	
	public static INewsDao createINewsDao(){
		return new NewsDaoImpl();
	}
}
