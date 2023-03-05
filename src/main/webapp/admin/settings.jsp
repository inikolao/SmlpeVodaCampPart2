<%--
  Created by IntelliJ IDEA.
  User: Ioannis
  Date: 2/24/2023
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/topdown/aheader.jsp"%>
<h1>Admin Settings</h1>
<h2>Change Password</h2>
<form action="../pchange" method="post">
    <div class="form-group">
        <label for="exampleInputPassword1">Enter New Password</label>
        <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<%@ include file="/topdown/footer.jsp"%>
