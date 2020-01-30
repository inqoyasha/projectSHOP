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
                document.getElementById("fn").removeAttribute("readonly");
            } else {
                button.value = 'edit';
                send();
                document.getElementById("fn").setAttribute("readonly", true);
            }
            break;
      case "editBtn2":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("ln").removeAttribute("readonly");
            } else {
                button.value = 'edit';
                send();
                document.getElementById("ln").setAttribute("readonly", true);
            }
            break;
      case "editBtn3":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("pa").removeAttribute("readonly");
            } else {
                button.value = 'edit';
                send();
                document.getElementById("pa").setAttribute("readonly", true);
            }
            break;
      case "editBtn4":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("em").removeAttribute("readonly");
            } else {
                button.value = 'edit';
                send();
                document.getElementById("em").setAttribute("readonly", true);
            }
            break;
      case "editBtn5":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("ad").removeAttribute("readonly");
            } else {
                button.value = 'edit';
                send();
                document.getElementById("ad").setAttribute("readonly", true);
            }
            break;
    }
    return false;
    }

</script>
<script>
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
<h1>enter your data</h1>
    <form name="userdata" id="userdataId">
        <table>
            <td>
                <p>First Name:  <input id= "fn" type="text" name="firstName"  readonly value ="${userPage.firstName}"  /></p></p>
                <p>Last Name:   <input id= "ln" type="text" name="lastName"   readonly value ="${userPage.lastName}" /></p>
                <p>Patronymic:  <input id= "pa" type="text" name="patronymic" readonly value ="${userPage.patronymic}" /></p>
                <p>E-mail:      <input id= "em" type="text" name="email"      readonly value ="${userPage.email}" /></p>
                <p>Address:     <input id= "ad" type="text" name="address"    readonly value ="${userPage.address}" /></p>
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