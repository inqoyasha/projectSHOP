<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Product</title>
</head>
<body>
<%@ include file="bar/navbar.jsp"%>
	<h3>Products management</h3>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th></th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th></th>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.p_id }</td>
				<td>${product.productName }</td>
				<td><img src="${pageContext.request.contextPath}/images/${product.pictureURL}" width="50"></td>
				<td>${product.price }</td>
				<td>
				    <a href="${pageContext.request.contextPath}/manage/edit/${product.p_id}">Edit</a>
				</td>
                <td>
                    <a href="${pageContext.request.contextPath}/info/${product.p_id}">Info</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

