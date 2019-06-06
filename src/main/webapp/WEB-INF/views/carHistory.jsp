<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 05.06.19
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Car History</title>
</head>
<body>
<form:form method="post" modelAttribute="carHistory">
    <label for="eventId">Wydarzenie:</label>
    <form:input type="text" path="event" id="eventId"/>
    <form:errors path="event" element="div"/>
    <br><br>

    <label for="dateId">Data:</label>
    <form:input type="date" rows="3" cols="20" path="date" id="dateId"/>
    <form:errors path="date" element="div"/>
    <br><br>

    <label for="howManyKmDrivenId">Ile kilometrów zostało przejechane:</label>
    <form:input type="text" path="howManyKmDriven" id="howManyKmDrivenId"/>
    <form:errors path="howManyKmDriven" element="div"/>
    <br><br>

    <label for="expensesId">Wydatki:</label>
    <form:input type="double" path="expenses" id="expensesId"/>
    <form:errors path="expenses" element="div"/>
    <br><br>

    <label for="notesId">Notatki:</label>
    <form:textarea path="notes" rows="3" cols="20" id="notesId"/>
    <form:errors path="notes" element="div"/>
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
