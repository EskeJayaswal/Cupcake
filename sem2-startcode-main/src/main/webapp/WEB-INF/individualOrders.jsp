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
                <h1>Ordre-overview</h1>
            </div>

            <ol class="list-group list-group-numbered">
                <c:forEach var="currentOrder" items="${sessionScope.currentOrder}">

                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">${currentOrder.bottom.name} bottom with ${currentOrder.topping.name} topping</div>
                        ${currentOrder.quantity}<i>pcs</i>
                    </div>
                    <small>${currentOrder.price}<i>kr</i></small>
                </li>

                </c:forEach>
            </ol>
           <!-- <div>
                <p class="fs-6">Ordren kan afhentes senest: 10/11/2021</p>
            </div>-->

            <div class="badge bg-primary rounded-pill" name="subtotal" id="subtotal" style="width: 150px">
                Total: ${sessionScope.sumOfCurrentOrder}<i>kr</i>
            </div>

            <div class="container" id="buttonContainer">
                <button type="button" class="btn btn-primary" id="button1">Cancel</button>
                <button type="button" class="btn btn-primary" id="button2">Modify</button>
            </div>

        </div>

    </jsp:body>
</t:genericpage>
