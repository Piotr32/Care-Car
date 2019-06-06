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
        function confirmDelete(id, total) {
            if (confirm("Chcesz usunąć tankowanie o wartości '" + total + "'?")) {
                window.location.href = "/carRefueling/delete/" + id;
            }
        }
    </script>
</head>
<body>

<div class="container">

    <header>Lista tankowań</header>

    <div class="card">
        <div class="card-body">
            <a href="/carData/add" class="btn btn-primary">Dodaj pojazd</a>
            <a href="/carData/list" class="btn btn-primary">Lista pojazdów</a>
            <a href="/carHistory/add" class="btn btn-primary">Dodaj wydarzenie</a>
            <a href="/carHistory/list" class="btn btn-primary">Lista wydarzeń</a>
            <a href="/carOrganizer/add" class="btn btn-primary">Planowane wydarzenia</a>
            <a href="/carOrganizer/list"class="btn btn-primary">Lista planowanych wydarzeń</a>
            <a href="/carRefueling/add" class="btn btn-primary">Dodaj tankowanie</a>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>Data</th>
                    <th>Ile litrów zatankowano</th>
                    <th>Rodzaj paliwa</th>
                    <th>Kwota</th>

                    <th style="width:17%">Akcja</th>
                </tr>
                <c:forEach items="${carRefueling}" var="carRefueling">
                    <tr>
                        <td>${carRefueling.date}</td>
                        <td>${carRefueling.howManyLiters}</td>
                        <td>${carRefueling.fuelType}</td>
                        <td>${carRefueling.total}</td>
                        <td>
                            <a href="/carRefueling/update/${carRefueling.id}" class="btn btn-success">Edycja</a>
                            <a href="#" onclick="confirmDelete(${carRefueling.id}, '${carRefueling.total}')" class="btn btn-danger">Usuń</a>
                        </td>
                    </tr>
                </c:forEach>
                <a>Razem</a> ${totalCost}</a>
            </table>

        </div>
    </div>

</div>

</body>
</html>
