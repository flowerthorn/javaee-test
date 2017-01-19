package com.sap.erp.stock.factory;

import com.sap.erp.stock.service.IProductService;
import com.sap.erp.stock.service.impl.ProductServiceImpl;

public class ServiceFactory {
public static IProductService createIProductService(){
	return new ProductServiceImpl();
}
}
