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

	<jsp:include page="header.jsp"></jsp:include>

	<c:forEach items="${periodicals}" var="periodical">
		<div class="card" style="width: 400px">
			<img class="card-img-top" src="data:image/jpg;base64,${periodical.getPhoto()}" alt="Card image" width="200">
			<div class="card-body">
				<h4 class="card-title">${periodical.getName()}</h4>
				<p class="card-text">${periodical.getDescription()}</p>
				<p class="card-text">${periodical.getPrice()}</p>
				<a href="#" class="btn btn-primary">Add to cart</a>
			</div>
		</div>
	</c:forEach>

</body>
</html>