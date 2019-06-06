<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 05.06.19
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Refueling</title>
</head>
<body>
<form:form method="post" modelAttribute="carRefueling">
    <label for="dateId">Data:</label>
    <form:input type="date" rows="3" cols="20" path="date" id="dateId"/>
    <form:errors path="date" element="div"/>
    <br><br>

    <label for="howManyLitersId">Ile litrów zatankowano:</label>
    <form:input type="text" path="howManyLiters" id="howManyLitersId"/>
    <form:errors path="howManyLiters" element="div"/>
    <br><br>

    <label for="fuelTypeId">Rodzaj paliwa:</label>
    <form:checkboxes items="${fuelType}" path="fuelType" id="fuelTypeId"/>
    <form:errors path="fuelType" element="div"/>
    <br/><br/>

    <label for="totalId">Kwota:</label>
    <form:input type="double" path="total" id="totalId"/>
    <form:errors path="total" element="div"/>
    <br><br>

    <label for="carSelectBrand">Pojazd</label>
    <form:select path="carData.id" items="${carDataList}" itemLabel="Brand" itemValue="id" id="carSelectBrand"/>
    <form:errors path="carData" element="div"/>
    <br/><br/>

    <input type="submit" value="Save">
    <br/><br/>
    <div class="card-body">
        <a href="/carData/list" class="btn btn-primary">Wyjdź</a>
    </div>
</form:form>
</body>
</html>
