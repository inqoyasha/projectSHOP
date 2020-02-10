<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
</head>
<body>
    <%@ include file="navbar.jsp"%>
	<h3>Products Page</h3>
	<div>
	    <c:forEach items="${categories}" var="category">
	        <a href="${pageContext.request.contextPath}/category/${category.id}">${category.categoryName}></a>
	    </c:forEach>
	</div>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th></th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th></th>
		</tr>
		<c:forEach items="${products }" var="product">
			<tr>
				<td>${product.p_id }</td>
				<td>${product.productName }</td>
				<td><img src="${pageContext.request.contextPath}/images/ ${product.pictureURL }" width="50"></td>
				<td>${product.price }</td>
				<td>
				    <a href="${pageContext.request.contextPath}/cart/buy/${product.p_id}">Buy</a>
				</td>
                <td>
                    <a href="${pageContext.request.contextPath}/info/${product.p_id}">Info</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>