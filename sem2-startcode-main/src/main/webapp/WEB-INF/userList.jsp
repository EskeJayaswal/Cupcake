<<<<<<< Updated upstream
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <div class="container">
            <div class="my-3">
                <h1>Users</h1>
            </div>

            <ul class="list-group">
                <c:forEach var="userList" items="${applicationScope.userList}">
                    <a href="${pageContext.request.contextPath}/fc/userOrders"
                       class="list-group-item list-group-item-action">

                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <option value="${userList.email}">${userList.fname}</option>
                            <span class="badge bg-primary rounded-pill">Antal ordre</span>
                        </li>
                    </a>

                </c:forEach>
            </ul>

        </div>

    </jsp:body>
</t:genericpage>

