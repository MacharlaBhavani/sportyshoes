package com.sportyshoes.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.daos.UserDao;
import com.sportyshoes.models.Users;
import com.sportyshoes.utils.DatabaseConnection;

@Repository
public class UserRepo implements UserDao{
 
 @Autowired
 private DatabaseConnection dbconnection;
 @Autowired
 private Users users;

@Override
public Users signin(String email, String password) {
	
	String in="SELECT * FROM user WHERE email=? AND password=?";
	try {
		PreparedStatement statement=dbconnection.getConnection().prepareStatement(in);
		   statement.setString(1,email);
		   statement.setString(2,password);
		   ResultSet rs=statement.executeQuery();
		   if(rs.next()) {
			   users.setUserid(rs.getInt("userid"));
			   users.setName(rs.getString("name"));
			   users.setEmail(rs.getString("email"));
			   users.setPassword("*******");
			   return users;
			   
   		   }
		  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	return null;
	
}

@Override
public Users view(int userid) {
	String search="SELECT * FROM user WHERE userid=?";
	try {
		PreparedStatement statement=dbconnection.getConnection().prepareStatement(search);
		  statement.setInt(1, userid);
		  ResultSet rs=statement.executeQuery();
		  if (!rs.isBeforeFirst()) {
				return null;
			}
		   if(rs.next()) {
			   users.setUserid(rs.getInt("userid"));
			   users.setName(rs.getString("name"));
			   users.setEmail(rs.getString("email"));
			   users.setPassword("*********");
			 
			  	return users;   
		   }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	return null;
	
}

@Override
public Integer updatepassword(String email, String password) {
	
	String update="UPDATE user SET password=? WHERE email=?";
	try(PreparedStatement statement = dbconnection.getConnection().prepareStatement(update);){
			statement.setString(1,password);
			statement.setString(2,email);
			
			return statement.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
}

@Override
public Integer signup(Users users) {
	String user="INSERT INTO user(name,email,password)VALUES(?,?,?)";
	
		try(PreparedStatement statement = dbconnection.getConnection().prepareStatement(user);){
			  statement.setString(1,users.getName());
			   statement.setString(2, users.getEmail());
			   statement.setString(3, users.getPassword());
			   return statement.executeUpdate();
			   			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			return null;
		}
	}

@Override
public Boolean updatename(String email, String name) {
	boolean upda1=false;
	String update="UPDATE user SET name=? WHERE email=?";
	try {
		PreparedStatement statement=dbconnection.getConnection().prepareStatement(update);
		statement.setString(1,name);
		statement.setString(2,email);
		int val1=statement.executeUpdate();
		if(val1>0) {
			upda1=true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return upda1;
}

@Override
public Users searchemail(String email) {
  String search="SELECT * FROM user WHERE email=?";
	try {
		PreparedStatement statement=dbconnection.getConnection().prepareStatement(search);
		  statement.setString(1,email);
		  ResultSet rs=statement.executeQuery();
		  if (!rs.isBeforeFirst()) {
				return null;
			}
		   if(rs.next()) {
			   users.setUserid(rs.getInt("userid"));
			   users.setName(rs.getString("name"));
			   users.setEmail(rs.getString("email"));
			   users.setPassword("*********");
			 
			  	return users;   
		   }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	return null;
	
}

@Override
public List<Users> alluser(){
	String all="SELECT * FROM user";
	try(PreparedStatement statement=dbconnection.getConnection().prepareStatement(all);){
		ResultSet rs=statement.executeQuery();
		List<Users> user = new ArrayList<>();
		if (!rs.isBeforeFirst()) {
			return user;
		}

		while(rs.next()) {
			users.setUserid(rs.getInt(1));
			users.setName(rs.getString(2));
			users.setEmail(rs.getString(3));
			users.setPassword("******");
			user.add(users);
		}
		return user;
      } catch (SQLException e) {

     	e.printStackTrace();
      }
     return null;
     }

@Override
public Users two(int userid, String email) {
	String search="SELECT * FROM user WHERE userid=? and email=?";
	try {
		PreparedStatement statement=dbconnection.getConnection().prepareStatement(search);
		  statement.setInt(1,userid);
		  statement.setString(2,email);
		  ResultSet rs=statement.executeQuery();
		  if (!rs.isBeforeFirst()) {
				return null;
			}
		   if(rs.next()) {
			   users.setUserid(rs.getInt("userid"));
			   users.setName(rs.getString("name"));
			   users.setEmail(rs.getString("email"));
			   users.setPassword("*********");
			 
			  	return users;   
		   }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	return null;
	
}

@Override
public Boolean byid(int userid) {
	Boolean value=false;
	String search="SELECT * FROM user WHERE userid=?";
	try(PreparedStatement statement=dbconnection.getConnection().prepareStatement(search);){
		    statement.setInt(1,userid);
			ResultSet rs=statement.executeQuery();
		   if(rs.next()) {
			   users.setUserid(rs.getInt("userid"));
			   users.setName(rs.getString("name"));
			   users.setEmail(rs.getString("email"));
			   users.setPassword("*********");
			   System.out.println(users);
			   value=true;  
		   }
	
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	    return value;
   }
}
 

