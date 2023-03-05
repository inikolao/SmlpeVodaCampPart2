<%@ page import="iniko.Voda.Services.DBServices.Crud.Repos.Impl.TicketRepo" %>
<%@ page import="iniko.Voda.DAO.Ticket" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ioannis
  Date: 2/28/2023
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/topdown/uheader.jsp"%>
<h1>My flights </h1>
<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">Ticket ID:</th>
        <th scope="col">Flight ID</th>
        <th scope="col">Departing</th>
        <th scope="col">Destination</th>
        <th scope="col">Date</th>
        <th scope="col">Seat</th>
    </tr>
    </thead>
    <tbody>
    <%
        TicketRepo tr=new TicketRepo();
        List<Ticket> tickets=tr.GetAll();
        for (Ticket x:tickets
        ) {
            out.print("<tr>");
            out.print("<th scope=\"row\">"+x.getId()+"</th>");
            out.print("<th>"+x.getFlight().getId()+"</th>");
            out.print("<th>"+x.getFlight().getHomeAirport()+"</th>");
            out.print("<th>"+x.getFlight().getDestinationAirport()+"</th>");
            out.print("<th>"+x.getFlight().getFlightDate()+"</th>");
            out.print("<th>"+x.getSeat()+"</th>");
        }
    %>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">Previous</a>
        </li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item">
            <a class="page-link" href="#">Next</a>
        </li>
    </ul>
</nav>
<%@ include file="/topdown/footer.jsp"%>
