package com.bookStore.db.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bookStore.db.beans.ConnectionDB;

public class LogInInfTable {
	
	public static void displayAllRows()throws SQLException{
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql = "SELECT id, userId, firstName, lastName, paswr FROM logInInf";
		try{
			conn = ConnectionDB.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				StringBuffer bf = new StringBuffer();
				bf.append(rs.getInt("id")+": ");
				bf.append(rs.getString("userId")+", ");
				bf.append(rs.getString("firstName")+", ");
				bf.append(rs.getString("lastName")+", ");
				bf.append(rs.getString("paswr")+".");
				System.out.println(bf.toString());
			}
		}catch (SQLException e) {
			System.err.println(e);
			e.getMessage();
		} catch (Exception e) {
			
			System.err.println(e);
			e.getMessage();
		}
		finally {
			if(rs != null){
				rs.close();
			}
		}
	}
	public static boolean getRow(String userId, String paswr) throws Exception{
		
		String sql = "SELECT firstName FROM logInInf WHERE userId=? AND paswr = ?";
		ResultSet rs=null;
		
		try (Connection conn = ConnectionDB.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, userId);
			stmt.setString(2, paswr);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return true;
			}
			else {
				System.err.println("No rows were found");
				return false;
			}
			
		} catch (Exception e) {
			System.out.println("2");
			e.getMessage();
			return false;
		}
		
		
		
	}
	

	
}


