<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12.03.2023
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <button type="submit" class="w3-button ui-icon-caret-1-w">Update</button>
</form>

<form action="servlet" method="get">
    <input type = "hidden" required name = "command" value = "view">
    <button type="submit" class="w3-button ui-icon-caret-1-w"><b>List</b></button>
</form>
</body>
</html>
