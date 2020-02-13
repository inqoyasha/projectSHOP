<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
<%@ include file="bar/navbar.jsp"%>
	<h3>Login page</h3>
    <form action="/login" method="post">
        <p> Login:    <input type="text" name="username" /></p>
        <p> Password: <input type="password" name="password" /></p>
        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
    </form>
    <a href="/registration">create new account</a>
</body>
</html>