<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<form action="servlet" method = "get" style="align-content: center">
    <input type = "hidden" required name = "command" value="view">
    <button type="submit" class="w3-button ui-icon-caret-1-w"><b>List Car</b></button>
</form>

<form action="servlet" method = "get" style="align-content: center">
    <input type = "hidden" required name = "command" value="add">
    <button type="submit" class="w3-button ui-icon-caret-1-w"><b>Add Car</b></button>
</form>
</body>
</html>
