<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 05.06.19
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Refueling</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <header>Dodaj tankowanie</header>
    <div class="card">
        <div class="card-body">
            <a href="/carRefueling/list" class="btn btn-primary">Wyjdź</a>
        </div>
    </div>
    <div class="card mt-4">


        <div class="card-body">
<form:form method="post" modelAttribute="carRefueling">
    <div class="row">
        <div class="form-group col-md-4">
    <label for="dateId">Data:</label>
    <form:input type="date" rows="3" cols="20" path="date" id="dateId"/>
    <form:errors path="date" element="div"/>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-4">
    <label for="howManyLitersId">Ile litrów zatankowano:</label>
    <form:input type="text" path="howManyLiters" id="howManyLitersId"/>
    <form:errors path="howManyLiters" element="div"/>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-4">
    <label for="fuelTypeId">Rodzaj paliwa:</label>
    <form:select path="fuelType" items="${fuelType}" id="fuelTypeId"/>
    <form:errors path="fuelType" element="div"/>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-4">
    <label for="totalId">Kwota:</label>
    <form:input type="double" path="total" id="totalId"/>
    <form:errors path="total" element="div"/>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-4">
    <label for="carSelectvehicleName">Pojazd</label>
    <form:select path="carData.id" items="${carDataList}" itemLabel="vehicleName" itemValue="id" id="carSelectvehicleName"/>
    <form:errors path="carData" element="div"/>
        </div>
    </div>

    <input type="submit" class="btn btn-primary" value="Zapisz">


</form:form>
</body>
</html>
