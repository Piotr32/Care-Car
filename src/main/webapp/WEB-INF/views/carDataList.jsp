<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 05.06.19
  Time: 11:58
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
        function confirmDelete(id, vehicleName) {
            if (confirm("Czy chcesz usunąć pojazd '" + vehicleName + "'?")) {
                window.location.href = "/carData/delete/" + id;
            }
        }
    </script>
</head>
<body>
<%@include file="header.jspf" %>

<div class="container">

    <header>Dane pojazdu</header>

    <div class="card">
        <div class="card-body">
            <a href="/carData/add" class="btn btn-primary">Dodaj pojazd</a>
            <a href="/carHistory/add" class="btn btn-primary">Dodaj wydarzenie</a>
            <a href="/carOrganizer/add" class="btn btn-primary">Planowane wydarzenia</a>
            <a href="/carRefueling/add" class="btn btn-primary">Dodaj tankowanie</a>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>Nazwa pojazdu</th>
                    <th>Marka</th>
                    <th>Model</th>
                    <th>Rodzaj paliwa</th>

                    <th style="width:17%">Akcja</th>
                </tr>
                <c:forEach items="${carData}" var="carData">
                    <tr>
                        <td>${carData.vehicleType}</td>
                        <td>${carData.vehicleName}</td>
                        <td>${carData.brand}</td>
                        <td>${carData.model}</td>
                        <td>${carData.fuelType}</td>
                        <td>
                            <a href="/carData/update/${carData.id}" class="btn btn-success">Edycja</a>
                            <a href="/carData/carDataPreview/${carData.id}" class="btn btn-success">Podgląd</a>
                            <a href="#" onclick="confirmDelete(${carData.id}, '${carData.vehicleName}' )" class="btn btn-danger">Usuń</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>

</div>

</body>
</html>
