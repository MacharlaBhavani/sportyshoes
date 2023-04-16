package com.sportyshoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Users;
import com.sportyshoes.repositories.UserRepo;

@Service
public class UserService {
    
	@Autowired
	private UserRepo repo;
	
	public Integer creation(Users users) {
	  Integer number=repo.signup(users);
		return number;
		
	}
	
	public Users signin(String email,String password) {
		return repo.signin(email,password);
	}
	
	public Users view(int userid) {
		return repo.view(userid);
	}
	public Boolean updatepassword(String email,String password) {
		return repo.updatepassword(email, password)>0;
	}
	public Boolean updatename(String email,String name) {
		return repo.updatename(email, name);
	}
	public Users searcheamil(String email) {
		return repo.searchemail(email);
	}
  public Users bytwo(int userid,String email) {
	  return repo.two(userid, email);
  }	
  public List<Users> allusers() {
	  return repo.alluser();
  }	
  public Boolean byid(int userid) {
	  return repo.byid(userid);
  }
}
