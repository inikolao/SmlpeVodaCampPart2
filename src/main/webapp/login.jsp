<%--
  Created by IntelliJ IDEA.
  User: Ioannis
  Date: 2/21/2023
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/topdown/header.jsp"%>

<div id="booking" class="section">
  <div class="section-center">
    <div class="container">
      <div class="row">
        <div class="booking-form">

<div class="container-xxl"><form action="login" method="post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form></div>
        </div>
      </div>
    </div>
  </div>
</div>

<%@ include file="/topdown/footer.jsp"%>
