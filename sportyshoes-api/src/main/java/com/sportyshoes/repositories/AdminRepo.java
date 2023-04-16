package com.sportyshoes.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.daos.AdminDao;
import com.sportyshoes.daos.OrdersDao;
import com.sportyshoes.daos.ProductsDao;
import com.sportyshoes.models.Admin;
import com.sportyshoes.models.Orders;
import com.sportyshoes.models.Products;
import com.sportyshoes.models.Users;
import com.sportyshoes.utils.DatabaseConnection;

@Repository
public class AdminRepo implements AdminDao,ProductsDao,OrdersDao{
	
	@Autowired
	DatabaseConnection dbconnection;
	
	@Autowired
	Admin admin;
	
	@Autowired
	Products products;
	
	@Autowired
	Users user;
	@Autowired
	Orders orders;

	@Override
	public Integer updatePassword(String name, String password) {
		String update="UPDATE admin SET password=? WHERE name=?";
		 
			try(PreparedStatement statement=dbconnection.getConnection().prepareStatement(update);){
				statement.setString(1,password);
				statement.setString(2,name);
				return statement.executeUpdate();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean signin(String name, String password) {
		boolean valid=false;
		String signin="SELECT * FROM admin WHERE name=? AND password=?";
		try(PreparedStatement statement=dbconnection.getConnection().prepareStatement(signin);){
			
			statement.setString(1,name);
			statement.setString(2,password);
			ResultSet rs=statement.executeQuery();
			   if(rs.next()) {
				   admin.setName(rs.getString("name"));
				   admin.setPassword(rs.getString("password"));
				   valid=true;
			   }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valid;
	}

	@Override
	public Integer insert(Products products) {
		String in="INSERT INTO products(productname,MSRP,quantity,vendor)VALUES(?,?,?,?)";
		try(PreparedStatement statement=dbconnection.getConnection().prepareStatement(in);){
			
			 statement.setString(1,products.getProductname());
			 statement.setInt(2,products.getMsrp());
			 statement.setInt(3,products.getQuantity());
			 statement.setString(4,products.getVendor());
			 
			 return statement.executeUpdate();
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Products search(int productid) {
		String sea="select * from products where productid=?";
		try(PreparedStatement statement=dbconnection.getConnection().prepareStatement(sea);){
			statement.setInt(1,productid);
			ResultSet rs=statement.executeQuery();
			if(rs.next()) {
			  products.setProductid(rs.getInt("productid"));
			  products.setProductname(rs.getString("productname"));
			  products.setMsrp(rs.getInt("msrp"));
			  products.setQuantity(rs.getInt("quantity"));
			  products.setVendor(rs.getString("vendor"));
			  
			  return products;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Integer delete(int productid) {
		String del="delete from products where productid=?";
		try(PreparedStatement statement=dbconnection.getConnection().prepareStatement(del);){
			statement.setInt(1,productid);
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Boolean updateproductname(int productid,String productname) {
		String upd="update products set productname=?  where productid=? ";
		try(PreparedStatement statement=dbconnection.getConnection().prepareStatement(upd);){
			statement.setString(1,productname);
			statement.setInt(2, productid);
			return statement.executeUpdate()>0;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean updatemsrp(int productid,int msrp) {
	  String upa="update products set msrp=? where productid=?";
	  try(PreparedStatement statement=dbconnection.getConnection().prepareStatement(upa);){
		  statement.setInt(1,msrp);
		  statement.setInt(2,productid);
		  
		  return statement.executeUpdate()>0;
		  
	  } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}

	@Override
	public Boolean updatequantity(int productid,int quantity) {
		String upd="update products set quantity=?  where productid=? ";
		try(PreparedStatement statement=dbconnection.getConnection().prepareStatement(upd);){
			statement.setInt(1,quantity);
			statement.setInt(2, productid);
			return statement.executeUpdate()>0;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean updatevendor(int productid,String vendor) {
		String upd="update products set vendor=?  where productid=? ";
		try(PreparedStatement statement=dbconnection.getConnection().prepareStatement(upd);){
			statement.setString(1,vendor);
			statement.setInt(2, productid);
			return statement.executeUpdate()>0;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Products> allProducts(){
		String getWorkersFormat = "select * from products";
				
		try (PreparedStatement preparedStatement = dbconnection.getConnection().prepareStatement(getWorkersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<Products> all = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return all;
			}

			while (rs.next()) {
				Products products1=new Products();
				products1.setProductid(rs.getInt("productid"));
				products1.setProductname(rs.getString("productname"));
				products1.setMsrp(rs.getInt("msrp"));
				products1.setQuantity(rs.getInt("quantity"));
				products1.setVendor(rs.getString("vendor"));
				all.add(products1);
			}
			    
		 return all;   
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return null;
	  
	}

	
	@Override
	public Integer order(Orders orders){
		String insert="INSert INTO orders(productid,time,userid,quantity)VALUES(?,NOW(),?,?)";
		try(PreparedStatement statement=dbconnection.getConnection().prepareStatement(insert);){
			statement.setInt(1,orders.getProductid());
			statement.setInt(2,orders.getUserid());
			statement.setInt(3,orders.getQuantity());
			
			return statement.executeUpdate();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	return null;
		
		}

	@Override
	public List<Orders> allorders() {
		String getWorkersFormat = "select * from orders";
		
		try (PreparedStatement preparedStatement = dbconnection.getConnection().prepareStatement(getWorkersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<Orders> all = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return all;
			}

			while (rs.next()) {
				Orders orders1=new Orders();
				orders1.setOrderno(rs.getInt("orderno"));
				orders1.setProductid(rs.getInt("productid"));
				orders1.setTime(rs.getTimestamp("time"));
				orders1.setUserid(rs.getInt("userid"));
				orders1.setQuantity(rs.getInt("quantity"));
				all.add(orders1);
			}
			    
		 return all;   
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return null;
		
	}

	@Override
	public List<Orders> byuserid(int userid) {
		List<Orders> order=new ArrayList<>();
		String particular="select * from orders where userid=?";
		try(PreparedStatement statement=dbconnection.getConnection().prepareStatement(particular);){
			statement.setInt(1,userid);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				orders.setOrderno(rs.getInt("orderno"));
				orders.setProductid(rs.getInt("productid"));
				orders.setTime(rs.getTimestamp("time"));
				orders.setUserid(rs.getInt("userid"));
				orders.setQuantity(rs.getInt("quantity"));
				order.add(orders);
			}
			return order;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean byone(int productid) {
		Boolean hii=false;
		String sea="select * from products where productid=?";
		try(PreparedStatement statement=dbconnection.getConnection().prepareStatement(sea);){
			statement.setInt(1,productid);
			ResultSet rs=statement.executeQuery();
			if(rs.next()) {
			  products.setProductid(rs.getInt("productid"));
			  products.setProductname(rs.getString("productname"));
			  products.setMsrp(rs.getInt("msrp"));
			  products.setQuantity(rs.getInt("quantity"));
			  products.setVendor(rs.getString("vendor"));
			  System.out.println(products);
				  hii=true;
			}
			   System.out.println(hii);
			
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
				return hii;
	}

	@Override
	public List<Orders> bydateace() {
String getWorkersFormat = "SELECT * FROM orders ORDER BY time ASC";
		
		try (PreparedStatement preparedStatement = dbconnection.getConnection().prepareStatement(getWorkersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<Orders> all = new ArrayList<>();
			while (rs.next()) {
				Orders orders1=new Orders();
				orders1.setOrderno(rs.getInt("orderno"));
				orders1.setProductid(rs.getInt("productid"));
				orders1.setTime(rs.getTimestamp("time"));
				orders1.setUserid(rs.getInt("userid"));
				orders1.setQuantity(rs.getInt("quantity"));
				all.add(orders1);
			}
			    
		 return all;   
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return null;
	}

	@Override
	public List<Orders> bydatedec() {
String getWorkersFormat = "SELECT * FROM orders ORDER BY time DESC";
		
		try (PreparedStatement preparedStatement = dbconnection.getConnection().prepareStatement(getWorkersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<Orders> all = new ArrayList<>();
			while (rs.next()) {
				Orders orders1=new Orders();
				orders1.setOrderno(rs.getInt("orderno"));
				orders1.setProductid(rs.getInt("productid"));
				orders1.setTime(rs.getTimestamp("time"));
				orders1.setUserid(rs.getInt("userid"));
				orders1.setQuantity(rs.getInt("quantity"));
				all.add(orders1);
			}
			    
		 return all;   
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return null;
	}

	@Override
	public List<Orders> byorderidace() {
String getWorkersFormat = "SELECT * FROM orders ORDER BY orderno ASC";
		
		try (PreparedStatement preparedStatement = dbconnection.getConnection().prepareStatement(getWorkersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<Orders> all = new ArrayList<>();
			while (rs.next()) {
				Orders orders1=new Orders();
				orders1.setOrderno(rs.getInt("orderno"));
				orders1.setProductid(rs.getInt("productid"));
				orders1.setTime(rs.getTimestamp("time"));
				orders1.setUserid(rs.getInt("userid"));
				orders1.setQuantity(rs.getInt("quantity"));
				all.add(orders1);
			}
			    
		 return all;   
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return null;
	}

	@Override
	public List<Orders> byorderiddec() {
   String getWorkersFormat = "SELECT * FROM orders ORDER BY orderno DESC";
		
		try (PreparedStatement preparedStatement = dbconnection.getConnection().prepareStatement(getWorkersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<Orders> all = new ArrayList<>();
			while (rs.next()) {
				Orders orders1=new Orders();
				orders1.setOrderno(rs.getInt("orderno"));
				orders1.setProductid(rs.getInt("productid"));
				orders1.setTime(rs.getTimestamp("time"));
				orders1.setUserid(rs.getInt("userid"));
				orders1.setQuantity(rs.getInt("quantity"));
				all.add(orders1);
			}
			    
		 return all;   
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return null;
	}

	@Override
	public Integer bypid(int productid) {
		String sea="select quantity from products where productid=?";
		try(PreparedStatement statement=dbconnection.getConnection().prepareStatement(sea);){
			statement.setInt(1,productid);
			ResultSet rs=statement.executeQuery();
			if(rs.next()) {
			
			  int quantity=rs.getInt("quantity");
			  return quantity ;
						
			}
			
			  			
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		return null;
	}
}