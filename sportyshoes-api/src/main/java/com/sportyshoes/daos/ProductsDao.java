package com.sportyshoes.daos;


import java.util.List;

import org.springframework.stereotype.Component;

import com.sportyshoes.models.Products;

@Component
public interface ProductsDao {
	public Integer insert(Products products);
	public Products search(int productid);
	public Integer delete(int productid);
	public Boolean updateproductname(int productid,String productname);
	public Boolean updatemsrp(int productid,int msrp);
	public Boolean updatequantity(int productid,int quantity);
	public Boolean updatevendor(int productid,String vendor);
	public List<Products> allProducts();
	public Boolean byone(int productid);
	public Integer  bypid(int productid);
	

}
