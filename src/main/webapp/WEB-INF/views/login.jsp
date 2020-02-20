<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
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
    <form action="/login" method="post">
        <div class= "container">
            <div class="content">
            	<h3>Login</h3>
                <table>
                    <td>
                        <p> Login:  </p>
                        <p> Password: </p>
                    </td>
                    <td>
                        <input type="text" name="username" /></p>
                        <input type="password" name="password" /></p>
                    </td>
                </table>
                <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
            </div>
                <div class="sidebar"></div>
        </div>
        <div class="footer">
                copyright
        </div>
    </form>
</body>
</html>