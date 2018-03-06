<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Network</title>
  </head>
  <body>
  <h1> Hello </h1>

  <c:forEach items="${requestScope ['bean'].allModel}" var="model">
    <p>${model.login}(${model.name})</p>
  </c:forEach>

  </body>
</html>
