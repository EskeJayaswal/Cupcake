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

        <div id="page-content">
            <div class="">


                <div class="border border-dark p-5 mt-4 mb-4 container">

                    <div class="text-center">
                        <h1 class="my-5 p-4 display-5 fw-normal text-dark">Your order is now processed.</h1>
                        <h2 class="my-5 p-4 text-dark">Confirmation mail sent to: ${sessionScope.email}</h2>
                        <a href="${pageContext.request.contextPath}/fc/index" class="btn btn-primary btn-lg">Til forside</a>
                    </div>

                </div>

            </div>

        </div>

    </jsp:body>
</t:genericpage>