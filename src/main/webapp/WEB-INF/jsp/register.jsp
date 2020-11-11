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
<title>Insert title here</title>
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

	<form method="post" action="/register">
  <div class="container">
    <h1><spring:message code='register'/></h1>
    <p><spring:message code='register.fillForm'/></p>
    <hr>

    <label for="email"><b><spring:message code='register.userName'/></b></label>
    <input type="text" placeholder="<spring:message code='register.enterUserName'/>" name="username" id="email" required>
    
    <label for="email"><b><spring:message code='register.email'/></b></label>
    <input type="text" placeholder="<spring:message code='register.enterEmail'/>" name="email" id="email" required>

    <label for="psw"><b><spring:message code='register.password'/></b></label>
    <input type="password" placeholder="<spring:message code='register.enterPassword'/>" name="password" id="psw" required>

    <label for="psw-repeat"><b><spring:message code='register.repeatPassword'/></b></label>
    <input type="password" placeholder="<spring:message code='register.repeatPassword'/>" name="psw-repeat" id="psw-repeat" required>
    <hr>
    
    <input name="_csrf" type="hidden" value="${_csrf.token}" />
    
    <label><b><spring:message code='register.role'/>:</b></label> 
    	<div class="custom-select" style="width:200px;">
			<select name="role">
				<option><spring:message code='register.selectRole'/></option>
				<option value="ADMIN"><spring:message code='register.selectRole.admin'/></option>
				<option value="USER"><spring:message code='register.selectRole.user'/></option>
			</select>
		</div>
		<br/>

    <p><spring:message code='register.agreement'/> <a href="#"><spring:message code='register.agreement.termsAndPrivacy'/></a>.</p>
    <button type="submit" class="registerbtn"><spring:message code='register'/></button>
  </div>

  <div class="container signin">
    <p><spring:message code='register.haveAccount'/> <a href="/login"><spring:message code='register.haveAccount.signIn'/></a>.</p>
  </div>
</form>

<script src="register.js" defer></script>

</body>
</html>