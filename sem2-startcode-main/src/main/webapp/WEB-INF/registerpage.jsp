<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Register as new User
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div style="margin-top: 5em;">
            <form name="login" action="${pageContext.request.contextPath}/fc/registercommand" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="email">Email</label>
                    <div class="col-sm-4">

                        <input id="email" class="form-control" type="text" name="email" value="${param.email}" placeholder="Indtast email">

                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="password1">Password</label>
                    <div class="col-sm-4">

                        <input id="password1" class="form-control" type="password" name="password1"  value="${param.password1}"  placeholder="Indtast password">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="password2">Password</label>
                    <div class="col-sm-4">

                        <input id="password2" class="form-control" type="password" name="password2" value="${param.password2}"  placeholder="Bekræft password">

                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="fname">Fornavn</label>
                    <div class="col-sm-4">
                        <input id="fname" class="form-control" type="text" name="fname" value="${param.fname}" placeholder="Indtast fornavn">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="lname">Efternavn</label>
                    <div class="col-sm-4">
                        <input id="lname" class="form-control" type="text" name="lname" value="${param.lname}" placeholder="Indtast efternavn">
                    </div>
                </div>

                <input class="btn btn-primary" type="submit" value="Bekræft">
            </form>

            <c:if test="${requestScope.error != null }">
                <p style="color:red">
                        ${requestScope.error}
                </p>
            </c:if>
        </div>
    </jsp:body>
</t:genericpage>


