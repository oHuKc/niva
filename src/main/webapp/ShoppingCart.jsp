<%@ page import="internetshop.niva.il.database.jdbc.GoodsDAOImpl" %>
<%@ page import="internetshop.niva.il.domain.Goods" %>
<%--
  Created by IntelliJ IDEA.
  User: voyager
  Date: 2015.10.30.
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShoppingCart</title>
</head>
<body>

<form>
  <link rel="stylesheet" type="text/css" href="styles/style.css">
<% GoodsDAOImpl goodsdaoimpl = new GoodsDAOImpl();
    Long longstr = 33L;
    Goods goods = goodsdaoimpl.getById(longstr);
%>
    <img src="images/cart.png"><h2>Shopping Cart</h2>
        <table border="2" style="width: 100%; height: auto" >
            <tr>
                <th><h3>Item Name</h3></th>
                <th><h3>Item Type</h3></th>
                <th><h3>Quantity</h3></th>
                <th><h3>Cost</h3></th>
                <th><h3>Action</h3></th>
            </tr>
        <form name="Cart" action="ShoppingCart.jsp" method="get">
            <input type="hidden" name="ProductId" value=""/>
            <input type="hidden" name="ProductPrice" value=""/>
            <tr>
                <td></td>
                <td></td>
                <td>
                    <input type="text" style=" background-color: #FF9f00" name="ProdQuantity" size="6"  value=""/>
                </td>
                <td></td>
                <td>
                    <input type="submit" name="action" value="Add" onclick=""/>
                    <input type="submit" name="action" value="Delete"/>
                </td>
            </tr>
        </form>
    </table>
    </form>
</body>
</html>
