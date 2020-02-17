<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<%@ include file="bar/navbar.jsp"%>
	<h3>Registration</h3>
    <form action="/registration" method="post">
        <table>
            <td>
                <p> Login:  </p>
                <p> Password: </p>
            </td>
            <td>
                <input type="text" name="username" /></p>
                <input type="password" name="password" /></p>
            </td>
            <td>
                <p><c:if test="${not empty message}">${message}</c:if></p>
            </td>
        </table>
        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
    </form>
</body>
</html>