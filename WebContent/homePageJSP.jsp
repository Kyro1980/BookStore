<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
   <div id="wrapper">
    <div id="header">
          <ul>
  
  <li><a href="LogOutCont">Sign Out</a></li>

<li><form method="POST" action="ChangeUserInfContr">
<jsp:useBean id="bean" class="com.bookStore.db.beans.JavaBeans" scope="session"></jsp:useBean>
<input type="hidden" name="actionButton" id="actionButton" value="<jsp:getProperty property="userId" name="bean"/>"/>
<button id="fake" type="submit"> Change User Information</button></form></li>
   
</ul>
  
   


        </div>
        
        
     <div id="wrapper2">
    
    
    <h3>Welcome back :<%= session.getAttribute("savedUserId") %> </h3>
    
	
	  <div id="links">
	  <h3>Categories:</h3>
     <a href="#link1" id="left">COMPUTERS</a><br>
      <a href="#link1" id="left" id="bookLink">HISTORY</a><br>
      <a href="#link1" id="left">ROMANCE</a><br>
      <a href="#link1" id="left">ENTERTAINMENT</a><br>
      <a href="#link1" id="left">ART AND ARCHITECTURE</a><br>
      <a href="#link1" id="left">FANTASY</a><br>
      <a href="#link1" id="left">TRAVEL</a><br>
      <a href="#link1" id="left">TRUE CRIME</a><br>
      <a href="#link1" id="left">HISTORY</a><br>
      
      
      

      </div>
	     
       
		<div id="cont2">
		<form name="viewBooksContr" method="post" action="ViewBooksContr">
		<input type="submit" class="button button3"   value="View Books" />
		</form>
		
		<form name="addBook" method="post" action="addBook.jsp">
		<input type="submit" class="button button3"   value="Add New Book" />
		</form>
		</div>
		
	
	
     
    </div> 
   <%@include file="footer.jsp"%>
 </div>
</body>
</html>