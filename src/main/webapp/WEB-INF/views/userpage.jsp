<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user page</title>
</head>
<body>
<h1>enter your data</h1>
    <form method="post">
        <table>
            <tr>
                <p>First Name: <input type="text" name="firstName" /></p>
                <p>Last Name: <input type="text" name="lastName" /></p>
                <p>Patronymic: <input type="text" name="patronymic" /></p>
                <p>e-mail: <input type="text" name="email" /></p>
                <p>Address: <input type="text" name="address" /></p>

                <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
            </tr>
        </table>
    </form>
</body>
</html>