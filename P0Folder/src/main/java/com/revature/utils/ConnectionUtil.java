package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//this class has all the logic that manages the connection to the database
//will have a method called getConnection() that will return connection objects
//we will need these connection objects in our DAO layer to interact with the database
public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException {
		
		//register the Driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch(ClassNotFoundException e) {
			System.out.println("Class wasn't found!");
			e.printStackTrace();
		}
		
		//Database credentials
				String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=journal";
				String username = "postgres";
				String password = "password";
				
				
				//returns the connection object
				return DriverManager.getConnection(url, username, password);
	}

}
