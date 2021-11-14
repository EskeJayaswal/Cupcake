<%@ page import="business.services.LogicFacade" %>
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
                <h1>Bestil dine cupcakes her</h1>
            </div>
            <div class="row">

                <div class="col-md-7 col-lg-7">
                    <form name="addToBasket" action="${pageContext.request.contextPath}/fc/addToBasket" method="POST">
                        <div class="row">

                            <div class="col-md-5">
                                <label for="bottom" class="form-label">Bund:</label>
                                <select class="form-select" name="bottomSelection" id="bottom" required="">
                                    <c:forEach var="bottomList" items="${applicationScope.bottomList}">
                                        <option value="${bottomList.id}">${bottomList.name}</option>
                                    </c:forEach>
                                </select>

                            </div>
                            <div class="col-md-4">
                                <label for="topping" class="form-label">Topping:</label>
                                <select class="form-select" name="toppingSelection" id="topping" required="">

                                    <c:forEach var="toppingList" items="${applicationScope.toppingList}">
                                        <option value="${toppingList.id}">${toppingList.name}</option>

                                    </c:forEach>

                                </select>

                            </div>
                            <div class="col-md-3">
                                <label for="quantity" class="form-label">Antal:</label>
                                <input type="number" min="1" max="100" class="form-control" name="quantitySelection" id="quantity" value="quantity" placeholder=""
                                       required="">
                            </div>


                        </div>
                        <button class="btn btn-primary mt-3" type="submit">Tilføj</button>
                    </form>

                </div>


                <div class="col-md-5 col-lg-5 order-md-last">
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-primary">Din kurv</span>
                        <span class="badge bg-primary rounded-pill">${applicationScope.cartList.size()}</span>
                    </h4>


                    <ul class="list-group mb-3">
                        <c:forEach var="cartItem" items="${applicationScope.cartList}">
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                            <div>
                                <h6 class="my-0">${cartItem.bottom.getName()} bund med ${cartItem.topping.getName()} topping</h6>
                                <small class="text-muted">${cartItem.quantity} stk</small>
                            </div>
                            <span class="text-muted">${cartItem.price}kr</span>
                        </li>
                        </c:forEach>
                    </ul>


                    <a href="${pageContext.request.contextPath}/fc/checkout">
                        <button class="btn btn-primary mt-1" type="submit" value="">Gå til kurv</button>
                    </a>
                </div>


            </div>
        </div>

    </jsp:body>
</t:genericpage>