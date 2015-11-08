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
  String tvid = request.getParameter("screenID");

/*
  do {
  tvid =request.getParameter("4kid1");
    session.setAttribute("screenID", tvid);
  }
  while(tvid == null);
*/

  if(tvid == null) {
    tvid = request.getParameter("4kid1");
    session.setAttribute("screenID", tvid);
    if( tvid == null) {
      tvid = request.getParameter("4kid2");
      session.setAttribute("screenID", tvid);
      if( tvid == null) {
        tvid = request.getParameter("4kid3");
        session.setAttribute("screenID", tvid);
        if( tvid == null) {
          tvid = request.getParameter("4kid4");
          session.setAttribute("screenID", tvid);
          if( tvid == null) {
            tvid = request.getParameter("4kid5");
            session.setAttribute("screenID", tvid);
            if( tvid == null ) {
              tvid = request.getParameter("4kid6");
              session.setAttribute("screenID", tvid);
              if ( tvid == null ) {
               tvid = request.getParameter("4kid7");
                session.setAttribute("screenID", tvid);
                if (tvid == null) {
                  tvid = request.getParameter("4kid10");
                  session.setAttribute("screenID", tvid);
                  if ( tvid == null ) {
                    tvid = request.getParameter("4kid11");
                    session.setAttribute("screenID", tvid);
                    if ( tvid == null ) {
                      tvid = request.getParameter("4kid12");
                      session.setAttribute("screenID", tvid);
                      if (tvid == null ) {
                        tvid = request.getParameter("4kid13");
                        session.setAttribute("screenID", tvid);
                        if (tvid == null) {
                          tvid = request.getParameter("4kid14");
                          session.setAttribute("screenID", tvid);
                          if (tvid == null) {
                            tvid = request.getParameter("4kid15");
                            session.setAttribute("screenID", tvid);
                            if (tvid == null) {
                              tvid = request.getParameter("4kid16");
                              session.setAttribute("screenID", tvid);
                              if (tvid == null) {
                                tvid = request.getParameter("4kid17");
                                session.setAttribute("screenID", tvid);
                                if (tvid == null) {
                                  tvid = request.getParameter("4kid18");
                                  session.setAttribute("screenID", tvid);
                                  if (tvid == null) {
                                    tvid = request.getParameter("4kid19");
                                    session.setAttribute("screenID", tvid);
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }


%>
<!--<h1>Screen Size:<%=request.getParameter("4kid2")%></h1> -->
<%
if (session.getAttribute("screenID") != null ) { %>

<h2><%=session.getAttribute("parameter")%></h2>

  <c:forEach items='${tv.get4KUHD(screenID)}' var="tv">
    <h4><c:out  value="${tv.tvtype} ${tv.tvscreensize}  ${tv.tvebrand}  ${tv.tvdescription}  ${tv.tvprice}"/><!--<img src="images/cart.png">--></h4>
  </c:forEach>

<% } %>
<%--request.getSession(false).invalidate()
--%>
</body>
</html>