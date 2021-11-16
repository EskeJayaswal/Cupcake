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
            <form action="${pageContext.request.contextPath}/fc/userOrders" method="post">

            <ul class="list-group">
                <c:forEach var="userList" items="${sessionScope.userList}">
                    <button class="list-group-item list-group-item-action" type="submit" name="userIdAdmin" value="${userList.id}">

                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <option>${userList.fname}</option>
                            <span class="badge bg-primary rounded-pill">Antal ordre</span>
                        </li>
                    </button>

                </c:forEach>
            </ul>
            </form>
        </div>

    </jsp:body>
</t:genericpage>
