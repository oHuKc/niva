<%--
  Created by IntelliJ IDEA.
  User: voyager
  Date: 2015.11.03.
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="ShoppingCart.jsp"></jsp:include>
<jsp:useBean id="goods" scope="session" class="internetshop.niva.il.database.jdbc.GoodsDAOImpl"/>

<html>
<head>
    <title>SelectPage</title>
</head>
<body>
<form name="JSTL list">
    <h2>JSTL List:</h2>
<c:forEach items="${goods.all}" var="goods">
<h4><c:out value="${goods.goodsId}  ${goods.goodsName}  ${goods.goodsDesription}  ${goods.goodsPrice} ${goods.goodsType}"/>
    </br>
</h4>
    </c:forEach>
</form>
</body>
</html>
