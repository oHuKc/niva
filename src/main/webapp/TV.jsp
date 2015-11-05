<%--
  Created by IntelliJ IDEA.
  User: ilugovecs
  Date: 2015.11.05.
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<jsp:useBean id="tv" scope="session" class="internetshop.niva.il.database.jdbc.TVDAOImpl"/>
<%@ page import="internetshop.niva.il.domain.TV" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="internetshop.niva.il.database.jdbc.TVDAOImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>TV & Home Theater</title>
</head>
<body>

<form name="TV List" action="get">
  <h2>TV & HomeTheater :</h2>
  <c:forEach items="${tv.all}" var="tv">
    <h4><c:out value="${tv.tvtype}  ${tv.tvscreensize}   ${tv.tvebrand}  ${tv.tvdescription}  ${tv.tvprice}"/></h4>
  </c:forEach>
</form>


</body>
</html>