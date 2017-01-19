package com.sap.erp.stock.dao;

import java.util.List;

import com.sap.erp.stock.model.ProductModel;

public interface IProductDao {
	public List<ProductModel> getListBySearch(double lowPrice,double highPrice) 
			throws Exception;
}
