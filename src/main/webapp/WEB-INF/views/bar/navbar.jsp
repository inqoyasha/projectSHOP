<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<table>
    <td>
        <button onclick="location.href='/home'" type="button">home</button>
    </td>

    <sec:authorize access="hasRole('USER')">
        <td>
            <button onclick="location.href='/account'" type="button">account</button>
        </td>
    </sec:authorize>

    <sec:authorize access="hasRole('ADMIN')">
        <td>
            <button onclick="location.href='/manage/show/all'" type="button">manage</button>
        </td>
    </sec:authorize>

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