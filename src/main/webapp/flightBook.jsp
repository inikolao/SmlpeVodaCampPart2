<%@ page import="java.net.http.HttpClient" %>
<%@ page import="iniko.Voda.Services.DBServices.Crud.Repos.Impl.UserRepo" %>
<%@ page import="iniko.Voda.DAO.User" %>
<%@ page import="java.util.Objects" %>
<%@ page import="iniko.Voda.Services.DBServices.Crud.Repos.TicketsRepository" %>
<%@ page import="iniko.Voda.Services.DBServices.Crud.Repos.Impl.TicketRepo" %>
<%@ page import="iniko.Voda.DAO.Ticket" %>
<%@ page import="iniko.Voda.Services.DBServices.Crud.Repos.Impl.PassengerRepo" %>
<%@ page import="iniko.Voda.DAO.Passenger" %>
<%@ page import="iniko.Voda.DAO.Flight" %>
<%@ page import="iniko.Voda.Services.DBServices.Crud.Repos.Impl.FlightRepo" %><%--
  Created by IntelliJ IDEA.
  User: Ioannis
  Date: 3/5/2023
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/topdown/header.jsp"%>
<%
   String flightid= request.getParameter("value").toString();


   if (flightid==null)
   {
       response.sendRedirect("searh.jsp");
   }
   out.print("<h1> Book for flight :"+flightid+"</h1>");
%>
<div id="booking" class="section">
    <div class="section-center">
        <div class="container">
            <div class="row">
                <div class="booking-form">
<%

    String userflag= null;
    try {
        userflag=session.getAttribute("user_id").toString();
    }catch (Exception e)
    {

    }


    if(userflag!=null)//logged in
    {
        System.out.println("log in : Yes");
        UserRepo repo=new UserRepo();
        User userf=repo.FindUserByID(Integer.parseInt(userflag));
        if(userf.isPassenger())
        {
            PassengerRepo passengerRepo=new PassengerRepo();
            FlightRepo flightRepo=new FlightRepo();
            Flight flight=flightRepo.GetFlightById(Integer.parseInt(flightid));
            Passenger passenger=passengerRepo.FindUserByID(Integer.parseInt(userflag));
            //ticket creation
            Ticket ticket=new Ticket();
            ticket.setPassenger(passenger);
            ticket.setFlight(flight);
            ticket.setPrice(flight.getPrice());
            ticket.setDateIssued();
            ticket.setSeat();
            ticket.setValid(true);
            session.setAttribute("ticket",ticket);

            out.print(" <form action=\"book\" method=\"post\">\n" +
                    "            <div class=\"row\">\n" +
                    "              <div class=\"col-md-6\">\n" +
                    "                <div class=\"form-group\">\n" +
                    "                  <span class=\"form-label\">Payment Card ID</span>\n" +
                    "                  <input class=\"form-control\" name=\"cardID\" type=\"text\" placeholder=\"Card ID\" required>\n" +
                    "                </div>\n" +
                    "              </div>\n" +
                    "              <div class=\"col-md-6\">\n" +
                    "                <div class=\"form-group\">\n" +
                    "                  <span class=\"form-label\">Owner</span>\n" +
                    "                  <input class=\"form-control\" name=\"owner\" type=\"text\" placeholder=\"Owner\" required>\n" +
                    "                </div>\n" +
                    "              </div>\n" +
                    "            </div>\n" +
                    "            <div class=\"row\">\n" +
                    "              <div class=\"col-md-3\">\n" +
                    "                <div class=\"form-group\">\n" +
                    "                  <span class=\"form-label\">CVS</span>\n" +
                    "                  <input class=\"form-control\"name=\"cvv\" type=\"text\" placeholder=\"CVV\" required>\n" +
                    "                </div>\n" +
                    "              </div>\n" +
                    "              <div class=\"col-md-3\">\n" +
                    "                <div class=\"form-group\">\n" +
                    "                 <span class=\"form-label\">Card Type</span>\n" +
                    "                                    <select name=\"cardType\" class=\"form-control\">\n" +
                    "                                        <option value=\"1\">Visa</option>\n" +
                    "                                        <option value=\"2\">Master Card</option>\n" +
                    "                                    </select>\n" +
                    "                                    <span class=\"select-arrow\"></span>" +
                    "                </div>\n" +
                    "              </div>\n" +
                    "            </div>\n" +
                    "            <div class=\"row\">\n" +
                    "              <div class=\"col-md-3\">\n" +
                    "                <div class=\"form-btn\">\n" +
                    "                  <button class=\"submit-btn\">BOOK!</button>\n" +
                    "                </div>\n" +
                    "              </div>\n" +
                    "            </div>\n" +
                    "          </form>");
                    out.print("<div  class=\"row\"><form action\"user/flights.jsp\" method=\"get\" ><button class=\"submit-btn\">MyFlights</button></form></div>");

                    //response.sendRedirect("user/flights.jsp");
            //ticketRepo.save(ticket);
        }
        else
        {
            out.print("<div class=\"alert alert-primary\" role=\"alert\">\n" +
                    "  Book can not complete as you have not create Passenger details\n" +
                    "</div>\n");
        }

    }
    else {
        out.print("<div class=\"alert alert-primary\" role=\"alert\">\n" +
                "  Book can not complete as you have not logged in.\n" +
                "</div>\n");
    }
%>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/topdown/footer.jsp"%>
