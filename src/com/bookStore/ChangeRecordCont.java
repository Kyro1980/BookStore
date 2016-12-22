package com.bookStore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookStore.db.beans.ConnectionDB;
import com.bookStore.db.beans.JavaBeans;

/**
 * Servlet implementation class ChangeRecordCont
 */
@WebServlet("/ChangeRecordCont")
public class ChangeRecordCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
PrintWriter out = response.getWriter();
		
		String idString = request.getParameter("id");
		int idInt = Integer.parseInt(idString);
	   
		
		String userId =request.getParameter("userID");
		out.println(userId );
		 HttpSession session = request.getSession();
		    session.setAttribute("savedUserId", userId);
		
		
		String firstName=request.getParameter("firstName");
		
		
		String lastName=request.getParameter("lastName");
		
		
		String paswr = request.getParameter("pswrd");
		
		
		JavaBeans bean = new JavaBeans();
		bean.setId(idInt);
        bean.setFirstName(firstName);
        bean.setLastName(lastName);
        bean.setUserId(userId);
        bean.setPaswr(paswr);
		
		String sql ="UPDATE logInInf SET userId= ?, firstName= ?, lastName= ?, paswr= ? WHERE id = ? ";
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = ConnectionDB.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			 
			stmt.setString(1, userId);
			stmt.setString(2,  firstName);
			stmt.setString(3, lastName);
			stmt.setString(4, paswr); 
			
			
			
			stmt.setInt(5,idInt); 
			
			int affect = stmt.executeUpdate();
			
			
			if(affect==1){
				request.setAttribute("bean",bean);
				RequestDispatcher rd=request.getRequestDispatcher("/homePageJSP.jsp");
			    rd.forward(request,response);
			}else{
				out.println("<h1>Don't</h1>");
			}
			
			
			
			
			
		}
		catch(Exception e){
			
			e.getMessage();
		} 
		catch(Throwable e) 
		{
		   e.printStackTrace();
		}
	}

}
