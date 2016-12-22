<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Books</title>
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

			<table>
				<tr>
					<th>Name</th>
					<th>Author</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempBook" items="${booksArrayList}">

					<c:url var="tempLink" value="bookControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="id" value="${tempBook.id}" />
					</c:url>

					<c:url var="deleteLink" value="changeBookRecordCont">
						<c:param name="command" value="DELETE" />
						<c:param name="id" value="${tempBook.id}" />
					</c:url>

					<tr>

						<td>${tempBook.nameOfBook}<br /></td>
						<td>${tempBook.author}<br /></td>
						<td>$${tempBook.price}<br /></td>
						<td><a href="${tempLink}">Update</a> |
						<td><a href="${deleteLink}">Delete</a></td>

					</tr>
				</c:forEach>

			</table>


			<div id="cont2">
				<form name="addNewBook" method="post" action="addBook.jsp">
					<input type="submit" class="button button3" value="Add Book" />
				</form>
			</div>




		</div>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>