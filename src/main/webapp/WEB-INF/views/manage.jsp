<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Product</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/sortTable.js"></script>
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
            <h3>Products management</h3>
                <table id = "productTableId" cellpadding="2" cellspacing="2" border="1">
                <tr>
                    <th></th>
                    <th>Name</th>
                    <th>Photo</th>
                    <th>Price</th>

                </tr>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.id }</td>
                        <td>${product.productName }</td>
                        <td><img src="${pageContext.request.contextPath}/images/${product.pictureUrl}" width="50"></td>
                        <td>${product.price }</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/manage/edit/${product.id}">Edit</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/info/${product.id}">Info</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
            <div class="sidebar"></div>
    </div>
    <div class="footer">
            copyright
    </div>
</body>
</html>


