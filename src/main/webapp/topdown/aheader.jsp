<%--
  Created by IntelliJ IDEA.
  User: Ioannis
  Date: 2/24/2023
  Time: 1:55 PM
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
  <link rel="stylesheet" type="text/css" href="../css/search.css">
  <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="../css/fontAwesome.css">
  <link rel="stylesheet" href="../css/hero-slider.css">
  <link rel="stylesheet" href="../css/owl-carousel.css">
  <link rel="stylesheet" href="../css/datepicker.css">
  <link rel="stylesheet" href="../css/tooplate-style.css">

  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">

  <script src="../js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="../js/pageCh.js"></script>

</head>
<body>

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
                                href="dashboard.jsp">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="settings.jsp">settings</a>
        </li>
        <li class="nav-item"><a class="nav-link active" aria-current="page" href="statistics.jsp">Book A flight statistics</a>
        </li>
        <li class="nav-item"><a class="nav-link" href="users.jsp">UserDatabase</a>
        </li>
        <%
          String admin = (String) session.getAttribute("admin");
          if(admin != null) {
            out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"../index.jsp\"> CMS Home Page</a>");
          }

        %>
      </ul>
      <ul class="navbar-nav d-flex">
        <li class="nav-item"><a class="nav-link" href="../logout">Logout</a>
      </ul>
    </div>
  </div>
</nav>
