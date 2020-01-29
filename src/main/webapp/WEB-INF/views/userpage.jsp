<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user page</title>
<script>
    function doOnClick() {
    const button = document.getElementById('editBtn');
    if(button.value.toLowerCase() == 'edit'){
        button.value = 'save';
        document.getElementById("fn").disabled = false;
        document.getElementById("ln").disabled = false;
        document.getElementById("pa").disabled = false;
        document.getElementById("em").disabled = false;
        document.getElementById("ad").disabled = false;
    } else {
        button.value = 'edit';
        document.getElementById("fn").disabled = true;
        document.getElementById("ln").disabled = true;
        document.getElementById("pa").disabled = true;
        document.getElementById("em").disabled = true;
        document.getElementById("ad").disabled = true;
        form.submit();
    }

    return false;
    }
</script>
</head>
<body>
<h1>enter your data</h1>
    <form name="form" id="formId" method="post">
        <table>
            <td>
                <p>First Name:  <input id= "fn" type="text" name="firstName"  disabled="true" value ="${userPage.firstName}"  /></p>
                <p>Last Name:   <input id= "ln" type="text" name="lastName"   disabled="true" value ="${userPage.lastName}" /></p>
                <p>Patronymic:  <input id= "pa" type="text" name="patronymic" disabled="true" value ="${userPage.patronymic}" /></p>
                <p>E-mail:      <input id= "em" type="text" name="email"      disabled="true" value ="${userPage.email}" /></p>
                <p>Address:     <input id= "ad" type="text" name="address"    disabled="true" value ="${userPage.address}" /></p>

                <p><input type="button" value="edit" id ="editBtn" onClick="doOnClick();"/>
            </td>
        </table>
    </form>
</body>
</html>