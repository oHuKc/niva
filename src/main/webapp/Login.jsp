<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <title>Registration Page</title>
    <jsp:include page="Header.jsp"></jsp:include>
</head>

<body>
<div id="header_div" class="container-fluid">
</div>
<div class="container-fluid" id="wrapper_div">

    <div id="content_div" class="col-lg-4 col-md-4 col-sm-4 col-xs-4">

        <form action="login" method="get">

            <div class="form-group">
                <input type="text" class="form-control" id="login" name="login" placeholder="Login" required>
            </div>

            <div class="form-group">
                <label for="InputEmail1">Email address</label>
                <input type="email" class="form-control" id="InputEmail1" placeholder="Enter email" name="InputEmail1">
            </div>

            <div class="form-group">
                <label for="inputName">Name</label>
                <input type="name" class="form-control" id="inputName" placeholder="Enter name" name="inputName">
            </div>
            <div class="form-group">
                <label for="inputSurname">Surname</label>
                <input type="surname" class="form-control" id="inputSurname" placeholder="Enter surname" name="inputSurname">

            </div>

            <div class="form-group">
                <label for="InputPassword1">Password</label>
                <input type="password" class="form-control" id="InputPassword1" placeholder="Password" name="InputPassword1">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword2">Repeat Password</label>
                <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Repeat password" name="exampleInputPassword2">
            </div>


            <button type="submit" class="btn btn-default">Submit</button>
        </form>

    </div>
</div>
</body>

</html>
