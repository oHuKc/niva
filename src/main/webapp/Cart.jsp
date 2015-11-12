<%--
  Created by IntelliJ IDEA.
  User: ilugovecs
  Date: 2015.11.11.
  Time: 16:51
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

<link rel="stylesheet" href="styles/bootstrap.min.css" >
<link rel="stylesheet" href="styles/styles.css" type="text/css"/>

<jsp:include page="Header.jsp"></jsp:include>

<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-sm-12 col-md-10 col-md-offset-1">
      <table class="table table-hover">
        <thead>
        <tr>
          <th>Product</th>
          <th>Quantity</th>
          <th class="text-center">Price</th>
          <th class="text-center">Total</th>
          <th> </th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td class="col-sm-8 col-md-6">
            <div class="media">
              <a class="thumbnail pull-left" href="#"> <img class="media-object" src="images/cart_product.png" > </a>
              <div class="media-body">
                <h4 class="media-heading"><a href="#">Product name</a></h4>
                <h5 class="media-heading"> by <a href="#">Brand name</a></h5>
                <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
              </div>
            </div></td>
          <td class="col-sm-1 col-md-1" style="text-align: center">
            <input type="email" class="form-control" id="exampleInputEmail1" value="3">
          </td>
          <td class="col-sm-1 col-md-1 text-center"><strong>$4.87</strong></td>
          <td class="col-sm-1 col-md-1 text-center"><strong>$14.61</strong></td>
          <td class="col-sm-1 col-md-1">
            <button type="button" class="btn btn-danger">
              <span class="glyphicon glyphicon-remove"></span> Remove
            </button></td>
        </tr>
        <tr>
          <td class="col-md-6">
            <div class="media">
              <a class="thumbnail pull-left" href="#"> <img class="media-object" src="images/cart_product.png" > </a>
              <div class="media-body">
                <h4 class="media-heading"><a href="#">Product name</a></h4>
                <h5 class="media-heading"> by <a href="#">Brand name</a></h5>
                <span>Status: </span><span class="text-warning"><strong>Leaves warehouse in 2 - 3 weeks</strong></span>
              </div>
            </div></td>
          <td class="col-md-1" style="text-align: center">
            <input type="email" class="form-control" id="exampleInputEmail2" value="2">
          </td>
          <td class="col-md-1 text-center"><strong>$4.99</strong></td>
          <td class="col-md-1 text-center"><strong>$9.98</strong></td>
          <td class="col-md-1">
            <button type="button" class="btn btn-danger">
              <span class="glyphicon glyphicon-remove"></span> Remove
            </button></td>
        </tr>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td><h5>Subtotal</h5></td>
          <td class="text-right"><h5><strong>$24.59</strong></h5></td>
        </tr>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td><h5>Estimated shipping</h5></td>
          <td class="text-right"><h5><strong>$6.94</strong></h5></td>
        </tr>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td><h3>Total</h3></td>
          <td class="text-right"><h3><strong>$31.53</strong></h3></td>
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
