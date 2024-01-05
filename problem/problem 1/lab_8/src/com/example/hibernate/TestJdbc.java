package com.example.hibernate;

import java.sql.DriverManager;

import java.sql.Connection;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false";

		
		String user = "hbstudent";
		
		String password = "hbstudent";
		try {
			System.out.println("Connecting to database: "+ jdbcUrl);
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection sucessfuly!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


