package com.bookStore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
 * Servlet implementation class LogInControler
 */
@WebServlet("/LogInControler")
public class LogInControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String pswrd = request.getParameter("pswrd");
		
		JavaBeans bean = new JavaBeans();
		bean.setUserId(userId);
	   
		String sql = "SELECT firstName FROM logInInf WHERE userId=? AND paswr = ?";
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = ConnectionDB.getConnection();
		
				
			PreparedStatement stmt = conn.prepareStatement(sql); 
			stmt.setString(1, userId);
			stmt.setString(2, pswrd);
			
			rs = stmt.executeQuery();
			
			
			
			if (rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("savedUserId", userId);
				request.setAttribute("bean",bean);
			    //important forward it back to the login page again. 
			    RequestDispatcher rd=request.getRequestDispatcher("/homePageJSP.jsp");
			    rd.forward(request,response);
			}
			else {
				request.setAttribute("errorMessage","User ID or Password Incorrect");
			    //important forward it back to the login page again. 
			    RequestDispatcher rd=request.getRequestDispatcher("/logInJSP.jsp");
			    rd.forward(request,response);
				
				
			}
			
		} catch (Exception e) {
			
			e.getMessage();
			
		}
	}

}
