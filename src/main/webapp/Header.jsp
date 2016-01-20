<%@ page import="org.hibernate.Session" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="cart" scope="session" class="internetshop.niva.il.database.jdbc.CartDAOImpl"/>
<%--
  Created by IntelliJ IDEA.
  User: ilugovecs
  Date: 2015.11.10.
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Latest compiled and minified CSS-->
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<!--<link href="${pageContext.request.contextPath}/resources/css/shop-item.css" rel="stylesheet"> -->
<link href="${pageContext.request.contextPath}/resources/css/search.css" rel="stylesheet">

<link rel="stylesheet" href="styles/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="styles/styles.css" type="text/css"/>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Header</title>
</head>

<body>
<ul id="navigation">
  <li><a href="menu">Main Page</a></li>
  <li><a href="#">Credit Card</a></li>
  <li><a href="#">Gift Cards</a></li>
  <li><a href="#">Gift ideas</a></li>
  <li><a href="login">Registry</a></li>
  <li><a href="#">Order Status</a></li>
  <li><a href="welcome">
   <%
      if (session.getAttribute("loggedin") == null ) {%>
      Log in<%
  } else { %>
      Log Out <% } %>
  </a></li></a></li>
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
        <a href="cart" aria-label="Cart" title="Cart" data-lid="hdr_carticon">
          <div class="count-container" aria-hidden="true">
            <span class="hidden-text"></span>
           </div>
            <span class="header-icon-cart"><img src="images/cart.png"></span></a>
            <span class="badge" type="hidden">
             <!-- Cart State-->
             <c:forEach items='${cart.getAll()}' var = "cart" varStatus="count">
             <c:set var ="size" value="${count.count}"/>
             </c:forEach>
             <c:if test="${not empty size}">
             <c:out value="${size}"/>
             </c:if>
             <c:if test="${empty size}">0</c:if>
            </span></a>
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
