<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin page</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/sortTable.js"></script>
</head>
<body>
<div class="wrapper">
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
            <h3>Users</h3>
                <table id = "productTableId" cellpadding="2" cellspacing="2" border="1">
                    <tr>
                        <th></th>
                        <th>UserName</th>
                        <th>Orders</th>
                    </tr>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.id }</td>
                            <td>${user.username}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/admin/user-orders/${user.id}">Info</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
        </div>
        <div class="sidebar">
        </div>
    </div>
    <div class="footer">
        copyright
    </div>
</div>
</body>
</html>