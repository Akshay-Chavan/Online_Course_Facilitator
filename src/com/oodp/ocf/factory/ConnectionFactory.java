package com.oodp.ocf.factory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * This class provides methods to create connection with database server and
 * close the connection.
 * 
 * @author
 * 
 */
public class ConnectionFactory {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			System.err.println("Error while registering MySQL Connector/J");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.err.println("Error while registering MySQL Connector/J");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Error while registering MySQL Connector/J");
			e.printStackTrace();
		}
	}

	private static Connection conn = null;

	/**
	 * Creates connection with database server.
	 * 
	 * @return connection
	 */
	public static Connection getConnection() {

		try {

			String dbURL = "jdbc:mysql://localhost:3306/studentmanagement";
			String dbUserName = "root";
			String dbPassword = "";

			conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
			System.out.println("Connected to DB Server...");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * Method to close database connection.
	 */
	public static void closeConnection() {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ConnectionFactory.getConnection();
	}
}
