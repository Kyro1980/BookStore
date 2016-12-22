package com.bookStore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookStore.db.beans.ConnectionDB;

/**
 * Servlet implementation class changeBookRecordCont
 */
@WebServlet("/changeBookRecordCont")
public class changeBookRecordCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
		
	}
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 

			PrintWriter out = response.getWriter();
			out.println("<h1>WORKS</h1>");
	String theCommand = request.getParameter("command");
	String delete="DELETE";
	String load="LOAD";
	out.println(theCommand);
	out.println(theCommand.equals(delete));

			if (theCommand.equals(delete)) {
	      	
	        	String idString =(String)request.getParameter("id");

	         	out.println(idString);
	        	int idInt = Integer.parseInt(idString);
	        	
	        	String sql ="DELETE FROM books WHERE id = ? ";
	        	
	    		Connection conn;
	    		
	    	    try{
	    	    	        
	    	    			Class.forName("com.mysql.jdbc.Driver");
	    	    				
	    	    			conn = ConnectionDB.getConnection();
	    	    			
	    	    			PreparedStatement stmt = conn.prepareStatement(sql);
	    	    			
	    	    			
	    	    			 
	    	    			stmt.setInt(1, idInt);
	    	    			
	    	    			int affect = stmt.executeUpdate();
	    	    			
	    	    			
	    	    			if(affect==1){
	    	    				
//	
	    	    				
	    	    				ServletContext context= getServletContext();
	    	    				RequestDispatcher rd= context.getRequestDispatcher("/ViewBooksContr");
	    	    				rd.forward(request, response);
	    	    			}else{
	    	    				
	    	    			}
	    	    			
	    	    			
	    	    			
	    	    			
	    	    			
	    	    		}
	    	    		catch(Exception e){
	    	    			
	    	    			e.getMessage();
	    	    		} 
	    	    		catch(Throwable e) 
	    	    		{
	    	    		   e.printStackTrace();
	    	    		}
	    	            finally {
	    	    			
	    	    		}
	    			
	    	 
	    	 
	        }else if (theCommand.equals(load)) {
	        	
	        	out.println("<h1>Inside Load</h1>");
	        	
	        	
	        	String idString =(String)request.getParameter("id");
	    		
	    		
	    		int idInt = Integer.parseInt(idString);
	    		
	    		String nameOfBook=request.getParameter("nameOfBook");
	    		
	    		String author=request.getParameter("author");
	    		
	    		String priceString=request.getParameter("price");
	    		
	    		
	    		double priceDouble = Double.valueOf(priceString);
	    		
	    		String sql ="UPDATE books SET nameOfBook= ?, author= ?, price= ? WHERE id = ? ";
	    		
	    		Connection conn;
	    		
	    try{
	    	        
	    			Class.forName("com.mysql.jdbc.Driver");
	    				
	    			conn = ConnectionDB.getConnection();
	    			
	    			PreparedStatement stmt = conn.prepareStatement(sql);
	    			
	    			
	    			 
	    			stmt.setString(1, nameOfBook);
	    			stmt.setString(2, author);
	    			stmt.setDouble(3, priceDouble);
	    		    stmt.setInt(4, idInt);
	    			int affect = stmt.executeUpdate();
	    			
	    			
	    			if(affect==1){
	    				
	    				ServletContext context= getServletContext();
	    				RequestDispatcher rd= context.getRequestDispatcher("/ViewBooksContr");
	    				rd.forward(request, response);
//	    				RequestDispatcher rd=request.getRequestDispatcher("/homePageJSP.jsp");
//	    			    rd.forward(request,response);
	    			}else{
	    				
	    			}
	    			
	    			
	    			
	    			
	    			
	    		}
	    		catch(Exception e){
	    			
	    			e.getMessage();
	    		} 
	    		catch(Throwable e) 
	    		{
	    		   e.printStackTrace();
	    		}
	            finally {
	    			
	    		}
			}
		 
		 
	 }
	
	
	}


