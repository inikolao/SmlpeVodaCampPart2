<%--
  Created by IntelliJ IDEA.
  User: Ioannis
  Date: 2/21/2023
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fly Away</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous">
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="css/search.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/fontAwesome.css">
    <link rel="stylesheet" href="css/hero-slider.css">
    <link rel="stylesheet" href="css/owl-carousel.css">
    <link rel="stylesheet" href="css/datepicker.css">
    <link rel="stylesheet" href="css/tooplate-style.css">

    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">

    <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/pageCh.js"></script>
</head>
<body>
<!-- conditional display of a second password field -->
    <%
                    //Remove '@'
                    if (!request.getRequestURI().equals("/FyAway_war_exploded/index.jsp"))
                    {
                %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Fly Away</a>
        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link"
                                         href="index.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="about.jsp">About</a>
                </li>
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="search.jsp">Book A flight</a>
                </li>
                <%
                    String admin = (String) session.getAttribute("admin");
                    String user=(String) session.getAttribute("user");
                    if(admin != null) {
                        out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"admin/dashboard.jsp\">Admin Dashboard</a>");
                    }
                    if(user != null) {
                        out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"user/home.jsp\">User Panel</a>");
                    }
                %>
            </ul>
            <ul class="navbar-nav d-flex">

                <%
                if ((admin==null)&&(user==null))
                {
                    out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"register.jsp\">Register</a>\n" +
                            "<li class=\"nav-item\"><a class=\"nav-link\" href=\"login.jsp\">LogIn</a>");
                }
                else
                {
                    out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"logout\">Logout</a>");
                }

                %>
            </ul>
        </div>
    </div>
</nav>
<%
    } %>