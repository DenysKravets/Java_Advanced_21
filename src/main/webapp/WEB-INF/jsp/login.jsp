<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="login.css">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<script type="text/javascript"
			src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
			
	
	<script type="text/javascript">
		$(document).ready(function() {
			var selItem = localStorage.getItem("locales");
			$('#locales').val(selItem ? selItem : 'en');
			$("#locales").change(function() {
				var selectedOption = $('#locales').val();
				if (selectedOption) {
					window.location.replace('?lang=' + selectedOption);
					localStorage.setItem("locales", selectedOption);
				}
			});
		});
	</script>

			<div>
					<label><spring:message code="choose_language" /></label> <select
						id="locales">
						<option value="en"><spring:message code='language.english'/></option>
						<option value="ua"><spring:message code='language.ukrainian'/></option>
					</select>
			</div>

	<form method="post" action="/login">
		<div class="container">
			<h1><spring:message code='login'/></h1>
			<p><spring:message code='login.fillForm'/></p>
			<hr>

			<label for="email"><b><spring:message code='login.email'/></b></label> <input type="text"
				placeholder="<spring:message code='login.enterEmail'/>" name="username" id="email" required>

			<label for="psw"><b><spring:message code='login.password'/></b></label> <input type="text"
				placeholder="<spring:message code='login.enterPassword'/>" name="password" id="psw" required> 
			<hr>
			
			<input name="_csrf" type="hidden" value="${_csrf.token}" />

			<button type="submit" class="registerbtn"><spring:message code='login'/></button>
		</div>
	</form>
	
	<script src="register.js" defer></script>

</body>
</html>