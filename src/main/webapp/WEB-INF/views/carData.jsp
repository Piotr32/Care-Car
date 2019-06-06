<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 04.06.19
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Data</title>
</head>
<body>
<form:form method="post" modelAttribute="carData">

    <label for="vehicleTypeId">Typ pojazdu:</label>
    <form:select items="${vehicleType}" path="vehicleType" id="vehicleTypeId"/>
    <form:errors path="vehicleType" element="div"/>
    <br/><br/>

    <label for="vehicleNameId">Nazwa pojazdu:</label>
    <form:input type="text" path="vehicleName" id="vehicleNameId"/>
    <form:errors path="vehicleName" element="div"/>
    <br/><br/>

    <label for="brandId">Marka:</label>
    <form:input type="text" path="brand" id="brandId"/>
    <form:errors path="brand" element="div"/>
    <br/><br/>

    <label for="modelId">Model:</label>
    <form:input type="text" path="model" id="modelId"/>
    <form:errors path="model" element="div"/>
    <br/><br/>

    <label for="fuelTypeId">Rodzaj paliwa:</label>
    <form:checkboxes items="${fuelType}" path="fuelType" id="fuelTypeId"/>
    <form:errors path="fuelType" element="div"/>
    <br/><br/>

    <label for="vinNoId">Numer VIN:</label>
    <form:input type="text" path="vinNo" id="vinNoId"/>
    <form:errors path="vinNo" element="div"/>
    <br/><br/>

    <label for="oilTankCapacityId">Pojemność silnika:</label>
    <form:input type="text" path="oilTankCapacity" id="oilTankCapacityId"/>
    <form:errors path="oilTankCapacity" element="div"/>
    <br/><br/>

    <label for="typesOfOilId">Rodzaj oleju silnikowego</label>
    <form:select path="typesOfOil" items="${typesOfOil}" id="typesOfOilId"/>
    <form:errors path="typesOfOil" element="div"/>
    <br/><br/>

    <div><h3>Dane zakupu:</h3> </div>
    <label for="datePurchaseId">Data zakupu:</label>
    <form:input type="date" rows="3" cols="20" path="datePurchase" id="datePurchaseId"/>
    <form:errors path="datePurchase" element="div"/>
    <br/><br/>

    <label for="meterStatusPurchaseId">Stan licznika:</label>
    <form:input type="number" path="meterStatusPurchase" id="meterStatusPurchaseId"/>
    <form:errors path="meterStatusPurchase" element="div"/>
    <br/><br/>

    <label for="howMuchWasItPurchaseId">Ile kosztował pojazd:</label>
    <form:input type="text" path="howMuchWasItPurchase" id="howMuchWasItIdPurchase"/>
    <form:errors path="howMuchWasItPurchase" element="div"/>
    <br/><br/>

    <div><h3>Dane sprzedaży:</h3> </div>
    <label for="dateSaleId">Data Sprzedaży:</label>
    <form:input type="date" rows="3" cols="20" path="dateSale" id="dateSaleId"/>
    <form:errors path="dateSale" element="div"/>
    <br/><br/>

    <label for="meterStatusSaleId">Stan licznika:</label>
    <form:input type="number" path="meterStatusSale" id="meterStatusIdSale"/>
    <form:errors path="meterStatusSale" element="div"/>
    <br/><br/>

    <label for="howMuchWasItSaleId">Za jaką cenę został sprzedany:</label>
    <form:input type="text" path="howMuchWasItSale" id="howMuchWasItSaleId"/>
    <form:errors path="howMuchWasItSale" element="div"/>
    <br/><br/>


    <input type="submit" value="Save">

    <div class="card-body">
        <a href="/carData/list" class="btn btn-primary">Wyjdź</a>
    </div>
</form:form>
</body>
</html>
