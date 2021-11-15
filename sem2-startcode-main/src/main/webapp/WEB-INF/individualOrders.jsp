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
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Blåbærbund med peanut-topping</div>
                        Antal: 20
                    </div>
                    <small>1200 dkk</small>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Mandelbund med jordbær-topping</div>
                        Antal: 40
                    </div>
                    <small>600 dkk</small>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Klassisk bund med chokolade-topping</div>
                        Antal: 30
                    </div>
                    <small>1500 dkk</small>
                </li>
            </ol>
            <div>
                <p class="fs-6">Ordren kan afhentes senest: 10/11/2021</p>
            </div>

            <div class="badge bg-primary rounded-pill" name="subtotal" id="subtotal" style="width: 150px">
                Subtotal: DKK 1400
            </div>

            <div class="container" id="buttonContainer">
                <button type="button" class="btn btn-primary" id="button1">Anuller ordre</button>
                <button type="button" class="btn btn-primary" id="button2">Rediger ordre</button>
            </div>

        </div>

    </jsp:body>
</t:genericpage>
