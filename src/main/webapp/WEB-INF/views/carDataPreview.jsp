<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 05.06.19
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Data Preview</title>

    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="col-md-8 offset-4 justify-content-md-center">
                <div class="card col-md-8 text-center">
                    <div class="card-body">
                        <h5 class="card-title">${car.brand} ${car.model}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">${car.vehicleName}</h6>
                        <p class="card-text">${car.fuelType} </p>
                        <div class="container">
                            <div class="col-md-12">
                                <header class="header-panel">
                                    Historia pojazdu
                                </header>
                                <ul>
                                    <c:forEach items="${car.carHistory}" var="history">
                                        <li>${history.event} - ${history.date} (${history.notes})</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <div class="container">
                            <div class="col-md-12">
                                <header class="header-panel">
                                    Historia tankowania
                                </header>
                                <ul>
                                    <c:forEach items="${car.carRefueling}" var="refuel">
                                        <li>${refuel.date} - ${refuel.fuelType} (${refuel.howManyLiters} L)</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

</div>
</body>
</html>
