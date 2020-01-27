<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<body>
	<h3>Product info</h3>
		<tr>
			<th></th>
			<p>Name: ${product.productName}</p>
			<p><img src="${pageContext.request.contextPath }/resources/static/ ${product.pictureURL }" width="50"></p>
			<p>Price: ${product.price}</p>
			<th></th>
		</tr>
</body>
</html>