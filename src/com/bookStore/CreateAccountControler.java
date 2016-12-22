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
 * Servlet implementation class CreateAccountControler
 */
@WebServlet("/CreateAccountControler")
public class CreateAccountControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userID = request.getParameter("userID");
		String firstName = request.getParameter("firstName");
		String lastName  = request.getParameter("lastName");
		String pswrd = request.getParameter("pswrd");
		
		HttpSession session = request.getSession();
		session.setAttribute("savedUserId", userID);
		

		

		boolean flag = true;
		if (userID=="" | firstName=="" | lastName=="" | pswrd=="") {
			flag=false;
		}
	if(checkUserId(userID) && flag== true){
		
		String sql = "INSERT into logInInf (userId, firstName, lastName, paswr)" +
		              "VALUES(?, ?, ?, ?)";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =ConnectionDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,userID);
			stmt.setString(2,firstName);
			stmt.setString(3,lastName );
			stmt.setString(4,pswrd);
			
			int affected = stmt.executeUpdate();
			

			
			request.setAttribute("name",firstName);
			RequestDispatcher rd=request.getRequestDispatcher("/homePageJSP.jsp");
		    rd.forward(request,response);
			
		} catch (SQLException e) {
			e.getMessage();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	else{
		if (firstName=="") {
			request.setAttribute("errorMessage","First Name field can't be empty!");
		}else if(lastName==""){
			request.setAttribute("errorMessage","Last Name field can't be empty!");
		}
		else if(userID==""){
			request.setAttribute("errorMessage","User Id field can't be empty!");
		}
		else if(pswrd==""){
			request.setAttribute("errorMessage","Password field can't be empty!");
		}
		
		else{
			request.setAttribute("errorMessage","This User Id already exists!");
		}
		
	    
	    RequestDispatcher rd=request.getRequestDispatcher("/createAccount.jsp");
	    rd.forward(request,response);
	}
	 	
	 
	 
	}

	private boolean checkUserId(String userID) {
		String sql = "SELECT firstName FROM logInInf WHERE userId=?";
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = ConnectionDB.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(sql); 
		stmt.setString(1, userID);
		rs = stmt.executeQuery();
		
		if (rs.next()) {
			return false;
		}
		else {
			return true;
			
			
		}
		
		
	} catch (Exception e) {
		
		e.getMessage();
		return false;
		
	}
	
	}

}
