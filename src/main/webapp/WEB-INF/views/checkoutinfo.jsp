<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/checkoutinfo.js"></script>
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
    <form name="userdata" id="userdataId">
    <div class= "container">
        <div class="content">
            <h3>Confirm your order details</h3>
            <table>
                <td>
                    <p>First Name:  </p>
                    <p>Last Name:   </p>
                    <p>Patronymic:  </p>
                    <p>E-mail:      </p>
                    <p>Address:     </p>
                </td>
                <td id = "tdId">
                    <p><input id= "fn" type="text" name="firstName"  readonly value ="${userPage.firstName}"/></p>
                    <p><input id= "ln" type="text" name="lastName"   readonly value ="${userPage.lastName}"/></p>
                    <p><input id= "pa" type="text" name="patronymic" readonly value ="${userPage.patronymic}"/></p>
                    <p><input id= "em" type="text" name="email"      readonly value ="${userPage.email}"/></p>
                    <p><input id= "ad" type="text" name="address"    readonly value ="${userPage.address}"/></p>
                </td>
            </table>
            <p><input type="button" value="edit" id="buttonId" onClick="doOnClick();return false;"/>
        </form>
        <td>
            <a href="${pageContext.request.contextPath}/cart/checkout">Continue</a>
        </td>
        </div>
        <div class="sidebar"></div>
    </div>
    <div class="footer">
            copyright
    </div>
</body>
</html>