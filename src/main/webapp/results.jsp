<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ioannis
  Date: 2/24/2023
  Time: 5:00 PM
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
                            <th scope="col">Airliner</th>
                            <th scope="col">Seats for book</th>
                            <th scope="col">Price</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${Results1}" var="result">
                            <tr>
                                <th scope="row" >${result.id}</th>
                                <th>${result.homeAirport}</th>
                                <th>${result.destinationAirport}</th>ping
                                <th>${result.flightDate}</th>
                                <th>${result.airliner.name}</th>
                                <th>${result.passesngerDetails}</th>
                                <th>${result.price}</th>
                                <th> <form action="book" method="post"><button name="value" value="${result.id}" type="submit" class="btn btn-secondary btn-sm">book now</button></form></th>
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
