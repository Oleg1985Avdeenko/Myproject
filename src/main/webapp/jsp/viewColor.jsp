<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12.03.2023
  Time: 19:55
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
<c:choose>
    <c:when test="${requestScope.colors.size() > 0}">
        <table class="w3-table-all w3-hoverable">
            <tr>
                <th>Number</th>
                <th>Color</th>
            </tr>
            <c:forEach items="${requestScope.colors}" var="color" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${color.colorName}</td>
                    <td>
                        <form action="servlet" method="get">
                            <input type="hidden" required name="command" value="edit">
                            <input type="hidden" required name="colorId" value="${color.id}">
                            <input type="hidden" required name="colorName" value="${color.colorName}">
                            <button type="submit" class="w3-button ui-icon-caret-1-w">Update</button>
                        </form>
                    </td>
                    <td>
                        <form action="servlet" method="post">
                            <input type="hidden" required name="command" value="delete">
                            <input type="hidden" required name="colorId" value="${color.id}">
                            <input type="hidden" required name="colorName" value="${color.colorName}">
                            <button type="submit" class="w3-button ui-icon-caret-1-w">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </c:when>
</c:choose>
<form action="servlet" method="get">
    <input type = "hidden" required name = "command" value="add">
    <button type="submit " class="w3-button ui-icon-caret-1-w"><b>Add</b></button>
</form>
</body>
</html>