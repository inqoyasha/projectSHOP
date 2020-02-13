<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <c:forEach var ="category" items="${categories}">
        <a href="#">${category.name}</a>
    </c:forEach>
</div>