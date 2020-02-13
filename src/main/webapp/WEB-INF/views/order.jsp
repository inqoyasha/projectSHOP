<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page</title>
</head>
<body>
  <%@ include file="bar/navbar.jsp"%>
	<h3>Cart Page</h3>

    <c:choose>
        <c:when test="${not empty orderProducts}">
            <table cellpadding="2" cellspacing="2" border="1">
            		<tr>
            		    <th>del </th>
            			<th>Name </th>
            			<th>Photo </th>
            			<th>Price </th>
                        <th>Quantity </th>
                        <th>Total price: </th>
            		</tr>
            		<c:forEach var="orderProduct" items="${orderProducts}">
            			<tr>
            			    <td align="center">
            			        <a href="${pageContext.request.contextPath }/cart/remove/${orderProduct.op_id}">Remove from cart </a>
                        	</td>
            				<td>${orderProduct.product.productName }</td>
            				<td><img src="${pageContext.request.contextPath}/images/${orderProduct.product.pictureURL}" width="50"></td>
            				<td>${orderProduct.product.price}</td>
            				<td>${orderProduct.quantity}</td>
            				<td>${orderProduct.product.price * orderProduct.quantity}</td>
            			</tr>
            		</c:forEach>
            	</table>
            	    <a href="${pageContext.request.contextPath}/home">Continue Shopping</a>
                    <a href="${pageContext.request.contextPath}/cart/checkout">Checkout</a>
        </c:when>
        <c:otherwise>
            <p>
                Your cart is empty!<br>
                <a href="${pageContext.request.contextPath}/home">Continue Shopping</a>
            </p>
        </c:otherwise>
    </c:choose>

</body>
</html>