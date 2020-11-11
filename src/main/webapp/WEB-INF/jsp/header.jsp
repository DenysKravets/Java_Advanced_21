<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
		
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">Logo</a>

  <!-- Links -->
  <ul class="navbar-nav">
  	<li class="nav-item">
      <a class="nav-link" href="${contextPath}/"><spring:message code='header.email'/></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${contextPath}/periodical"><spring:message code='header.addPeriodical'/></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${contextPath}/showPeriodicals"><spring:message code='header.periodicals'/></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${contextPath}/showBucket"><spring:message code='header.bucket'/></a>
    </li>

    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Dropdown link
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${contextPath}/">Link 1</a>
        <a class="dropdown-item" href="${contextPath}/">Link 2</a>
        <a class="dropdown-item" href="${contextPath}/">Link 3</a>
      </div>
    </li>
    
    		
  </ul>
</nav>

<div style="float: right;">
				<fieldset>
					<label><spring:message code="choose_language" /></label> <select
						id="locales">
						<option value="en"><spring:message code='language.english'/></option>
						<option value="ua"><spring:message code='language.ukrainian'/></option>
					</select>
				</fieldset>
			</div>
