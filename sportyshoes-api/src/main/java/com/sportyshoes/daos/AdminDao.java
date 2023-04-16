package com.sportyshoes.daos;

import org.springframework.stereotype.Component;

@Component
public interface AdminDao {
	
	public Integer updatePassword(String name,String password);
    public Boolean signin(String name,String password);
    
    
}
