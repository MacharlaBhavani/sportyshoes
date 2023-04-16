package com.sportyshoes.contollers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Users;
import com.sportyshoes.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService  service;
	
	@GetMapping("/api/user")
	public String message(){
		return "WELCOME TO SPORTY_SHOES";
		}
	
	@PostMapping("/api/user/signup")
	public String signup(@RequestBody Users users) {
		Integer crt=service.creation(users);
		if(crt==null) {
			return "already exits";
		}else {
			return "account has been created";
		}
	}
	
	@PostMapping("/api/user/signin")
	public Users signin(@RequestParam String email,@RequestParam String password) {
		return service.signin(email, password);
		
	}
	
	@GetMapping("/api/user/{userid}")
	public Users view(@RequestParam String userid) {
		 return service.view(Integer.parseInt(userid));
				 
	}
	
	@PatchMapping("/api/user/email/update/password")
	public String updation(@RequestParam String email,@RequestParam String password) {
		Boolean updated=service.updatepassword(email, password);
		if(updated) {
			return "password updated";
		}else {
			return "password not updated";
		}
	}
	
	@PatchMapping("/api/user/email/update/name")
	public String update(@RequestParam String email,@RequestParam String name) {
		Boolean updated=service.updatename(email,name);
		if(updated) {
			return "name updated";
		}else {
			return "name not updated";
		}
	}
	@GetMapping("/api/user/email")
	public Users searcheamil(@RequestParam String email) {
		 return service.searcheamil(email);
				 
	}
	
	@GetMapping("/api/user/userid/email")
	public Users bytwo(@RequestParam String userid,@RequestParam String email) {
		 return service.bytwo(Integer.parseInt(userid),email);
	}
	@GetMapping("/api/user/allusers")
	public List<Users> allusers() {
		 return service.allusers();
				 
	}
	
}
