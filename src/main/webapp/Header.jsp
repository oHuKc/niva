<%--
  Created by IntelliJ IDEA.
  User: ilugovecs
  Date: 2015.11.10.
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Latest compiled and minified CSS-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
      integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
      crossorigin="anonymous">
<!-- Optional theme-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"
      integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"
        integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ=="
        crossorigin="anonymous"></script>

<link rel="stylesheet" href="styles/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="styles/styles.css" type="text/css"/>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Header</title>
</head>

<body>
<ul id="navigation">
  <li><a href="#">Weekly Ad</a></li>
  <li><a href="#">Credit Card</a></li>
  <li><a href="#">Gift Cards</a></li>
  <li><a href="#">Gift ideas</a></li>
  <li><a href="#">Registry</a></li>
  <li><a href="#">Order Status</a></li>
</ul>
<nav class="navbar navbar-default">
<div class="container-fluid">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
      <span class="sr-only"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#"></a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
    </ul>

    <form class="navbar-form navbar-left" role="search">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" aria-describedby="search-btn">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
    <ul class="nav navbar-nav navbar-right">
        <div class="cart-wrap">
        <a href="http://localhost:8080/java2/Cart.jsp" aria-label="Cart" title="Cart" data-lid="hdr_carticon">
          <div class="count-container" aria-hidden="true">
            <span class="hidden-text"></span>
          </div>
          <span class="header-icon-cart"><img src="images/cart.png"></span></a>
          <span class="badge" type="hidden">1</span></a>
      </div>
    </ul>
  </div><!-- /.navbar-collapse -->
</div><!-- /.container-fluid -->
</nav>
</body>

<footer class="footer navbar-fixed-bottom">
  <div class="container">
  </div>
</footer>

</html>
