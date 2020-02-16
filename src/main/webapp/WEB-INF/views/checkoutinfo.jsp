<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
<script>
    function doOnClick() {
        const button = document.getElementById("buttonId");
        if(button.value.toLowerCase() == 'edit'){
            button.value = 'save';
            document.getElementById("fn").removeAttribute("readonly");
            document.getElementById("ln").removeAttribute("readonly");
            document.getElementById("pa").removeAttribute("readonly");
            document.getElementById("em").removeAttribute("readonly");
            document.getElementById("ad").removeAttribute("readonly");
        } else {
            button.value = 'edit';
            send();
            document.getElementById("fn").setAttribute("readonly", true);
            document.getElementById("ln").setAttribute("readonly", true);
            document.getElementById("pa").setAttribute("readonly", true);
            document.getElementById("em").setAttribute("readonly", true);
            document.getElementById("ad").setAttribute("readonly", true);
        }
    }
    function send() {
        let formData = new FormData(document.forms.userdata);

        let xhr = new XMLHttpRequest();
        xhr.open("POST", "/account");
        xhr.send(formData);

        return false;
    }
</script>
</head>
<body>
<%@ include file="bar/navbar.jsp"%>
<h1>Confirm your order details</h1>
    <form name="userdata" id="userdataId">
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
</body>
</html>