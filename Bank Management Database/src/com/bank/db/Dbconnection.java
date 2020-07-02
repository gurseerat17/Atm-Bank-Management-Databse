package com.bank.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {
	private static Connection connection;
	public static Connection dbConnection() {
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/***","****","********");
			//connection=DriverManager.getConnection("jdbc:mysql://mysql15.000webhost.com:3306/id10007605_trainingjava","id10007605_gurseerat","12345678");
			
			System.out.println("Connection ready "+ connection);
		}catch(Exception e) {
			System.out.println("Connection "+e);
		}	
			
			
		return connection;
	
	}
	public static void main(String[] args) {
		dbConnection();
	}
}
