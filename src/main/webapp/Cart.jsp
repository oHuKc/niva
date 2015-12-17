<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="cart" scope="session" class="internetshop.niva.il.database.jdbc.CartDAOImpl"/>
<%--
  Created by IntelliJ IDEA.
  User: ilugovecs
  Date: 2015.11.11.
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title></title>
  <jsp:include page="Header.jsp"></jsp:include>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-sm-12 col-md-10 col-md-offset-1">
      <table class="table table-hover">
        <thead>
        <tr>
          <th>Product</th>
          <!--<th>Quantity</th> -->
          <th class="text-center">Price</th>
          <th class="text-center">Total</th>
          <th> </th>
        </tr>
        </thead>
        <tbody>
<%
  if (request.getAttribute("cartCount") == null ) { %>
    <h1>Cart is empty.</h1>
 <% } else {%>

        <c:forEach items='${cart.getAll()}' var = "cart">
        <tr>
          <td class="col-sm-8 col-md-6">
            <div class="media">
              <a class="thumbnail pull-left" href="#">
               <img class="media-object" src="images/cart_product.png"><p>
              </a>
              <div class="media-body">
                <h4 class="media-heading"><a href="#"><c:out value="${cart.productname}"/></a></h4>
                <h5 class="media-heading"> by <a href="#"><c:out value="${cart.productbrand}"/></a></h5>
                <span>Status: </span><span class="text-success"><strong><c:out value="${cart.productstatus}"/></strong></span>
              </div>
            </div></td>
          <!--
          <td class="col-sm-1 col-md-1" style="text-align: center">
            <input type="email" class="form-control" id="exampleInputEmail1" value="1">
          </td>
          -->
          <td class="col-sm-1 col-md-1 text-center"><strong><c:out value="$${cart.productprice}"/></strong></td>
          <td class="col-sm-1 col-md-1 text-center"><strong>???</strong></td>
          <td class="col-sm-1 col-md-1">
            <button type="button" class="btn btn-danger">
              <span class="glyphicon glyphicon-remove"></span> Remove
            </button></td>
        </tr>
        </c:forEach>
<%} %>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td><h5>Subtotal</h5></td>
          <td class="text-right"><h5><strong>???</strong></h5></td>
        </tr>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td><h5>Estimated shipping</h5></td>
          <td class="text-right"><h5><strong>???</strong></h5></td>
        </tr>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td><h3>Total</h3></td>
          <td class="text-right"><h3><strong>???</strong></h3></td>
        </tr>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td>
            <button type="button" class="btn btn-default">
              <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
            </button></td>
          <td>
            <button type="button" class="btn btn-success">
              Checkout <span class="glyphicon glyphicon-play"></span>
            </button></td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>
