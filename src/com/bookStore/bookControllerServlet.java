package com.bookStore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookStore.db.beans.ConnectionDB;

/**
 * Servlet implementation class bookControllerServlet
 */
@WebServlet("/bookControllerServlet")
public class bookControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userID =(String)request.getParameter("id");
		 
		 
		 String sql = "SELECT * FROM books WHERE id= ?";
		 ResultSet rs=null;
		 Connection conn=null;
		 
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = ConnectionDB.getConnection();
			
				PreparedStatement stmt = conn.prepareStatement(sql); 
				stmt.setString(1, userID);
				
				rs = stmt.executeQuery();
				
				if (rs.next()) {
					int id = rs.getInt(1);
					String nameOfBook = rs.getString(2);
					String author = rs.getString(3);
					double price = rs.getDouble(4);
					
					
					
					
					
					
					
					request.setAttribute("id", userID);
					request.setAttribute("nameOfBook",nameOfBook);
					request.setAttribute("author",author);
					request.setAttribute("price",price);
					
					
					
					RequestDispatcher rd=request.getRequestDispatcher("/changBookInf.jsp");
				    rd.forward(request,response);
				    
				    
					
				} else{
					System.err.println("No rows were found");
				}
			}
				catch(SQLException e){
					System.err.println(e);
				} catch (ClassNotFoundException e) {
					
					e.getMessage();
				} catch (Exception e) {
					
					e.getMessage();
				}
			finally {
				if(conn != null){
					try {
						conn.close();
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
				}
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
