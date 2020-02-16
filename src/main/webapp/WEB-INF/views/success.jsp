<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
</head>
<body>
<%@ include file="bar/navbar.jsp"%>
	<h3>Product info</h3>
        <table cellpadding="2" cellspacing="2" border="1">
            <tr>
                <th>Name </th>
                <th>Photo </th>
                <th>Price </th>
                <th>Quantity </th>
                <th>Total price: </th>
            </tr>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>${order.product.productName }</td>
                    <td><img src="${pageContext.request.contextPath}/images/${orderProduct.product.pictureURL}" width="50"></td>
                    <td>${order.product.price}</td>
                    <td>${order.quantity}</td>
                    <td>${order.product.price * orderProduct.quantity}</td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>
