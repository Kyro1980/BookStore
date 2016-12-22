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
import javax.servlet.http.HttpSession;

import com.bookStore.db.beans.ConnectionDB;

/**
 * Servlet implementation class ChangeUserInfContr
 */
@WebServlet("/ChangeUserInfContr")
public class ChangeUserInfContr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession();
			String userID =(String)session.getAttribute("savedUserId");
			
			
			
			
			String sql = "SELECT * FROM logInInf WHERE userId=?";
			ResultSet rs=null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = ConnectionDB.getConnection();
			
				PreparedStatement stmt = conn.prepareStatement(sql); 
				stmt.setString(1, userID);
				
				rs = stmt.executeQuery();
				
				if (rs.next()) {
					int id = rs.getInt(1);
					String userId = rs.getString(2);
					String firstName = rs.getString(3);
					String lastName = rs.getString(4);
					String paswr= rs.getString(5);
					
					
					
					
				
					
					request.setAttribute("id",id);
					request.setAttribute("userId",userId);
					request.setAttribute("firstName",firstName);
					request.setAttribute("lastName",lastName);
					request.setAttribute("paswr",paswr);
					
					
					RequestDispatcher rd=request.getRequestDispatcher("/changUserInf.jsp");
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
	}

}
