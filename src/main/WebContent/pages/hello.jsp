<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Network</title>
  </head>
  <body background = "https://best-wallpaper.net/wallpaper/1366x768/1706/Bridge-lake-grass-sunset_1366x768.jpg" >
  <h1> Добро пожаловать в Network! </h1>

    <c:forEach items="${requestScope ['bean'].allModel}" var="model">
      <p>${model.login}(${model.name})</p>
    </c:forEach>

  <p>
      <a href="pages/registration.jsp">Войти</a>
    </p>
  <p>
       <a href="pages/listUsers.jsp">Список пользователей</a>
  </p>

  </body>
</html>
