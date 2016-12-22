<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Book Information</title>
</head>

<style type="text/css">


#wrapper {
	width: 100%;
	margin: auto;
	padding:0px;
	
}
#wrapper3 {
	width: 97%;
	margin: auto;
	margin-top:50px;
	border-radius: 10px;
	text-align: center;
    padding: 1px 2px;
    text-decoration: none;
    color: white;
    background-color: #333;
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
    border-radius: 10px;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}
#wrapper2 {
border: 3px solid black;
    border-radius: 10px;
	width: 510px;
	
	margin: auto;
	margin-top:50px;
	
	background-color: #cce5ff;
	
	padding-top:5px;
	
}
body{
    margin:20px;
	padding:5px;
	
	
}
#cont1{
   width: 510px;
  
   padding-left:10px;
   padding-top:20px;
   
   
}

#cont2{
   width: 510px;
   height: 60px;
   text-align:center;
   padding-top:20px;
  
   
}
#errMessage{
padding-top:15px;
  
  text-align:center;
   color: red;
   
}

#in2 {
    
	margin-bottom: 10px;
	width: 90%;
	padding: 5px;
	margin-top: 5px;
	border: 1px solid black;
	font-size: 15pt;
	border-radius: 0px;
}
#labelOne{
    font-weight: 600;
    font-size: 20pt;
   
}
.button {
    background-color: white; 
    border: 1px solid black;
    color: black;
    padding:5px 2px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 22px;
    margin: 4px 2px;
    cursor: pointer;
}
.button3:hover {
    background-color: #555555;
    color: white;
}
.button3 {
width: 80%;
border-radius: 4px;
} 
#left{
    text-decoration: none;
    color: 0e1fd3;
}
#left:hover {
    background-color: #555555;
    color: white;
    border-radius: 4px;

</style>
<body>
       <div id="wrapper">
    <div id="header">
          <ul>
  <li><a class="active" href="#home">Home</a></li>
  <li><a href="#news">News</a></li>
  <li><a href="#contact">Contact</a></li>
  <li><a href="#logOut">Log Out</a></li>
</ul>
        </div>
     <div id="wrapper2">
     
    
     <jsp:useBean id="bean" class="com.bookStore.db.beans.JavaBeans" scope="session"></jsp:useBean>
     
	<form name="changeBookRecord" method="post" action="changeBookRecordCont">
        <div id="cont1">
        
   
        <input type="hidden" name="command" id="command" value="LOAD"/>
        <input type="hidden" name="id" id="id" value="${id}"/>
        
        <label id="labelOne" for="nameOfBook">Book Name:</label>
        
        <input id="in2" type="text" name="nameOfBook" value="${nameOfBook}"><br>
        
        <label id="labelOne" for="author">Author:</label>
         <input id="in2" type="text" name="author" value="${author}"><br>
         
       
        
        <label id="labelOne" for="price">Price:</label>
        <input id="in2" type="text" name="price" value="${price}"><br>
        <div id="errMessage">
		
		
		</div>
        
		<input type="submit" class="button button3"  value="Change Record"/>
		
		
		
         </div>
        
	
		
		
		
		
	</form>
	   
	   
	   <form name="homePage" method="post" action="homePageJSP.jsp">
	   <input type="hidden" name="actionButton" id="actionButton" value=""/>
	   <input type="submit" class="button button3"  value="Home Page"/>
	   </form>
     
    </div> 
   <div id="wrapper3">
   <p>BOOK.com</p>
   </div>
 </div>
</body>
</html>