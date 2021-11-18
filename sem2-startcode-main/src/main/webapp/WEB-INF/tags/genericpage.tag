<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        <jsp:invoke fragment="header"/>
    </title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="icon" href="icon_path" type="image/icon type">

    <style>
        <%@include file="/css/styles.css"%>
    </style>

</head>
<body style="background-color: #EAE7F2">
<!--
    This header is inspired by this bootstrap
    example: https://getbootstrap.com/docs/5.0/examples/pricing/
-->
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background: #3C1460">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/fc/index"><img
                    src="${pageContext.request.contextPath}/images/OlskarLogo.PNG" height="120"
                    alt="Missing logo"></a>


            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarMainMenu">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarMainMenu">
                <ul class="navbar-nav ml-auto">
                    <c:if test="${sessionScope.user.role == 'customer' }">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/fc/myOrders">My orders</a>
                    </li>
                    </c:if>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Settings</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Order</a>
                    </li>
                </ul>
            </div>
            <a href="${pageContext.request.contextPath}/fc/checkout">

                <svg xmlns="http://www.w3.org/2000/svg" height="30" fill="grey" class="bi bi-cart2" viewBox="0 0 16 16">
                    <path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l1.25 5h8.22l1.25-5H3.14zM5 13a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
                </svg>

            </a>


            <div>

                <c:if test="${sessionScope.user != null }">
                    <div style = "color: white">
                            ${sessionScope.user.email}
                    </div>

                </c:if>

                <c:set var="thisPage" value="${pageContext.request.servletPath}"/>
                <c:set var="isNotLoginPage" value="${!fn:endsWith(thisPage,'loginpage.jsp')}"/>
                <c:set var="isNotRegisterPage" value="${!fn:endsWith(thisPage,'registerpage.jsp')}"/>

                <c:if test="${isNotLoginPage && isNotRegisterPage}">
                <c:if test="${sessionScope.user != null }">
                    <a type="button" class="btn btn-sm  btn-outline-secondary"
                       href="${pageContext.request.contextPath}/fc/logoutcommand">Logout</a>
                </c:if>
                <c:if test="${sessionScope.user == null }">
                    <a type="button" class="btn btn-sm  btn-outline-secondary"
                       href="${pageContext.request.contextPath}/fc/loginpage">Login</a>
                    <a type="button" class="btn btn-sm  btn-outline-secondary"
                       href="${pageContext.request.contextPath}/fc/registerpage">Register</a>
                </c:if>
            </div>
            </c:if>


        </div>
    </nav>
</header>

<div id="body" class="container" style="min-height: 20vh;">
    <jsp:doBody/>
</div>

<!-- Footer -->
<div class="container">
    <br>
    <hr>
    <br>
    <jsp:invoke fragment="footer"/>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>