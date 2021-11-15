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

        <div class="row">
            <div class="col-1">

            </div>

            <div class="container col-5 mx-5 my-5">


                <form action="${pageContext.request.contextPath}/fc/removeFromBasket" method="post">
                    <input type="hidden" name="target" value="manageCart"/>
                    <table class="table table-light">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Flavour</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Price</th>
                            <th scope="col"></th>
                        </tr>
                        <c:forEach var="cartItem" items="${applicationScope.cartList}">
                            <tr>
                                <td>${cartItem.id}</td>
                                <td>${cartItem.bottom.getName()} bottom with ${cartItem.topping.getName()} topping</td>
                                <td>${cartItem.quantity}pcs</td>
                                <td>${cartItem.price}kr</td>
                                <td>
                                    <button type="submit" name="fjernknap" value="${cartItem.getId()}"
                                            class="btn btn-primary">Fjern
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>


            </div>
            <div class="container col-3 mx-5 my-5">

                <form action="confirmation.html" method="post">
                    <hr class="my-4">

                    <h4 class="mb-3">Betaling</h4>

                    <div class="my-3">
                        <div class="form-check">
                            <input id="credit" name="paymentMethod" type="radio" class="form-check-input" checked=""
                                   required="">
                            <label class="form-check-label" for="credit">Kort</label>
                        </div>
                        <div class="form-check">
                            <input id="debit" name="paymentMethod" type="radio" class="form-check-input" required="">
                            <label class="form-check-label" for="debit">Kontant</label>
                        </div>
                    </div>


                    <hr class="my-4">

                    <button class="w-100 btn btn-primary btn-lg" type="submit">Afslut ordre</button>
                </form>
            </div>
            <div class="col-1">

            </div>

        </div>

    </jsp:body>
</t:genericpage>
