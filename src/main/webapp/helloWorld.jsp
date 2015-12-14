<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="cart" scope="session" class="internetshop.niva.il.database.jdbc.CartDAOImpl"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles/style.css">
    <title>JSP page</title>
</head>
<body>

<!--Image -->
<%request.setAttribute("model",1);%>
<h1>TV Image ID :<%=request.getAttribute("model")%> </h1>
<img src ="image?imgID=<%=request.getAttribute("model")%>" width="115" border="0">

<!--Cart-->
<h1>Product ID:<%=request.getAttribute("prodID")%></h1>
<h1>Product Name:<%=request.getAttribute("prodName")%></h1>
<h1>Product Brand:<%=request.getAttribute("prodBrand")%></h1>
<h1>Product Description:<%=request.getAttribute("prodDescripton")%></h1>
<h1>Product Status:<%=request.getAttribute("status")%></h1>
<h1>Product Price:<%=request.getAttribute("prodPrice")%></h1>

<!--4KUHD -->
<h2>4K Ultra High ID:<%=request.getAttribute("4kid1")%></h2>
<h2>4K Ultra High ID:<%=request.getAttribute("4kid2")%></h2>


<!--Cart List-->
<h1>Cart list:<%=request.getAttribute("cartlist")%></h1>

<c:forEach items='${cart.getAll()}' var="cart">
<h2><c:out value="${cart.productbrand} ${cart.productname} ${cart.productdescription} $${cart.productprice}"/></h2>
</c:forEach>


</body>
</html>
