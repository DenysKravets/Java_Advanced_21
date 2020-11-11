<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<c:forEach items="${periodicals}" var="periodical">
		<div class="card" style="width: 400px">
			<img class="card-img-top" src="data:image/jpg;base64,${periodical.getPhoto()}" alt="Card image" width="200">
			<div class="card-body">
				<h4 class="card-title">${periodical.getName()}</h4>
				<p class="card-text">${periodical.getDescription()}</p>
				<p class="card-text">${periodical.getPrice()}</p>
				<button onclick="sendPeriodicalRequest(${periodical.getId()})" class="btn btn-primary"><spring:message code="showPeriodicals.addToCart"/></button>
			</div>
		</div>
	</c:forEach>

	<script src="showPeriodicals.js" defer></script>
	
</body>
</html>