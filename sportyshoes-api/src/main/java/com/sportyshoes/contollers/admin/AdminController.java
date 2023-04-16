package com.sportyshoes.contollers.admin;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Orders;
import com.sportyshoes.models.Products;
import com.sportyshoes.services.AdminService;
import com.sportyshoes.services.UserService;

@RestController
public class AdminController {
	
	
	@Autowired
	AdminService adminservice;
	
	
	@Autowired
	UserService userservice;
			
	@PatchMapping("/api/admin/{adminid}/update/password")
	public String updateadmin(@RequestParam String name,@RequestParam String password) {
		 boolean is=adminservice.update(name, password);
		 
		 if(is) {
			 return "updated";
		 }else {
			 return "not updated";
		 }
				
	}
	
	@PostMapping("/api/admin/sigIn")
	public String signin(@RequestParam String name,@RequestParam String password) {
		boolean in=adminservice.signin(name, password);
		if(in) {
			return "valid";
		}else {
			return "unvalid";
		}
	}
	
   @PostMapping("/api/admin/add")	
   public String insert(@RequestBody Products products) {
	  Boolean ins=adminservice.insert(products);
		   if(ins) {
			   return "product added";
		   }else {
			   return "product not added";
		   }
   }
   
   @GetMapping("/api/products/search/productid")
   public Products search(@RequestParam String productid) {
	   return adminservice.search(Integer.parseInt(productid));
   }
   
   @DeleteMapping("/api/products/delete/productid")
   public String delete(@RequestParam String productid) {
	   Boolean  del=adminservice.delete(Integer.parseInt(productid));
	   if(del) {
		   return "product deleted";
	   }else {
		   return "product not deleted";
	   }
   }
   
   @PatchMapping("/api/admin/products/productid/update/productname")
   public String updateproductname(@RequestParam String productid,@RequestParam String productname) {
	   Boolean updproname=adminservice.updateproductname(Integer.parseInt(productid), productname);
	     if(updproname) {
	    	 return "productname updated";
	     }else {
	    	 return "productname not update";
	     }
	   }
   @PatchMapping("/api/admin/products/productid/update/msrp")
   public String updatemsrp(@RequestParam String productid,@RequestParam String msrp) {
	   Boolean updmsrp=adminservice.updatemsrp(Integer.parseInt(productid),Integer.parseInt(msrp));
	     if(updmsrp) {
	    	 return "msrp updated";
	     }else {
	    	 return "msrp not update";
	     }
	   }
   @PatchMapping("/api/admin/products/productid/update/quantity")
   public String updatequntity(@RequestParam String productid,@RequestParam String quantity) {
	   Boolean updquantity=adminservice.updatequantity(Integer.parseInt(productid),Integer.parseInt(quantity));
	     if(updquantity) {
	    	 return "quantity updated";
	     }else {
	    	 return "quantity not update";
	     }
	   }
   @PatchMapping("/api/admin/products/productid/update/vendor")
   public String updatevendor(@RequestParam String productid,@RequestParam String vendor) {
	   Boolean updvendor=adminservice.updatevendor(Integer.parseInt(productid),vendor);
	     if(updvendor) {
	    	 return "vendor updated";
	     }else {
	    	 return "vendor not update";
	     }
	   }
   @CrossOrigin(origins = "http://localhost:4200")
   @GetMapping("/api/admin/allproducts")
   public List<Products> allproducts(){
	     List<Products> all=adminservice.allproducts();
	     return all;
	    
	   }
     
  @PostMapping("/api/admin/order") 
  public String orders(@RequestBody Orders orders){
	  	  Boolean produ=adminservice.byone(orders.getProductid());
	  	  
	  	  Boolean  value=userservice.byid(orders.getUserid());
	  	  Integer quantity=adminservice.bypid(orders.getProductid());
	  if(produ&&value&&quantity>0&&quantity>orders.getQuantity()){
		  
	       Integer order=adminservice.orders(orders);
	       int updated=quantity-orders.getQuantity();
	       adminservice.updatequantity(orders.getProductid(),updated);
	  	  if(order>0){
		     return "your order confirmed";
	      }else {
	    	  return "your order not confirmed";
	      }
	   }else{
		   return "productid or userid or quantity are not available";
	   }
	   
  }
	
		  
  
  @GetMapping("/api/admin/byuserid")
  public List<Orders> byuserid(@RequestParam int userid){
	  return adminservice.byuserid(userid);
  }
  
  @GetMapping("/api/admin/allorders")
  public List<Orders> allorders(){
	  return adminservice.allorders();
  }
  @GetMapping("/api/admin/bydateace")
  public List<Orders> bydateace(){
	 return adminservice.bydateace();
  }
  @GetMapping("/api/admin/byorderidace")
  public List<Orders> byorderidace(){
	 return adminservice.bydateace();
  }
  @GetMapping("/api/admin/byorderiddec")
  public List<Orders> byorderiddec(){
	 return adminservice.byorderiddec();
  }
  @GetMapping("/api/admin/bydatedec")
  public List<Orders> bydatedec(){
	 return adminservice.bydatedec();
  }
  @GetMapping("/api/products/bypid/productid")
  public Integer bypid(@RequestParam String productid) {
	   return adminservice.bypid(Integer.parseInt(productid));
  }
  
}
