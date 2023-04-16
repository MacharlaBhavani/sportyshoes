package com.sportyshoes.models;

import org.springframework.stereotype.Component;

@Component
public class Products {
 private int productid;
 private String productname;
 private int msrp;
 private int quantity;
 private String vendor;
 
 public Products() {}

public Products(int productid, String productname, int msrp, int quantity, String vendor) {
	super();
	this.productid = productid;
	this.productname = productname;
	this.msrp = msrp;
	this.quantity = quantity;
	this.vendor = vendor;
}

public Products(String productname, int msrp, int quantity, String vendor) {
	super();
	this.productname = productname;
	this.msrp = msrp;
	this.quantity = quantity;
	this.vendor = vendor;
}

public int getProductid() {
	return productid;
}

public void setProductid(int productid) {
	this.productid = productid;
}

public String getProductname() {
	return productname;
}

public void setProductname(String productname) {
	this.productname = productname;
}

public int getMsrp() {
	return msrp;
}

public void setMsrp(int msrp) {
	this.msrp = msrp;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public String getVendor() {
	return vendor;
}

public void setVendor(String vendor) {
	this.vendor = vendor;
}

@Override
public String toString() {
	return "Products [productid=" + productid + ", productname=" + productname + ", msrp=" + msrp + ", quantity="
			+ quantity + ", vendor=" + vendor + "]";
}
 



}
