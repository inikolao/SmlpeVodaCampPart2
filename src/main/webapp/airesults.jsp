<%--
  Created by IntelliJ IDEA.
  User: Ioannis
  Date: 3/3/2023
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/topdown/header.jsp"%>
<div id="booking" class="section">
  <div class="section-center">
    <div class="container">
      <div class="row">
        <div class="booking-form">
          <table class="table table-dark">
            <thead class="thead-light">
            <tr>
              <th scope="col">Flight #</th>
              <th scope="col">Home Airport</th>
              <th scope="col">Destination Airport</th>
              <th scope="col">Departure Date</th>
              <th scope="col">Seats for book</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${airResults}" var="result">
              <tr>
                <th scope="row">${result.id}</th>
                <th>${result.homeAirport}</th>
                <th>${result.destinationAirport}</th>ping
                <th>${result.flightDate}</th>
                <th>${result.passesngerDetails}</th>
                <th> <button type="button" class="btn btn-secondary btn-sm">book now</button></th>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>
<%@ include file="/topdown/footer.jsp"%>
