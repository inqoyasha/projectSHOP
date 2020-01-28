<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user data</title>
</head>
<body>
    <h1>Congratulations!</h1>
    <h1>user data</h1>
    <li>First Name: ${userPage.firstName}</li>
    <li>Last Name:  ${userPage.lastName}</li>
    <li>Patronymic: ${userPage.patronymic}</li>
    <li>Email:      ${userPage.email}</li>
    <li>Address:    ${userPage.address}</li>

    <p></p>
    <a href="/account">Submit another data</a>

</body>
</html>