<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
</head>
<script>
	function CheckTheBtn() {

		document.getElementById("actionButton").value = null;

	}
</script>

<link type="text/css" rel="stylesheet" href="css/createAccount.css">



<body>
	<div id="wrapper">
		<div id="header">
			<ul>

				<li><a href="logInJSP.jsp">Log In</a></li>
			</ul>
		</div>
		<div id="wrapper2">



			<form name="signUpForm" method="post" action="CreateAccountControler">
				<div id="cont1">



					<label id="labelOne" for="firstName">First Name:</label> <input
						id="in2" type="text" name="firstName"><br> <label
						id="labelOne" for="lastName">Last Name:</label> <input id="in2"
						type="text" name="lastName"><br> <label id="labelOne"
						for="userID">User ID:</label> <input id="in2" type="text"
						name="userID"><br>
					<div id="errMessage">${errorMessage}</div>

					<label id="labelOne" for="pswrd">Password:</label> <input id="in2"
						type="password" name="pswrd"><br>
				</div>




				<div id="cont2">
					<input type="submit" class="button button3" onclick="CheckTheBtn()"
						value="Submit" />
				</div>

			</form>


		</div>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>