<%--
  Created by IntelliJ IDEA.
  User: Ioannis
  Date: 2/21/2023
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/topdown/header.jsp"%>
<div id="booking" class="section">
    <div class="section-center">
        <div class="container">
            <div class="row">
                <div class="booking-form">
                    <form>
                        <div class="form-group">
                            <div class="form-checkbox">
                                <label for="roundtrip">
                                    <input type="radio" id="roundtrip" name="flight-type">
                                    <span></span>Roundtrip
                                </label>
                                <label for="one-way">
                                    <input type="radio" id="one-way" name="flight-type">
                                    <span></span>One way
                                </label>
                                <label for="multi-city">
                                    <input type="radio" id="multi-city" name="flight-type">
                                    <span></span>Multi-City
                                </label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <span class="form-label">Flying from</span>
                                    <input class="form-control" type="text" placeholder="City or airport">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <span class="form-label">Flyning to</span>
                                    <input class="form-control" type="text" placeholder="City or airport">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <div class="form-group">
                                    <span class="form-label">Departing</span>
                                    <input class="form-control" type="date" required>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <span class="form-label">Returning</span>
                                    <input class="form-control" type="date" required>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <span class="form-label">Adults (18+)</span>
                                    <select class="form-control">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                    </select>
                                    <span class="select-arrow"></span>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <span class="form-label">Children (0-17)</span>
                                    <select class="form-control">
                                        <option>0</option>
                                        <option>1</option>
                                        <option>2</option>
                                    </select>
                                    <span class="select-arrow"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <div class="form-group">
                                    <span class="form-label">Travel class</span>
                                    <select class="form-control">
                                        <option>Economy class</option>
                                        <option>Business class</option>
                                        <option>First class</option>
                                    </select>
                                    <span class="select-arrow"></span>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-btn">
                                    <button class="submit-btn">Show flights</button>
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
