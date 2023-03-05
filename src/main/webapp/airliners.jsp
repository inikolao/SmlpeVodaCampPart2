<%@ page import="iniko.Voda.Services.DBServices.Crud.Repos.Impl.AirlinerRepo" %>
<%@ page import="iniko.Voda.DAO.Airliner" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ioannis
  Date: 3/3/2023
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/topdown/header.jsp"%>
<h1>Airline List</h1>
<div id="booking" class="section">
    <div class="section-center">
        <div class="container">
            <div class="row">
                <div class="booking-form">
                    <table class="table table-dark">
                        <thead class="thead-light">
                        <tr>
                            <th scope="col">Airline #</th>
                            <th scope="col">Name</th>
                            <th scope="col">Rating</th>
                            <th scope="col">Book</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            AirlinerRepo airlinerRepo=new AirlinerRepo();
                            List<Airliner> airliners=airlinerRepo.GetAll();
                            for (Airliner x:airliners
                            ) {
                                out.print("<tr>");
                                out.print("<th scope=\"row\">"+x.getId()+"</th>");
                                out.print("<th>"+x.getName()+"</th>");
                                out.print("<th><div class=\"progress\">\n" +
                                        "<div class=\"progress-bar bg-success\" role=\"progressbar\" style=\"width: "+String.valueOf(x.getEvaluation())+"%\" aria-valuenow=\""+String.valueOf(x.getEvaluation())+"\" aria-valuemin=\"0\" aria-valuemax=\"100\"></div>\n" +
                                        "</div></th>");
                                out.print("<th><form action=\"booka\" method=\"post\"> <button type=\"submit\" name=\"valueair\" value=\""+x.getId()+"\" class=\"btn btn-secondary btn-sm\" >Book With</button></th></form></tr>");


                            }
                        %>
                        </tbody>
                    </table>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#">Next</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/topdown/footer.jsp"%>