package com.bookStore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookStore.db.beans.ConnectionDB;

/**
 * Servlet implementation class addBookCon
 */
@WebServlet("/addBookCon")
public class addBookCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 String bookName =request.getParameter("bookName");
		 if(bookName==""){
			   request.setAttribute("errorMessage","Book Name field cannot be empty!");
			    //important forward it back to the login page again. 
			    RequestDispatcher rd=request.getRequestDispatcher("/addBook.jsp");
			    rd.forward(request,response);
		 }
		 
		 String author =request.getParameter("author");
		 if(author==""){
			   request.setAttribute("errorMessage","Author field cannot be empty!");
			    //important forward it back to the login page again. 
			    RequestDispatcher rd=request.getRequestDispatcher("/addBook.jsp");
			    rd.forward(request,response);
		 }
		 String price =request.getParameter("price");
		 if(price ==""){
			   request.setAttribute("errorMessage","Price field cannot be empty!");
			    //important forward it back to the login page again. 
			    RequestDispatcher rd=request.getRequestDispatcher("/addBook.jsp");
			    rd.forward(request,response);
		 }
		 double priceDouble=0;
		 try {
			 
			 priceDouble = Double.valueOf(price);
			 
		} catch (NumberFormatException e) {
			request.setAttribute("errorMessage","Price field input is numeric!");
		    //important forward it back to the login page again. 
		    RequestDispatcher rd=request.getRequestDispatcher("/addBook.jsp");
		    rd.forward(request,response);
		}
		 
		 String sql = "INSERT into books (nameOfBook , author, price)" +
	              "VALUES(?, ?, ?)";
		 try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn =ConnectionDB.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				stmt.setString(1,bookName);
				stmt.setString(2,author);
				stmt.setDouble(3,priceDouble);
				
				
				
				int affected = stmt.executeUpdate();
				
		
				
			
				RequestDispatcher rd=request.getRequestDispatcher("/homePageJSP.jsp");
			    rd.forward(request,response);
				
			} catch (Exception e) {
				System.out.println("here");
				e.getMessage();
			

	}
	}

}
