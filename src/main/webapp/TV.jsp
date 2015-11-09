<%@ page import="java.util.HashMap" %>
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
  HashMap<Integer, String> hmp = new HashMap<Integer, String>();

  hmp.put(1, "4kid1");hmp.put(2, "4kid2");hmp.put(3, "4kid3");hmp.put(4, "4kid4");hmp.put(5, "4kid5");hmp.put(6, "4kid6");
  hmp.put(7, "4kid7");hmp.put(10, "4kid10");hmp.put(11, "4kid11");hmp.put(12, "4kid12");hmp.put(13, "4kid13");
  hmp.put(14, "4kid14");hmp.put(15, "4kid15");hmp.put(16, "4kid16");hmp.put(17, "4kid17");hmp.put(18, "4kid18");
  hmp.put(19, "4kid19");

  hmp.put(99, "4kid99");

String tvid = request.getParameter("screenID");

if(tvid == null) {
  int i = 1;
    do {
      for ( i = 1; i <= 99 ; i++ ) {
        tvid = request.getParameter(String.valueOf(hmp.get(i)));
        if(tvid != null) {
        session.setAttribute("screenID", tvid);
          //System.out.print("Selected screen size id :" + tvid +"\n");
          //System.out.print("Hash Map:" + hmp.get(i)+"\n");
         // System.out.print("Session getAttribute :"+session.getAttribute("screenID")+"\n");
            }
          }
      } while (request.getParameter(String.valueOf(hmp.get(i))) != hmp.get(i) && request.getParameter(String.valueOf(hmp.get(i))) != null);
}
  if (session.getAttribute("screenID") != null ) { %>

<h2><%=session.getAttribute("parameter")%></h2>

<!--Retrieve only selected TV products by screen size :-->
<c:forEach items='${tv.get4KUHD(screenID)}' var="tv">
    <h4><c:out  value="${tv.tvtype} ${tv.tvscreensize}  ${tv.tvebrand}  ${tv.tvdescription}  ${tv.tvprice}"/><!--<img src="images/cart.png">--></h4>
</c:forEach>

<% }

  if ( request.getParameter("4kid99") != null && session.getAttribute("parameter") != null) { %>

<!--Retrieve all TV  products on a page :-->
<c:forEach items = '${tv.getAll()}' var = "tv" >
  <h4 ><c:out value ="${tv.tvtype} ${tv.tvscreensize}  ${tv.tvebrand}  ${tv.tvdescription}  ${tv.tvprice}"/></h4>
</c:forEach >

<% } %>
<%--request.getSession(false).invalidate()--%>
</body>
</html>