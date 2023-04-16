package com.sportyshoes.daos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sportyshoes.models.Users;

@Component
public interface UserDao {
	
	public Integer signup(Users users);
	public Users signin(String email,String password);
	public Users view(int userid);
	public Integer updatepassword(String email,String password);
	public Boolean updatename(String email,String name);
	public Users searchemail(String email);
	public List<Users> alluser();
	public Users two(int userid,String email);
	public Boolean byid(int userid);
	

}
