<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="cart" scope="session" class="internetshop.niva.il.database.jdbc.CartDAOImpl"/>
<html>
<head>
    <title>Order Status</title>
    <jsp:include page="Header.jsp"></jsp:include>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span2">
            <!--Sidebar content-->
           <!-- <h5><%=request.getAttribute("crecords")%></h5> -->
<c:forEach items='${cart.getAll()}' var = "cart" varStatus="status">
<h5><c:out value="${cart.productid} ${cart.productname} ${cart.productbrand} ${cart.productdescription}"/></h5>
</c:forEach>
        </div>
        <div class="span10">
            <center><h5>Welcome</h5></center>
        </div>
    </div>
</div>
</body>
</html>
