<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 06.06.19
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Organizer</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <header>Planowane wydarzenie</header>
    <div class="card">
        <div class="card-body">
            <a href="/carOrganizer/list" class="btn btn-primary">Wyjdź</a>
        </div>
    </div>
    <div class="card mt-4">


        <div class="card-body">

<form:form method="post" modelAttribute="carOrganizer">
    <div class="row">
        <div class="form-group col-md-4">
    <label for="eventId">Wydarzenie:</label>
    <form:input type="text" path="event" id="eventId"/>
    <form:errors path="event" element="div"/>
        </div>
    </div>
        <div class="row">
            <div class="form-group col-md-4">
    <label for="dateId">Data:</label>
    <form:input type="date" rows="3" cols="20" path="date" id="dateId"/>
    <form:errors path="date" element="div"/>
    </div>
        </div>
    <div class="row">
    <div class="form-group col-md-4">
    <label for="expensesId">Wydatki:</label>
    <form:input type="double" path="expenses" id="expensesId"/>
    <form:errors path="expenses" element="div"/>
     </div>
    </div>
    <div class="row">
    <div class="form-group col-md-4">
    <label for="notesId">Notatki:</label>
    <form:textarea path="notes" rows="3" cols="20" id="notesId"/>
    <form:errors path="notes" element="div"/>
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
