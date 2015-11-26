<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles/style.css">
    <title>JSP page</title>
</head>
<body>
<%request.setAttribute("modelDB",11);%>
<h1>TV Image ID :<%=request.getAttribute("modelDB")%> </h1>
<%request.setAttribute("model",22);%>
<h1>TV Image ID :<%=request.getAttribute("model")%> </h1>
<img src ="image?imgID=<%=request.getAttribute("model")%>" width="115" border="0" >
<img src ="image?imgID=<%=request.getAttribute("modelDB")%>" width="115" border="0" >
</body>
</html>
