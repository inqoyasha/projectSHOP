<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <header class="header">
            <div class="header-inner">
                <div class="logo">e-Shop</div>
                <nav class="nav">
                    <%@ include file="bar/navbar.jsp"%>
                </nav>
        </div>
    </header>
    <div class= "container">
        <div class="content">
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
            				<td>${orderProduct.product.productName}</td>
            				<td><img src="${pageContext.request.contextPath}/images/${orderProduct.product.pictureUrl}" width="50"></td>
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
            	<td>
            	    <a href="${pageContext.request.contextPath}/home">Back</a> to store
                </td>
        </div>
            <div class="sidebar"></div>
    </div>
    <div class="footer">
            copyright
    </div>
</body>
</html>
