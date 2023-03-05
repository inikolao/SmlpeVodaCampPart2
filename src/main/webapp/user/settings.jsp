<%--
  Created by IntelliJ IDEA.
  User: Ioannis
  Date: 2/28/2023
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/topdown/uheader.jsp"%>
<h1>settings</h1>
<%
    boolean fl=false;
    try {
        fl = (boolean) session.getAttribute("psc");
    } catch (Exception e) {

    }
    if(fl){
    out.print("<div class=\"alert alert-primary\" role=\"alert\">\n" +
            "  All done ok!\n" +
            "</div>\n");
}
session.setAttribute("psc",false);
%>
<h2>Change Password</h2>
<form action="../pchange" method="post">
    <div class="form-group">
        <label for="exampleInputPassword1">Enter New Password</label>
        <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<h2>Create Passenger</h2>
<form action="../create" method="post">
    <div class="form-group">
        <label>Name</label>
        <input type="text" class="form-control" name="pname" id="name" placeholder="Name">
    </div>
    <div class="form-group">
        <label>Surname</label>
        <input type="text" class="form-control" name="psurname" id="surname" placeholder="Surname">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<%@ include file="/topdown/footer.jsp"%>