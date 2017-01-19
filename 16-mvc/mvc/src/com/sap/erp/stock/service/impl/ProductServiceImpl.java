package com.sap.erp.stock.service.impl;

import java.util.List;

import com.sap.erp.stock.factory.DaoFactory;
import com.sap.erp.stock.model.ProductModel;
import com.sap.erp.stock.service.IProductService;

public class ProductServiceImpl implements IProductService {


	public List<ProductModel> getListBySearch(double lowPrice, double highPrice)
			throws Exception {
		
		
		return DaoFactory.createProductDao().getListBySearch(lowPrice, highPrice);
	}

}
