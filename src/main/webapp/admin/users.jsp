<%@ page import="iniko.Voda.Services.DBServices.Crud.Repos.UserRepo" %>
<%@ page import="java.util.List" %>
<%@ page import="iniko.Voda.DAO.User" %><%--
  Created by IntelliJ IDEA.
  User: Ioannis
  Date: 2/24/2023
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/topdown/aheader.jsp"%>
<h1>User admin</h1>
<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Username</th>
        <th scope="col">Resistration Active From</th>
        <th scope="col">IsActive</th>
    </tr>
    </thead>
    <tbody>
<%
    UserRepo ur=new UserRepo();
    List<User> users=ur.GetAll();
    for (User x:users
         ) {
        out.print("<tr>");
        out.print("<th scope=\"row\">"+x.getId()+"</th>");
        out.print("<th>"+x.getUsername()+"</th>");
        out.print("<th>"+x.getResistrationActive()+"</th>");
        out.print("<th>"+x.isActive()+"</th>");
        out.print("<th> <button type=\"button\" class=\"btn btn-secondary btn-sm\">Delete</button></th>");


    }
%>
    </tbody>
</table>
<%@ include file="/topdown/footer.jsp"%>
