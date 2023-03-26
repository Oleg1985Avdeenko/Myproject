

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <title>Cars</title>
</head>
<body>
<div class="header">
  <a class="active" href="index.jsp">Home</a>
  <a href="/servlet?command=wiew_model">Models</a>
  <a href="/servlet?command=wiew_color">Colors</a>
  <a href="/servlet?command=view_engine">Engines</a>
  <a href="/servlet?command=view_option">Options</a>
  <a href="/servlet?command=view_transmission">Transmissions</a>
  <a href="/servlet?command=view_car">Cars</a>
  <a href="/servlet?command=view_client">Clients</a>
  <a href="/servlet?command=view_order">Orders</a>
</div>
<c:choose>
  <c:when test="${requestScope.cars.size() > 0}">
    <table class="w3-table-all w3-hoverable">
      <tr>
                                            <th>№</th>
                                            <th>Price</th>
                                            <th>Availability</th>
                                            <th>Model</th>
                                            <th>Color</th>
                                            <th>Engine</th>
                                            <th>Option</th>
                                            <th>Transmission</th>
                                            <th>Order</th>
                                            <th>Client</th>
      </tr>
      <c:forEach items="${requestScope.cars}" var="car" varStatus="status">
        <tr>
                                                <td>${status.count}</td>
                                                <td>${car.price}</td>
                                                <td>${car.availability}</td>
                                                <td style="display:none">${car.modelId}</td>
                                                <td>${car.modelName}</td>
                                                <td style="display:none">${car.engineId}</td>
                                                <td>${car.engineType}</td>
                                                <td style="display:none">${car.colorId}</td>
                                                <td>${car.colorName}</td>
                                                <td style="display:none">${car.transmissionId}</td>
                                                <td>${car.transmissionType}</td>
                                                <td style="display:none">${car.modelOptionId}</td>
                                                <td>${car.ooptionName}</td>
                                                <td style="display:none">${car.orderId}</td>
                                                <td>${car.orderId}</td>
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
