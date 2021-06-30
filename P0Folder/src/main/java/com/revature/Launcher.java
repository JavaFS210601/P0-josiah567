package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.Menu;
import com.revature.utils.ConnectionUtil;

public class Launcher {

	public static void main(String[] args) {
		
		//testing the connection
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("Connection successful");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//make a menu object
		Menu menu = new Menu();
		
		//display the menu
		menu.display();
		

	}

}
