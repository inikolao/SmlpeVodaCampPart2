<%@ page import="iniko.Voda.Services.DBServices.Crud.Repos.Impl.PlaceRepo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ioannis
  Date: 3/3/2023
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/topdown/header.jsp"%>
<h1>We serve places.</h1>
<div id="booking" class="section">
    <div class="section-center">
        <div class="container">
            <div class="row">
                <div class="booking-form">
                    <table class="table table-dark">
                        <thead class="thead-light">
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Book</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            PlaceRepo placesRepo=new PlaceRepo();
                            List<String> places=placesRepo.GetAll();
                            for (String x:places
                            ) {
                                out.print("<tr>");
                                out.print("<th>"+x+"</th>");
                                out.print("<th><form action=\"bookb\" method=\"post\" > <button type=\"submit\" value=\""+x+"\" name=\"flies\" class=\"btn btn-secondary btn-sm\" >Show me Flights</button></form></th></tr>");


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
