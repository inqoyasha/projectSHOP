<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<h3>Categories</h3>
<div>
    <c:forEach var ="category" items="${categories}">
        <a href="${pageContext.request.contextPath}/show/category/${category.c_id}">${category.name}</a><br>
    </c:forEach>
</div>
</html>