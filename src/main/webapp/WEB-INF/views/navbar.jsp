<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<table>
    <td>
        <button onclick="location.href='/home'" type="button">home</button>
    </td>
    <td>
        <button onclick="location.href='/account'" type="button">account</button>
    </td>
    <td>
        <button onclick="location.href='/registration'" type="button">registration</button>
    </td>
    <td>
        <button onclick="location.href='/welcome'" type="button">welcome</button>
    </td>
    <td>
        <button onclick="location.href='/cart'" type="button">cart</button>
    </td>
    <td>
        <button onclick="location.href='/logout'" type="button">logout</button>
    </td>
    <td>
        <p>Items in cart: ${cartCount}</p>
    </td>
</table>
</html>