<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<jsp:useBean id="cart" scope="session" class="internetshop.niva.il.database.jdbc.CartDAOImpl"/>
<jsp:useBean id="tv" scope="session" class="internetshop.niva.il.database.jdbc.TVDAOImpl"/>
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
          <th class="text-center"></th>
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

    <c:set var="shipping" value="${0}"/>
    <c:set var="subtotal" value="${0}"/>
    <c:set var="total" value="${0}" />

        <c:forEach items='${cart.getAll()}' var = "cart" varStatus="status">
            <c:set var="ptotal" value ="${cart.productprice * 1.21}"/>
            <c:set var="shipping" value="${5.99}"/>
            <c:set var="subtotal" value="${subtotal + cart.productprice * 1.21}"/>
            <c:set var="total" value="${subtotal + shipping}"/>
            <c:set var="itemid" value="${cart.productid}"/>


            <tr>
          <td class="col-sm-8 col-md-6">
            <div class="media">
              <a class="thumbnail pull-left" href="#">
               <img class="media-object" src="images/cart_product.png"><p>
              </a>
              <div class="media-body">
                <h5 class="media-heading">Product ID: <a href="#">
                    <c:forEach items="${itemid}" var="id" varStatus="status">
                        <c:out value="${id}"/></a></h5>
                    </c:forEach>
                <h5 class="media-heading">Product name: <a href="#"><c:out value="${cart.productname}"/></a></h5>
                <h5 class="media-heading">Brand: <a href="#"><c:out value="${cart.productbrand}"/></a></h5>
                <h5 class="media-heading">Description: <a href="#"><c:out value="${cart.productdescription}"/></a></h5>
              </div>
            </div></td>

          <td class="col-sm-1 col-md-1" style="text-align: center">
            <!--<input type="email" class="form-control" id="exampleInputEmail1" value="1"> -->
          </td>

          <td class="col-sm-1 col-md-1 text-center"><strong><c:out value="$${cart.productprice}"/></strong></td>
          <td class="col-sm-1 col-md-1 text-center"><strong><c:out value="$${cart.productprice * 1.21}"/></strong></td>
          <td class="col-sm-1 col-md-1">
              <form id="CartRemove">
            <button type="button" class="btn btn-danger"  href="javascript:;" onclick="document.getElementById('CartRemove').submit();">
              <span class="glyphicon glyphicon-remove" type="submit"></span>Remove
                <input type="hidden" name="btnCartIDremove" value="${itemid}"/>
                <input type="hidden" name="btnCartState" value="<%session.getAttribute("cartCount");%>"/>
            </button>
              </form>
          </td>
        </tr>
        </c:forEach>
<%} %>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td><h5>Subtotal</h5></td>
          <td class="text-right"><h5><strong><c:out value="$${subtotal}"/></strong></h5></td>
        </tr>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td><h5>Estimated shipping</h5></td>
          <td class="text-right"><h5><strong><c:out value="$${shipping}"/></strong></h5></td>
        </tr>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td><h3>Total</h3></td>
          <td class="text-right"><h3><strong><c:out value="$${total}"/></strong></h3></td>
        </tr>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td>
            <button type="button" class="btn btn-default">
              <span class="glyphicon glyphicon-shopping-cart"></span>Continue Shopping
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
<!--%request.getSession(false).invalidate();%-->

</html>
