package com.sportyshoes.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnection {
	private  Connection connection = null;
	
	DatabaseConnection(
			@Value("${db.url}")String url, 
			@Value("${db.username}")String username, 
			@Value("${db.password}")String password) throws SQLException {
		super();
		this.connection = DriverManager.getConnection(url, username, password);
		
	}
	
	public void init() throws SQLException {
		printConnectionDetails();
	}
	
	private void printConnectionDetails() throws SQLException {
		System.out.println("Connected to database server "
                + this.connection.getMetaData().getDatabaseProductName()
                + " version: "
                + this.connection.getMetaData().getDatabaseProductVersion()
				+ "\n");
	}

	public  Connection getConnection() {
		return connection;
	}

	
}
