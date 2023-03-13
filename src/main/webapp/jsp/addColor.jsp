<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 13.03.2023
  Time: 23:23
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
    <input type = "hidden" required name = "command" value="addColor">
    <input class="w3-input w3-border"  required name = "carColor" placeholder="carColor">
    <button type="submit" class="w3-button ui-icon-caret-1-w">ADD</button>
</form>
<form action="servlet" method="get">
    <input type = "hidden" required name = "command" value = "view">
    <button type="submit" class="w3-button ui-icon-caret-1-w">List</button>
</form>
</body>
</html>
