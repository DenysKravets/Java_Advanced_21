<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<form:form enctype='multipart/form-data' method="POST"
		action="/periodical" modelAttribute="periodical">
		<form:label path="name">Name</form:label>
		<form:input path="name" />

		<form:label path="description">Description</form:label>
		<form:input path="description" />

		<form:label path="price">Price</form:label>
		<form:input path="price" />

		<form:label path="file">Photo</form:label>
		<form:input path="file" type="file" />

		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>