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
