<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
</head>
<body>
    <table>
    <td>
        <a href="/account">account</a>
    </td>
    <td>
        <p>Items in cart: ${cartCount}</p>
    </td>

    <td>
        <a href="/order">cart</a>
    </td>
    </table>
	<h3>Products Page</h3>
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
				<td><img src="${pageContext.request.contextPath}/resources/static/ ${product.pictureURL }" width="50"></td>
				<td>${product.price }</td>
				<td>
				    <a href="/cart/buy/${product.p_id}">Buy</a>
				</td>
                <td>
                    <a href="/info/${product.p_id}">Info</a>
				</td>
			</tr>
		</c:forEach>
	</table>
    <a href="/registration">reg</a>
</body>
</html>