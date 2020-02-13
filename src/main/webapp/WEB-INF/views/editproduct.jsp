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
                document.getElementById("pn").removeAttribute("readonly");
            } else {
                button.value = 'edit';
                send();
                document.getElementById("pn").setAttribute("readonly", true);
            }
            break;
      case "editBtn2":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("ph").removeAttribute("readonly");
            } else {
                button.value = 'edit';
                send();
                document.getElementById("ph").setAttribute("readonly", true);
            }
            break;
      case "editBtn3":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("pr").removeAttribute("readonly");
            } else {
                button.value = 'edit';
                send();
                document.getElementById("pr").setAttribute("readonly", true);
            }
            break;
      case "editBtn4":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("qu").removeAttribute("readonly");
            } else {
                button.value = 'edit';
                send();
                document.getElementById("qu").setAttribute("readonly", true);
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
        let formData = new FormData(document.forms.productdata);

        let xhr = new XMLHttpRequest();
        xhr.open("POST", "/manage/edit/${product.p_id}");
        xhr.send(formData);

        return false;
    }
</script>
</head>
<body>
<%@ include file="bar/navbar.jsp"%>
<h1>Manage product</h1>
    <form name="productdata" id="productdataId">
        <table>
            <td>
                <p>Name:  </p>
                <p>Photo: </p>
                <p>Price: </p>
                <p>Quantity: </p>
            </td>
            <td>
                <p><input id= "pn" type="text" name="productName"  readonly value ="${product.productName}"/></p>
                <p><input id= "ph" type="text" name="pictureURL"    readonly value ="${product.pictureURL}"/></p>
                <p><input id= "pr" type="text" name="price"    readonly value ="${product.price}"/></p>
                <p><input id= "qu" type="text" name="quantity" readonly value = "quantity" /></p>
            </td>
            <td>
                <c:forEach var = "i" begin = "1" end = "4">
                    <p><input type="button" value="edit" id ="editBtn${i}" onClick="doOnClick(this.id);"/>
                </c:forEach>
            </td>
        </table>
    </form>
</body>
</html>