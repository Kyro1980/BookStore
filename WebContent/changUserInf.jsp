<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change User Information</title>
<script>
	function CheckTheBtn(x) {

		document.getElementById("actionButton").value = x;

	}
</script>


<link type="text/css" rel="stylesheet" href="css/changeUserInf.css">

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<ul>
				<li><a class="active" href="#home">Home</a></li>
				<li><a href="#logOut">Log Out</a></li>
			</ul>
		</div>
		<div id="wrapper2">


			<jsp:useBean id="bean" class="com.bookStore.db.beans.JavaBeans"
				scope="session"></jsp:useBean>

			<form name="signUpForm" method="post" action="ChangeRecordCont">
				<div id="cont1">



					<input type="hidden" name="id" id="id" value="${id}" /> <label
						id="labelOne" for="firstName">First Name:</label> <input id="in2"
						type="text" name="firstName" value="${firstName}"><br>

					<label id="labelOne" for="lastName">Last Name:</label> <input
						id="in2" type="text" name="lastName" value="${lastName}"><br>



					<label id="labelOne" for="userID">User ID:</label> <input id="in2"
						type="text" name="userID" value="${userId}"><br>
					<div id="errMessage"></div>

					<label id="labelOne" for="pswrd">Password:</label> <input id="in2"
						type="text" name="pswrd" value="${paswr}"><br> <input
						type="submit" class="button button3" value="Change Record" />

				</div>

			</form>


			<form name="homePage" method="post" action="homePageJSP.jsp">
				<input type="hidden" name="actionButton" id="actionButton" value="" />
				<input type="submit" class="button button3" value="Home Page" />
			</form>

		</div>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>