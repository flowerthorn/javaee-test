package com.sap.erp.stock.service;

import java.util.List;

import com.sap.erp.stock.model.ProductModel;

public interface IProductService {
	public List<ProductModel> getListBySearch(double lowPrice,double highPrice) 
			throws Exception;
}
