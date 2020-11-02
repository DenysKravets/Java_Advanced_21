<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Login

	<form method="post" id="" action="/login">
		<label>Email:<input type="text" name="username"></label>
		 <br>
		 <label>Password:<input type="text" name="password"></label> 
		 <br>  
		 <br>
		<input name="_csrf" type="hidden" value="${_csrf.token}" />
		<button type="submit">Login</button>
	</form>

</body>
</html>