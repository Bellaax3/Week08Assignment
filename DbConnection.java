package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {
	
	private static final String SCHEMA = "projects";
	private static final String USER = "projects";
	private static final String PASSWORD = "projects";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;

	public static Connection getConnection() {
		
	
		String url = 
		String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", 
				HOST, PORT, SCHEMA, USER, PASSWORD);
		
		System.out.println("Connecting with url=" + url);
		
		try {
			Connection con = DriverManager.getConnection(url);
			System.out.println("Succesful obtain connection");
			return con;
		} catch (SQLException e) {
			System.out.println("Error");
			throw new DbException(e);
		}
	}

}
