<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
<script>
    window.onload = function sortTable() {
      var table, rows, switching, i, x, y, shouldSwitch;
      table = document.getElementById("productTableId");
      switching = true;
      while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
          shouldSwitch = false;
          x = rows[i].getElementsByTagName("TD")[0];
          y = rows[i + 1].getElementsByTagName("TD")[0];
          if (Number(x.innerHTML) > Number(y.innerHTML)) {
            shouldSwitch = true;
            break;
          }
        }
        if (shouldSwitch) {
          rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
          switching = true;
        }
      }
    }
</script>
</head>
<body>
    <%@ include file="bar/navbar.jsp"%>
	<h3>Products Page</h3>
	<%@ include file="bar/sidebar.jsp"%>
	<table id = "productTableId" cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th></th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th></th>
		</tr>
		<c:forEach items="${products }" var="product">
			<tr>
				<td>${product.p_id }</td>
				<td>${product.productName }</td>
				<td><img src="${pageContext.request.contextPath}/images/ ${product.pictureURL }" width="50"></td>
				<td>${product.price }</td>
				<td>
				    <sec:authorize access="hasAnyRole('USER','ANONYMOUS')">
				        <a href="${pageContext.request.contextPath}/cart/buy/${product.p_id}">Buy</a>
				    </sec:authorize>
				    <sec:authorize access="hasRole('ADMIN')">
				        <a href="${pageContext.request.contextPath}/manage/show/all">Edit</a>
				    </sec:authorize>
				</td>
                <td>
                    <a href="${pageContext.request.contextPath}/info/${product.p_id}">Info</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>