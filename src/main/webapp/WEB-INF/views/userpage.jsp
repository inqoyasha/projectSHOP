<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user page</title>
<script>
    function doOnClick(clicked_id) {
    const button = document.getElementById(clicked_id);
    switch(clicked_id) {
      case "editBtn1":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("fn").disabled = false;
                button.type = "button";
            } else {
                button.value = 'edit';
                document.getElementById("fn").disabled = true;
                button.type = "submit";
            }
            break;
      case "editBtn1":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("fn").disabled = false;
                button.type = "button";
            } else {
                button.value = 'edit';
                document.getElementById("fn").disabled = true;
                button.type = "submit";
            }
            break;
      case "editBtn1":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("fn").disabled = false;
                button.type = "button";
            } else {
                button.value = 'edit';
                document.getElementById("fn").disabled = true;
                button.type = "submit";
            }
            break;
      case "editBtn1":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("fn").disabled = false;
                button.type = "button";
            } else {
                button.value = 'edit';
                document.getElementById("fn").disabled = true;
                button.type = "submit";
            }
            break;
      case "editBtn1":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("fn").disabled = false;
                button.type = "button";
            } else {
                button.value = 'edit';
                document.getElementById("fn").disabled = true;
                button.type = "submit";
            }
            break;
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
            </td>
            <td>
                <p><input type="button" value="edit" id ="editBtn1" onClick="doOnClick(this.id);"/>
                <p><input type="button" value="edit" id ="editBtn2" onClick="doOnClick(this.id);"/>
                <p><input type="button" value="edit" id ="editBtn3" onClick="doOnClick(this.id);"/>
                <p><input type="button" value="edit" id ="editBtn4" onClick="doOnClick(this.id);"/>
                <p><input type="button" value="edit" id ="editBtn5" onClick="doOnClick(this.id);"/>
            </td>
        </table>
    </form>
</body>
</html>