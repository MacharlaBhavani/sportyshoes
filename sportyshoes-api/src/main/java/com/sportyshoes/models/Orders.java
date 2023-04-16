package com.sportyshoes.models;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class Orders {
  private int orderno;
  private int productid;
  private Timestamp time;
  private int userid;
  private int quantity;
  
  public Orders() {}

public Orders(int productid, Timestamp time, int userid, int quantity) {
	super();
	this.productid = productid;
	this.time = time;
	this.userid = userid;
	this.quantity = quantity;
}



public Orders(int productid, int userid, int quantity) {
	super();
	this.productid = productid;
	this.userid = userid;
	this.quantity = quantity;
}

public int getOrderno() {
	return orderno;
}

public void setOrderno(int orderno) {
	this.orderno = orderno;
}

public int getProductid() {
	return productid;
}

public void setProductid(int productid) {
	this.productid = productid;
}

public Timestamp getTime() {
	return time;
}

public void setTime(Timestamp time) {
	this.time = time;
}

public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

@Override
public String toString() {
	return "Orders [orderno=" + orderno + ", productid=" + productid + ", time=" + time + ", userid=" + userid
			+ ", quantity=" + quantity + "]";
}
  
  

}
