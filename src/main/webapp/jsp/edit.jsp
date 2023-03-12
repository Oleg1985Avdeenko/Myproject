<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12.03.2023
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<form action="servlet" method="post">
    <input type = "hidden" required name = "command" value="edit">
    <input type = "hidden" required name = "carId" value="${requestScope.carId}">
    <input class="w3-input w3-border"  required name = "price" value = ${requestScope.price}>
    <input class="w3-input w3-border"  required name = "availability" value=${requestScope.availability}>
    <input type = "hidden" required name = "colorId" value="${requestScope.colorId}">
    <input class="w3-input w3-border"  required name = "colorName" value = ${requestScope.colorName}>
    <input type = "hidden" required name = "engineId" value="${requestScope.engineId}">
    <input class="w3-input w3-border"  required name = "price" value = ${requestScope.price}>
    <input class="w3-input w3-border"  required name = "availability" value=${requestScope.availability}>
    <button type="submit" class="w3-button w3-circle w3-teal">Update</button>
</form>

<form action="servlet" method="get">
    <input type = "hidden" required name = "command" value = "view">
    <button type="submit" class="w3-button w3-circle w3-teal">List</button>
</form>
</body>
</html>
