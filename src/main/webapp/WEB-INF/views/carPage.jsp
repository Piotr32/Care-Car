<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 05.06.19
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Page</title>
</head>
<body>
<div class="card-body">
    <a href="/users/logout" class="btn btn-primary">Wylogowanie</a>
</div>
<br>
<h1>Witaj!!! ${userSession.username}</h1>
<br>
<a href="/carData/list">Zarejestrowane pojazdy</a>
<br>
<a href="/carData/add">Zarejestruj pojazd</a>
</body>
</html>
