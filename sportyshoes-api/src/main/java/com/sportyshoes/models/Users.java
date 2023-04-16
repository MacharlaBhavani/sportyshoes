package com.sportyshoes.models;

import org.springframework.stereotype.Component;

@Component
public class Users {
	
	private int  userid;
	private String name;
	private String email;
	private String password;

	public Users(){}

	public Users(int userid, String name, String email, String password) {
		super();
		this.userid = userid;
		this.name =name;
		this.email = email;
		this.password = password;
	}

	public Users(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Users(int userid, String name, String email) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
	}
	
	

	public Users(int userid) {
		super();
		this.userid = userid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String username) {
		this.name = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", name=" + name + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	
}
