<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login Page</title>
  <jsp:include page="Header.jsp"></jsp:include>
</head>
<body>
<div id="header_div" class="container-fluid">
</div>
<div class="container-fluid" id="wrapper_div">
  <div id="content_div" class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
    <form action="welcome" method="post">
      <div class="form-group">
        <label for="login">Login</label>
        <input type="text" class="form-control" id="login" name="login" placeholder="Login" required>
      </div>
      <div class="form-group">
        <label for="InputPassword1">Password</label>
        <input type="password" class="form-control" id="InputPassword1" placeholder="Password" name="InputPassword1">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
  </div>
</div>
</body>
</html>
