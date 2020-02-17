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
		<h3>Your order is submitted!</h3>
            <table cellpadding="2" cellspacing="2" border="1">
            		<tr>
            			<th>Name </th>
            			<th>Photo </th>
            			<th>Price </th>
                        <th>Quantity </th>
                        <th>Total price </th>
            		</tr>
            		<c:forEach var="orderProduct" items="${orderProducts}">
            			<tr>
            				<td>${orderProduct.product.productName }</td>
            				<td><img src="${pageContext.request.contextPath}/images/${orderProduct.product.pictureURL}" width="50"></td>
            				<td>${orderProduct.product.price}</td>
            				<td>${orderProduct.quantity}</td>
                            <td>${orderProduct.subPrice}</td>
            			</tr>
            		</c:forEach>

            		  <tfoot>
                        <tr>
                          <th id="total" colspan="4">Total :</th>
                          <td>${totalOrderPrice}</td>
                        </tr>
                       </tfoot>
            	</table>
        <a href="${pageContext.request.contextPath}/home">Back</a> to store
</body>
</html>
