<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add book</title>
</head>
<link type="text/css" rel="stylesheet" href="css/viewBooks.css">
<body>
	<div id="wrapper">
		<div id="header">
			<ul>
				<li><a href="LogOutCont">Sign Out</a></li>
				<li><form method="POST" action="homePageJSP.jsp">

						<button id="fake" type="submit">Home</button>
					</form></li>

			</ul>
		</div>
		<div id="wrapper2">



			<form name="addBook" method="post" action="addBookCon">
				<div id="cont1">



					<label id="labelOne" for="bookName">Book Name:</label> <input
						id="in2" type="text" name="bookName"><br> <label
						id="labelOne" for="author">Author:</label> <input id="in2"
						type="text" name="author"><br> <label id="labelOne"
						for="price">Price:</label> <input id="in2" type="text"
						name="price"><br>
					<div id="errMessage">${errorMessage}</div>
				</div>




				<div id="cont2">
					<input type="submit" class="button button3" value="Submit" />
				</div>

			</form>


		</div>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>