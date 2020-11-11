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

	<form:form enctype='multipart/form-data' method="POST"
		action="/periodical" modelAttribute="periodical">
		<form:label path="name"><spring:message code="addPeriodical.name"/></form:label>
		<form:input path="name" />

		<form:label path="description"><spring:message code="addPeriodical.description"/></form:label>
		<form:input path="description" />

		<form:label path="price"><spring:message code="addPeriodical.price"/></form:label>
		<form:input path="price" />

		<form:label path="file"><spring:message code="addPeriodical.photo"/></form:label>
		<form:input path="file" type="file" />

		<input type="submit" value="<spring:message code="addPeriodical.submit"/>" />
	</form:form>

</body>
</html>