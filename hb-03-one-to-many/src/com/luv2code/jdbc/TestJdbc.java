package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

}