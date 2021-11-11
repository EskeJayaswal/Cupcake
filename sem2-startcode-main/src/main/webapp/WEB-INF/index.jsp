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
                    <form name="addToBasket" action="#" method="POST">
                        <div class="row">

                            <div class="col-md-5">
                                <label for="country" class="form-label">Bund:</label>
                                <select class="form-select" id="country" required="">
                                    <option value="">Vælg..</option>
                                    <option>Chokolade</option>
                                    <option>Mandel</option>
                                    <option>Marcipan</option>
                                </select>
                                <div class="invalid-feedback">
                                    Please select a valid country.
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label for="state" class="form-label">Topping:</label>
                                <select class="form-select" id="state" required="">
                                    <option value="">Vælg..</option>
                                    <option>Jordbær</option>
                                    <option>Mango</option>
                                    <option>Oreo</option>
                                </select>
                                <div class="invalid-feedback">
                                    Please provide a valid state.
                                </div>
                            </div>
                            <div class="col-md-3">
                                <label for="quantity" class="form-label">Antal:</label>
                                <input type="number" min="1" max="100" class="form-control" id="quantity" placeholder=""
                                       required="">
                            </div>


                        </div>
                        <button class="btn btn-primary mt-3" type="submit" value="Reset Button">Tilføj</button>
                    </form>
                </div>

                <div class="col-md-5 col-lg-5 order-md-last">
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-primary">Din kurv</span>
                        <span class="badge bg-primary rounded-pill">3</span>
                    </h4>


                                        <ul class="list-group mb-3">
                                            <li class="list-group-item d-flex justify-content-between lh-sm">
                                                <div>
                                                    <h6 class="my-0">Chokolade bund med jordbær topping</h6>
                                                    <small class="text-muted">20stk</small>
                                                </div>
                                                <span class="text-muted">100kr</span>
                                            </li>

                                            <li class="list-group-item d-flex justify-content-between lh-sm">
                                                <div>
                                                    <h6 class="my-0">Mandel bund med oreo topping</h6>
                                                    <small class="text-muted">15stk</small>
                                                </div>
                                                <span class="text-muted">80kr</span>
                                            </li>
                                            <li class="list-group-item d-flex justify-content-between lh-sm">
                                                <div>
                                                    <h6 class="my-0">Chokolade bund med oreo topping</h6>
                                                    <small class="text-muted">30stk</small>
                                                </div>
                                                <span class="text-muted">150kr</span>
                                            </li>
                                            <li class="list-group-item d-flex justify-content-between lh-sm mt-2">
                                                <div>
                                                    <h6 class="my-0">Sub total</h6>
                                                    <small class="text-muted">65stk</small>
                                                </div>
                                                <span class="text-muted">330kr</span>
                                            </li>

                                        </ul>


                    <a href="${pageContext.request.contextPath}/fc/checkout">
                        <button class="btn btn-primary mt-1" type="submit" value="">Gå til kurv</button>
                    </a>
                </div>

            </div>
        </div>

    </jsp:body>
</t:genericpage>