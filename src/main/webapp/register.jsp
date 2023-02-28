<%--
  Created by IntelliJ IDEA.
  User: Ioannis
  Date: 2/28/2023
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/topdown/header.jsp"%>
<div id="booking" class="section">
  <div class="section-center">
    <div class="container">
      <div class="row">
        <div class="booking-form">
          <form action="register" method="post">
            <div class="row">
              <div class="col-md-6">
                <div class="form-group">
                  <span class="form-label">Username</span>
                  <input class="form-control" name="username" type="text" placeholder="Username" required>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <span class="form-label">Password</span>
                  <input class="form-control" name="password" type="password" placeholder="Password" required>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-3">
                <div class="form-group">
                  <span class="form-label">Addresss</span>
                  <input class="form-control"name="address" type="text" placeholder="Addresss" required>
                </div>
              </div>
              <div class="col-md-3">
                <div class="form-group">
                  <span class="form-label">Phone</span>
                  <input class="form-control" type="tel" name="phone" placeholder="+30-Phone" required>
                </div>
              </div>
              <div class="col-md-2">
                <div class="form-group">
                  <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="1" id="flexCheckDefault">
                    <label class="form-check-label" for="flexCheckDefault">
                      Adult(18+)
                    </label>
                  </div>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-3">
                <div class="form-btn">
                  <button class="submit-btn">Register</button>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<%@ include file="/topdown/footer.jsp"%>