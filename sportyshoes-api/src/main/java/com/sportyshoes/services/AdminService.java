package com.sportyshoes.services;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Orders;
import com.sportyshoes.models.Products;
import com.sportyshoes.repositories.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	AdminRepo adminrepo;
	
	public boolean update(String name, String password) {
		
		return adminrepo.updatePassword(name, password)>0;
	}
  public Boolean signin(String name,String password) {
	  return adminrepo.signin(name, password);
  }
  
  public Boolean insert(Products products) {
	  return adminrepo.insert(products)>0;
  }
  public Products search(int productid){
	  return adminrepo.search(productid);
  }
  public Boolean delete(int productid) {
	  return adminrepo.delete(productid)>0;
  }
  public Boolean updateproductname(int productid,String productname) {
	  return adminrepo.updateproductname(productid, productname);
  }
  public Boolean updatemsrp(int productid,int msrp) {
	  return adminrepo.updatemsrp(productid,msrp);
  }
  public Boolean updatequantity(int productid,int quantity) {
	  return adminrepo.updatequantity(productid, quantity);
  }
  public Boolean updatevendor(int productid,String vendor) {
	  return adminrepo.updatevendor(productid,vendor);
  }
  public List<Products> allproducts(){
	  return adminrepo.allProducts();
  }
 
  public Integer orders(Orders orders) {
	  return adminrepo.order(orders);
  }
  public List<Orders> byuserid(int userid){
	  return adminrepo.byuserid(userid);
  }
  public Boolean byone(int productid) {
	  return adminrepo.byone(productid);
  }
  public List<Orders> allorders(){
	  return adminrepo.allorders();
  }
   public List<Orders> bydateace(){
	  return adminrepo.bydateace();
  }
   public List<Orders> byorderidace(){
		  return adminrepo.bydateace();
	  }
   public List<Orders> byorderiddec(){
		  return adminrepo.byorderiddec();
	  }
	   public List<Orders> bydatedec(){
			  return adminrepo.bydatedec();
		  }
	   public Integer bypid(int productid) {
			  return adminrepo.bypid(productid);
		  }
}
