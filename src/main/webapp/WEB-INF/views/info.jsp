<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<body>
<%@ include file="bar/navbar.jsp"%>
	<h3>Product info</h3>
		<tr>
			<th></th>
			<p>Name: ${product.productName}</p>
			<p><img src="${pageContext.request.contextPath}/images/ ${product.pictureURL }" width="50"></p>
			<p>Description: ${product.description}</p>
			<p>Manufacturer: ${product.manufacturer}</p>
			<p>Price: ${product.price}</p>
			<th></th>
            <sec:authorize access="hasRole('USER')">
                <a href="${pageContext.request.contextPath}/cart/buy/${product.p_id}">Buy</a>
            </sec:authorize>
            <sec:authorize access="hasRole('ADMIN')">
                <a href="${pageContext.request.contextPath}/manage/edit/${product.p_id}">Edit</a>
            </sec:authorize>
		</tr>
</body>
</html>