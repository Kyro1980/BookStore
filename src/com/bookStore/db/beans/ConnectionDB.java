package com.bookStore.db.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {

	private static final String url = "jdbc:mysql://localhost:3306/assignment3";
	private static final String DriverClass = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String pswrd = "2893378433ks";
	
	private ConnectionDB() {

		try {
			Class.forName(DriverClass);
			System.out.println("Driver Registration Successful.");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
	public static Connection getConnection() throws Exception {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, pswrd);
		} catch (SQLException e) {
			System.out.println("ERROR: Connection Failed " + e.getMessage());
		}
		return connection;

	}

	public static void closeConnection(Connection con, Statement st, ResultSet rs) throws Exception {
		if (con != null)
			con.close();
		if (st != null)
			st.close();
		if (rs != null)
			rs.close();
	}
}
