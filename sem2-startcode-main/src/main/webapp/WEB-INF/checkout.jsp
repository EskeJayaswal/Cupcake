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


            <div class="container col-7 mx-5 my-5">
                <table class="table table-light mb-3">
                   <tr><h5>Name: ${sessionScope.fname} ${sessionScope.lname}</h5></tr>
                    <tr><h5>Balance: ${sessionScope.balance}</h5></tr>
                </table>


                <form action="${pageContext.request.contextPath}/fc/removeFromBasket" method="post">

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
                                <td>${cartItem.quantity}<i>pcs</i></td>
                                <td>${cartItem.price}<i>kr</i></td>
                                <td>
                                    <button type="submit" name="fjernknap" value="${cartItem.getId()}"
                                            class="btn btn-primary">Remove
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <th scope="col"></th>
                            <th scope="col"></th>
                            <th scope="col">${sessionScope.sumQuantity}<i>pcs</i></th>
                            <th scope="col">${sessionScope.sumPrice}<i>kr</i></th>
                            <th scope="col"></th>
                        </tr>
                    </table>
                </form>


            </div>
            <div class="container col-3 mx-5 my-5">

                <form action="confirmation.html" method="post">
                    <hr class="my-4">

                    <h4 class="my-3">Payment</h4>

                    <div class="my-3">
                        <div class="form-check">
                            <input id="credit" name="paymentMethod" type="radio" class="form-check-input" checked=""
                                   required="">
                            <label class="form-check-label" for="credit">Credit card</label>
                        </div>
                        <div class="form-check">
                            <input id="debit" name="paymentMethod" type="radio" class="form-check-input" required="">
                            <label class="form-check-label" for="debit">Account</label>
                        </div>
                    </div>


                    <hr class="my-4">

                    <button class="btn btn-primary" type="submit">Confirm</button>
                </form>
            </div>


        </div>

    </jsp:body>
</t:genericpage>
