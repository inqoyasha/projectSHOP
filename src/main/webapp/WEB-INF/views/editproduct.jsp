<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user page</title>
<script src="${pageContext.request.contextPath}/js/editproduct.js"></script>
<script>
function send() {
             let formData = new FormData(document.forms.productdata);

             let xhr = new XMLHttpRequest();
             xhr.open("PUT", "/manage/edit/${product.p_id}");
             xhr.send(formData);

             return false;
         }
</script>
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
    <form name="productdata" id="productdataId">
    <div class= "container">
        <div class="content">
        <h3>Manage product</h3>
        <table>
            <td>
                <p>Name:  </p>
                <p>Photo: </p>
                <p>Price: </p>
                <p>Quantity: </p>
                <p>description: </p>
                <p>Manufacturer: </p>
                <p>Active: </p>
                <p>Category: </p>
            </td>
            <td>
                <p><input id= "pn" type="text" name="productName" readonly value ="${product.productName}"/></p>
                <p><input id= "ph" type="text" name="pictureURL"  readonly value ="${product.pictureURL}"/></p>
                <p><input id= "pr" type="number" name="price"       readonly value ="${product.price}"/></p>
                <p><input id= "qu" type="number" name="quantity"    readonly value ="${product.quantity}"/></p>
                <p><input id= "de" type="text" name="description" readonly value ="${product.description}"/></p>
                <p><input id= "ma" type="text" name="manufacturer" readonly value ="${product.manufacturer}"/></p>
                <p><input id= "ac" type="text" name="active"      readonly value ="${product.active}"/></p>
                <p><input id= "ca" type="number" name="category"    readonly value ="${product.category.c_id}"/></p>
            </td>
            <td>
                <c:forEach var = "i" begin = "1" end = "8">
                    <p><input type="button" value="edit" id ="editBtn${i}" onClick="doOnClick(this.id);"/>
                </c:forEach>
            </td>
        </table>
        <a href="${pageContext.request.contextPath}/manage/show/all">Back</a>
        </div>
            <div class="sidebar"></div>
    </div>
    <div class="footer">
            copyright
    </div>
    </form>
</body>
</html>