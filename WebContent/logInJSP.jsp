<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>
</head>

<link type="text/css" rel="stylesheet" href="css/logIn.css">

<body>
     <div id="wrapper">
        
           <%@include file="header.jsp"%>
       
     <div id="wrapper2">
     
    
	<form name="loginForm" method="post" action="LogInControler">
	    
        <div id="cont1">
        
        <label id="labelOne" for="userId">User ID:</label>
        <input id="in2" type="text" name="userId"><br>
         </div>
        
		
		<div id="cont2">
		<label id="labelOne" for="pswrd">Password:</label>
	    <input id="in2" type="password" name="pswrd"><br>
	   
		</div>
		<div id="cont5">
		${errorMessage}
		
		</div>
		<div id="cont3">
		<input type="submit" class="button button3"  value="Log in" />
		</div>
		
	</form>
	<div id="cont4">
     <a href="createAccount.jsp" id="left">-Create New Account-</a>
     </div>
     
    </div> 
        <%@include file="footer.jsp"%>
 </div>
</body>
</html>