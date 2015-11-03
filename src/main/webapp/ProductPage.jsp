<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%--
  Created by IntelliJ IDEA.
  User: voyager
  Date: 2015.10.30.
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <jsp:include page="ShoppingCart.jsp"></jsp:include>
    <title>ProductPage</title>
</head>
<body>
<%
  String connectionURL = "jdbc:mysql://localhost:3306/niva_testdb";

  Connection connection = null;
  Statement statement = null;
  ResultSet rs = null;
  Class.forName("com.mysql.jdbc.Driver").newInstance();

  connection = DriverManager.getConnection(connectionURL, "root", "root");
  statement = connection.createStatement();
  String  querystring = "select * from goods";
  rs = statement.executeQuery(querystring);
%>
<form name>
  <h2>Product List : </h2>
<table cellpadding="15" border="1" cellspacing="15">

<% try {
  while (rs.next()) {
   %>
  <tr>
    <td><%=rs.getInt(1)%></td>
    <td><%=rs.getString(2)%></td>
    <td><%=rs.getString(3)%></td>
    <td><%=rs.getString(4)%></td>
    <td><%=rs.getString(5)%></td>
  </tr>
  <% } %>
  <% } finally {
rs.close();
statement.close();
connection.close();
}
  %>
</table>
</form>
<h1><%=request.getAttribute("model")%></h1>
</body>
</html>
