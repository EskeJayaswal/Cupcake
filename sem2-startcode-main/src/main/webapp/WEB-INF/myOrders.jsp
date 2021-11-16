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
            <div class="my-5">
                <h1>Order overview</h1>
            </div>

            <div class="list-group">
                <c:forEach var="orderList" items="${applicationScope.orderList}">
                    <a href="${pageContext.request.contextPath}/fc/individualOrders"
                       class="list-group-item list-group-item-action">
                        <div class="d-flex w-100 justify-content-between">


                            <option value="${orderList.user_id}">${orderList.created}</option>

<!--!>
                        </div>
                        <p class="mb-1">Forudbestilt</p>
                    </a>
                </c:forEach>
            </div>

        </div>

    </jsp:body>
</t:genericpage>
