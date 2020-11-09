<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="login.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	

	<form method="post" action="/login">
		<div class="container">
			<h1>Login</h1>
			<p>Please fill in this form to login.</p>
			<hr>

			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Email" name="username" id="email" required>

			<label for="psw"><b>Password</b></label> <input type="text"
				placeholder="Enter Password" name="password" id="psw" required> 
			<hr>
			
			<input name="_csrf" type="hidden" value="${_csrf.token}" />

			<button type="submit" class="registerbtn">Login</button>
		</div>
	</form>
	
	

</body>
</html>