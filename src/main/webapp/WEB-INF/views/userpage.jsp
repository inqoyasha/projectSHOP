<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user page</title>
<script src="${pageContext.request.contextPath}/js/userpage.js"></script>
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
    <form name="userdata" id="userdataId">
    <div class= "container">
        <div class="content">
            <h3>Your profile</h3>
            <table>
                <td>
                    <p>First Name:  </p>
                    <p>Last Name:   </p>
                    <p>Patronymic:  </p>
                    <p>E-mail:      </p>
                    <p>Address:     </p>
                </td>
                <td>
                    <p>
                        <div>
                            <input id= "fn" type="text" name="firstName"  readonly value ="${userPage.firstName}"/>
                            <input type="button" value="edit" id ="editBtn1" onClick="doOnClick(this.id);"/>
                        </div>
                    </p>
                    <p>
                        <div>
                            <input id= "ln" type="text" name="lastName"   readonly value ="${userPage.lastName}"/>
                            <input type="button" value="edit" id ="editBtn2" onClick="doOnClick(this.id);"/>
                        </div>
                    </p>
                    <p>
                        <div>
                            <input id= "pa" type="text" name="patronymic" readonly value ="${userPage.patronymic}"/>
                            <input type="button" value="edit" id ="editBtn3" onClick="doOnClick(this.id);"/>
                        </div>
                    </p>
                    <p>
                        <div>
                            <input id= "em" type="text" name="email"      readonly value ="${userPage.email}"/>
                            <input type="button" value="edit" id ="editBtn4" onClick="doOnClick(this.id);"/>
                        </div>
                    </p>
                    <p>
                        <div>
                            <input id= "ad" type="text" name="address"    readonly value ="${userPage.address}"/>
                            <input type="button" value="edit" id ="editBtn5" onClick="doOnClick(this.id);"/>
                        </div>
                    </p>
                </td>
            </table>
        </div>
            <div class="sidebar"></div>
    </div>
    <div class="footer">
            copyright
    </div>

    </form>
</body>
</html>