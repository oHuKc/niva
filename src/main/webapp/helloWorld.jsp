<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles/style.css">
    <title>JSP page</title>
</head>
<body>

<!--Image -->
<%request.setAttribute("model",7);%>
<h1>TV Image ID :<%=request.getAttribute("model")%> </h1>
<img src ="image?imgID=<%=request.getAttribute("model")%>" width="115" border="0">


<%request.setAttribute("image",3);%>
<h1>TV Image ID 2 :<%=request.getAttribute("image")%> </h1>
<img src ="image?image=<%=request.getAttribute("image")%>" width="115" border="0">
<!--Cart-->
<h1>Product ID:<%=request.getAttribute("prodID")%></h1>
<h1>Product Name:<%=request.getAttribute("prodName")%></h1>
<h1>Product Brand:<%=request.getAttribute("prodBrand")%></h1>
<h1>Product Description:<%=request.getAttribute("prodDescripton")%></h1>
<h1>Product Status:<%=request.getAttribute("status")%></h1>
<h1>Product Price:<%=request.getAttribute("prodPrice")%></h1>
</body>
</html>
