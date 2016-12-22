package com.bookStore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookStore.db.beans.ConnectionDB;
import com.bookStore.db.tables.Book;

/**
 * Servlet implementation class ViewBooksContr
 */
@WebServlet("/ViewBooksContr")
public class ViewBooksContr extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1>oGetWORKS</h1>");
		
		String sql = "SELECT id, nameOfBook, author, price FROM books";
		 
	    Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
	
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		conn = ConnectionDB.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		List<Book> books =new ArrayList<>();
		
		while(rs.next()){
			
			int id = rs.getInt(1);
			String nameOfBook = rs.getString(2);
			String author = rs.getString(3);
			Double price = rs.getDouble(4);
					
		    books.add(new Book(id, nameOfBook, author, price));
			
			
		}
		int one=123445;
		request.setAttribute("booksArrayList", books);
		request.setAttribute("one", one);
		RequestDispatcher rd=request.getRequestDispatcher("/viewBooks.jsp");
	    rd.forward(request,response);
		
	}catch (SQLException e) {
	
		e.getMessage();
	} catch (Exception e) {
		
		System.err.println(e);
		e.getMessage();
	}
	finally {
		if(rs != null){
			try {
				rs.close();
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
		
		String sql = "SELECT id, nameOfBook, author, price FROM books";
		 
	    Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
	
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		conn = ConnectionDB.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		List<Book> books =new ArrayList<>();
		
		while(rs.next()){
			
			int id = rs.getInt(1);
			String nameOfBook = rs.getString(2);
			String author = rs.getString(3);
			Double price = rs.getDouble(4);
					
		    books.add(new Book(id, nameOfBook, author, price));
			
			
		}
		int one=123445;
		request.setAttribute("booksArrayList", books);
		request.setAttribute("one", one);
		RequestDispatcher rd=request.getRequestDispatcher("/viewBooks.jsp");
	    rd.forward(request,response);
		
	}catch (SQLException e) {
	
		e.getMessage();
	} catch (Exception e) {
		
		System.err.println(e);
		e.getMessage();
	}
	finally {
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
		
	}

}
