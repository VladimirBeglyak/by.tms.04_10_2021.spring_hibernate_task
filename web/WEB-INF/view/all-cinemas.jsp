<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
  <tr>
    <th>Name</th>
    <th>Address</th>
  </tr>
  <c:forEach var="cinema" items="${allCinemas}">
    <tr>
      <td>${cinema.name}</td>
      <td>${cinema.address}</td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
