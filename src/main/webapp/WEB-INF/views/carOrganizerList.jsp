<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 06.06.19
  Time: 22:55
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
        function confirmDelete(id, event) {
            if (confirm("Czy chcesz usunąć wydarzenie " + event + "'?")) {
                window.location.href = "/carOrganizer/delete/" + id;
            }
        }
    </script>
</head>
<body>

<div class="container">

    <header>Lista planowanych wydatków</header>

    <div class="card">
        <div class="card-body">
            <a href="/carData/add" class="btn btn-primary">Dodaj pojazd</a>
            <a href="/carData/list" class="btn btn-primary">Lista pojazdów</a>
            <a href="/carHistory/add" class="btn btn-primary">Dodaj wydarzenie</a>
            <a href="/carRefueling/add" class="btn btn-primary">Dodaj tankowanie</a>
            <a href="/carOrganizer/add" class="btn btn-primary">Planowane wydarzenia</a>
            <a href="/carRefueling/list" class="btn btn-primary">Lista tankowań</a>
        </div>
    </div>
    <div>Data kolejnego wydarzenia = ${date.date}, wydarzenie= ${date.event}</div>
    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>Wydarzenie</th>
                    <th>Data</th>
                    <th>Ile kilometrów zostało przejechane</th>
                    <th>Wydatki</th>

                    <th style="width:17%">Akcja</th>
                </tr>
                <c:forEach items="${carOrganizer}" var="carOrganizer">
                    <tr>
                        <td>${carOrganizer.event}</td>
                        <td>${carOrganizer.date}</td>
                        <td>${carOrganizer.expenses}</td>
                        <td>
                            <a href="/carOrganizer/update/${carOrganizer.id}" class="btn btn-success">Edycja</a>
                            <a href="#" onclick="confirmDelete(${carOrganizer.id}, '${carOrganizer.event}')" class="btn btn-danger">Usuń</a>
                        </td>

                    </tr>

                </c:forEach>
                <a>Razem przyszłe koszty: </a> ${totalExpenses}
            </table>

        </div>
    </div>

</div>

</body>
</html>

