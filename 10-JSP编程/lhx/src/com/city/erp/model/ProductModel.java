package com.city.erp.model;

public class ProductModel {
  private int ProductID=0;
  private String ProductName=null;
  private double UnitPrice=0.0;
  private int UnitsInStock=0;
  public ProductModel(){	  
  }
public int getProductID() {
	return ProductID;
}
public void setProductID(int productID) {
	ProductID = productID;
}
public String getProductName() {
	return ProductName;
}
public void setProductName(String productName) {
	ProductName = productName;
}
public double getUnitPrice() {
	return UnitPrice;
}
public void setUnitPrice(double unitPrice) {
	UnitPrice = unitPrice;
}
public int getUnitsInStock() {
	return UnitsInStock;
}
public void setUnitsInStock(int unitsInStock) {
	UnitsInStock = unitsInStock;
}
  
}
