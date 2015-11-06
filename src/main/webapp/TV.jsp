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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>TV & Home Theater</title>
</head>
<body>
<h4>TV.jsp session Id:<%=session.getId()%></h4>
<h4>Menu.jsp session Id:<%=session.getAttribute("menusessionid")%></h4>
<%
if (session.getAttribute("parameter") != null ) { %>
<h2><%=session.getAttribute("parameter")%></h2>
  <c:forEach items="${tv.get4KUHD(1)}" var="tv">
    <h4><c:out value="${tv.tvtype} ${tv.tvscreensize}  ${tv.tvebrand}  ${tv.tvdescription}  ${tv.tvprice}"/></h4>
  </c:forEach>
<% } %>
<%--request.getSession(false).invalidate()
--%>
</body>
</html>