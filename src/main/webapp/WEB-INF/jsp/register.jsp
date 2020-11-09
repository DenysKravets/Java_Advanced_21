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

	

	<form method="post" action="/register">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="email"><b>User Name</b></label>
    <input type="text" placeholder="Enter Username" name="username" id="email" required>
    
    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="psw" required>

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" required>
    <hr>
    
    <input name="_csrf" type="hidden" value="${_csrf.token}" />
    
    <label><b>Role:</b></label> 
    	<div class="custom-select" style="width:200px;">
			<select name="role">
				<option>Select role</option>
				<option value="ADMIN">Administrator</option>
				<option value="USER">User</option>
			</select>
		</div>
		<br/>

    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
    <button type="submit" class="registerbtn">Register</button>
  </div>

  <div class="container signin">
    <p>Already have an account? <a href="/login">Sign in</a>.</p>
  </div>
</form>

<script src="register.js" defer></script>

</body>
</html>