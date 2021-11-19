<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Customer's orders
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <div class="container">
            <div class="my-5">
                <h1>Order overview</h1>
            </div>
            <!--<form action="${pageContext.request.contextPath}/fc/individualOrders" method="post">-->


            <div class="list-group">
                <c:forEach var="orderListAdmin" items="${sessionScope.orderListAdmin}">
                    <button class="list-group-item list-group-item-action" type="submit" name="individualOrder" value="${orderListAdmin.order_id}">


                        <div class="d-flex w-100 justify-content-between">


                            <option>${orderListAdmin.created}</option>
                            <option>Order number:  dk-00000${orderListAdmin.order_id}</option>

                        </div>
                        <p class="mb-1">${orderListAdmin.status}</p>
                    </button>
                </c:forEach>
            </div>
            <!--</form>-->
        </div>

    </jsp:body>
</t:genericpage>
