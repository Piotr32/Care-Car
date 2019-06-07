<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 04.06.19
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Data</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
    <div class="container">
    <header>Zarejestruj pojazd</header>
    <div class="card">
        <div class="card-body">
            <a href="/carData/list" class="btn btn-primary">Wyjdź</a>
        </div>
    </div>
    <div class="card mt-4">


        <div class="card-body">

<form:form method="post" modelAttribute="carData">

    <div class="row">
    <div class="form-group col-md-4">
    <label for="vehicleTypeId">Typ pojazdu:</label>
    <form:select items="${vehicleType}" path="vehicleType" id="vehicleTypeId"/>
    <form:errors path="vehicleType" element="div"/>
    </div>
        <div class="form-group col-md-8">
            <label for="fuelTypeId">Rodzaj paliwa:</label>
            <form:checkboxes items="${fuelType}" path="fuelType" id="fuelTypeId"/>
            <form:errors path="fuelType" element="div"/>
        </div>
    </div>
    <div class="row">
    <div class="form-group col-md-4">
    <label for="vehicleNameId">Nazwa pojazdu:</label>
    <form:input type="text" path="vehicleName" id="vehicleNameId"/>
    <form:errors path="vehicleName" element="div"/>
    </div>
    <div class="form-group col-md-4">
    <label for="brandId">Marka:</label>
    <form:input type="text" path="brand" id="brandId"/>
    <form:errors path="brand" element="div"/>
    </div>
    <div class="form-group col-md-4">
        <label for="modelId">Model:</label>
        <form:input type="text" path="model" id="modelId"/>
        <form:errors path="model" element="div"/>
    </div>
    </div>

    <div class="row">
    <div class="form-group col-md-7">
    <label for="vinNoId">Numer VIN:</label>
    <form:textarea rows="1" cols="40" path="vinNo" id="vinNoId"/>
    <form:errors path="vinNo" element="div"/>
    </div>
    <div class="form-group col-md-5">
    <label for="oilTankCapacityId">Pojemność silnika:</label>
    <form:textarea rows="1" cols="20" path="oilTankCapacity" id="oilTankCapacityId"/>
    <form:errors path="oilTankCapacity" element="div"/>
    </div>
    </div>
    <div class="row">
        <div class="form-group col-md-12">
         <label for="typesOfOilId">Rodzaj oleju silnikowego</label>
          <form:select path="typesOfOil" items="${typesOfOil}" id="typesOfOilId"/>
          <form:errors path="typesOfOil" element="div"/>
         </div>
    </div>
        <div class="row">
            <div class="form-group col-md-6">
    <div><h3>Dane zakupu:</h3> </div>
            </div>
            <div class="form-group col-md-6">
                <div><h3>Dane sprzedaży:</h3> </div>
            </div>
        </div>
    <div class="row">
        <div class="form-group col-md-6">
    <label for="datePurchaseId">Data zakupu:</label>
    <form:input type="date" rows="3" cols="20" path="datePurchase" id="datePurchaseId"/>
    <form:errors path="datePurchase" element="div"/>
        </div>
        <div class="form-group col-md-6">
            <label for="dateSaleId">Data Sprzedaży:</label>
            <form:input type="date" rows="3" cols="20" path="dateSale" id="dateSaleId"/>
            <form:errors path="dateSale" element="div"/>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-6">
    <label for="meterStatusPurchaseId">Stan licznika:</label>
    <form:input type="number" path="meterStatusPurchase" id="meterStatusPurchaseId"/>
    <form:errors path="meterStatusPurchase" element="div"/>
        </div>
        <div class="form-group col-md-4">
            <label for="meterStatusSaleId">Stan licznika:</label>
            <form:input type="number" path="meterStatusSale" id="meterStatusIdSale"/>
            <form:errors path="meterStatusSale" element="div"/>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-6">
    <label for="howMuchWasItPurchaseId">Ile kosztował pojazd:</label>
    <form:input type="text" path="howMuchWasItPurchase" id="howMuchWasItIdPurchase"/>
    <form:errors path="howMuchWasItPurchase" element="div"/>
        </div>
        <div class="form-group col-md-6">
            <label for="howMuchWasItSaleId">Za jaką cenę został sprzedany:</label>
            <form:input type="text" path="howMuchWasItSale" id="howMuchWasItSaleId"/>
            <form:errors path="howMuchWasItSale" element="div"/>
        </div>
    </div>

    <input type="submit" class="btn btn-primary" value="Zapisz">

</form:form>
</body>
</html>
