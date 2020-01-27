<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page</title>
</head>
<body>

	<h3>Cart Page</h3>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Id </th>
			<th>Name </th>
			<th>Photo </th>
			<th>Price </th>
            <th>Quantity </th>
            <th>Total price: </th>
			<th></th>
		</tr>
		<c:forEach var="orderProduct" items="${sessionScope.cart}">
			<tr>
				<td>${orderProduct.product.p_id }</td>
				<td>${orderProduct.product.productName }</td>
				<td><img src="${pageContext.request.contextPath}/resources/static/ ${orderProduct.product.pictureURL }" width="50"></td>
				<td>${orderProduct.product.price }</td>
				<td>${orderProduct.quantity }</td>
				<td>${orderProduct.product.price * orderProduct.quantity}</td>
				<td align="center"></td>

			</tr>
		</c:forEach>
	</table>
<a href="${pageContext.request.contextPath }/store">Continue
		Shopping</a>
</body>
</html>