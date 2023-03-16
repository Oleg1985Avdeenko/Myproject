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
  <c:when test="${requestScope.cars.size() > 0}">
    <table class="w3-table-all w3-hoverable">
      <tr>
        <th>Number</th>
        <th>Price</th>
        <th>Availability</th>
      </tr>
      <c:forEach items="${requestScope.cars}" var="car" varStatus="status">
        <tr>
          <td>${status.count}</td>
          <td>${car.price}</td>
          <td>${car.availability}</td>
          <td>
            <form action="select1.php" method="get">
              <p><select>
                <option disabled>choose a model</option>
                <option> ${model.modelName}</option>
              </select></p>
            </form>
          </td>
          <td>
            <form action="servlet" method = "get" style="align-content: center">
            <input type = "hidden" required name = "command" value="viewColor">
            <button type="submit" class="w3-button ui-icon-caret-1-w">List Color</button>
          </form>
          </td>
          <td>
            <form action="servlet" method="get">
              <input type="hidden" required name="command" value="edit">
              <input type="hidden" required name="carId" value="${car.id}">
              <input type="hidden" required name="price" value="${car.price}">
              <input type="hidden" required name="availability" value="${car.availability}">
              <button type="submit" class="w3-button ui-icon-caret-1-w">Update</button>
            </form>
          </td>
          <td>
            <form action="servlet" method="post">
              <input type="hidden" required name="command" value="delete">
              <input type="hidden" required name="carId" value="${car.id}">
              <input type="hidden" required name="price" value="${car.price}">
              <input type="hidden" required name="availability" value="${car.availability}">
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