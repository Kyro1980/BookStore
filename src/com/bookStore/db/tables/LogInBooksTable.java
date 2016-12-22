package com.bookStore.db.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bookStore.db.beans.ConnectionDB;

public class LogInBooksTable {

	
public static void displayAllRows()throws SQLException{
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql = "SELECT id, nameOfBook, author, price FROM books";
		try{
			conn = ConnectionDB.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				StringBuffer bf = new StringBuffer();
				bf.append(rs.getInt("id")+": ");
				bf.append(rs.getString("nameOfBook")+", ");
				bf.append(rs.getString("author")+", ");
				bf.append(rs.getDouble("price"+", ")+". ");
				
				System.out.println(bf.toString());
			}
		}catch (SQLException e) {
		
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
}
