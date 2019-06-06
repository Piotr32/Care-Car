<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 05.06.19
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <script>
        function confirmDelete(id, title) {
            if (confirm("Do you want to delete a car '" + title + "'?")) {
                window.location.href = "/car/delete/" + id;
            }
        }
    </script>
</head>
<body>

<div class="container">

    <header>Dane pojazdu</header>

    <div class="card">
        <div class="card-body">
            <a href="/carData/add" class="btn btn-primary">Dodaj pojazd</a>
            <a href="/carData/list" class="btn btn-primary">Lista pojazdów</a>
            <a href="/carHistory/add" class="btn btn-primary">Dodaj wydarzenie</a>
            <a href="/carRefueling/add" class="btn btn-primary">Dodaj tankowanie</a>
            <a href="/carRefueling/list" class="btn btn-primary">Lista tankowań</a>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>Wydarzenie</th>
                    <th>Data</th>
                    <th>Ile kilometrów zostało przejechane</th>
                    <th>Wydatki</th>

                    <th style="width:17%">Action</th>
                </tr>
                <c:forEach items="${carHistory}" var="carHistory">
                    <tr>
                        <td>${carHistory.event}</td>
                        <td>${carHistory.date}</td>
                        <td>${carHistory.howManyKmDriven}</td>
                        <td>${carHistory.expenses}</td>
                        <td>
                            <a href="/carHistory/update/${carHistory.id}" class="btn btn-success">Edycja</a>
                            <a href="#" onclick="confirmDelete(${carHistory.id})" class="btn btn-danger">Usuń</a>
                        </td>
                    </tr>
                </c:forEach>
                ${totalExpenses}
            </table>

        </div>
    </div>

</div>

</body>
</html>