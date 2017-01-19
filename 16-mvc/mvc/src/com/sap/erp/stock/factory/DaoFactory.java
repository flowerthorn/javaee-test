package com.sap.erp.stock.factory;

import com.sap.erp.stock.dao.IProductDao;
import com.sap.erp.stock.dao.impl.ProductDaoImpl;



public class DaoFactory {
	public static IProductDao createProductDao() {
		return new ProductDaoImpl();
		
	}
}
