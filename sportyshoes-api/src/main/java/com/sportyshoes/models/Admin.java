package com.sportyshoes.models;

import org.springframework.stereotype.Component;

@Component
public class Admin {
	private int sno;
	private String name;
	private String password;
	
	public Admin() {}
	
	
	public Admin(int sno, String name, String password) {
		super();
		this.sno = sno;
		this.name = name;
		this.password = password;
	}


	public int getSno() {
		return sno;
	}


	public void setSno(int sno) {
		this.sno = sno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Admin [sno=" + sno + ", name=" + name + ", password=" + password + "]";
	}
	
	

}
