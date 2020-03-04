<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page</title>
<script src="${pageContext.request.contextPath}/js/quantity.js"></script>
<script>
    function cartIncrement(id) {
        var a = parseInt(document.getElementById("qu"+id).value);
        a += 1;
        document.getElementById("qu"+id).value= a;
        const v = id;
        send(v);

        return false;
    }

    function cartDecrement(id) {
        var a = parseInt(document.getElementById("qu"+id).value);
        if (a != 1) {
            a -= 1;
        } else {
            a = 1;
        }
        document.getElementById("qu"+id).value= a;
        send(id);

        return false;
    }

    function send(id) {
        let formData = new FormData(document.forms.cartdata);

        let xhr = new XMLHttpRequest();
        xhr.open("POST", "cart/update/id");
        xhr.send(formData);

        return false;
    }

</script>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/input.css" rel="stylesheet" type="text/css">
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
            <h3>Cart Page</h3>
            <c:choose>
                <c:when test="${not empty orderProducts}">
                <form name="cartdata" id="cartdataId">
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
                                        <a href="${pageContext.request.contextPath}/cart/remove/${orderProduct.id}">Remove from cart </a>
                                    </td>
                                    <td>${orderProduct.product.productName }</td>
                                    <td><img src="${pageContext.request.contextPath}/images/${orderProduct.product.pictureUrl}" width="50"></td>
                                    <td>${orderProduct.product.price}</td>
                                    <td>
                                        <input type="button" id="butInc${orderProduct.id}" value="+" onclick="cartIncrement(${orderProduct.id});"/>
                                           <input id="qu${orderProduct.id}" type="text" name="quantity" readonly value ="${orderProduct.quantity}"/>
                                        <input type="button" id="butDec${orderProduct.id}" value="-" onclick="cartDecrement(${orderProduct.id});" type="button"/>
                                    </td>
                                    <td>${orderProduct.subPrice}</td>
                                </tr>
                            </c:forEach>

                              <tfoot>
                                <tr>
                                  <th id="total" colspan="5">Total :</th>
                                  <td>${totalOrderPrice}</td>
                                </tr>
                               </tfoot>
                        </table>
                        </form>
                            <a href="${pageContext.request.contextPath}/home">Continue Shopping</a>
                            <a href="${pageContext.request.contextPath}cart/create/checkout">Checkout</a>
                </c:when>
                <c:otherwise>
                    <p>
                        <p>Your cart is empty!</p>
                        <a href="${pageContext.request.contextPath}/home">Back </a>to store
                    </p>
                </c:otherwise>
            </c:choose>
        </div>
            <div class="sidebar"></div>
    </div>
    <div class="footer">
            copyright
    </div>
</body>
</html>