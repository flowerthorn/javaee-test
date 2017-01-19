package com.sap.erp.model;

public class ProductModel {
private int id=0;
private String name=null;
private double price=0;
private int stock=0;
private double sum=0;
public double getSum() {
	return sum;
}
public void setSum(double sum) {
	this.sum = sum;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
}
