<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 14.11.2022
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Конец игры</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>

<body style="background-color: lightblue">
<c:set var="variant" scope="page" value="<%= request.getParameter(\"variant\") %>"/>
<c:set var="currentPage" scope="page" value="${questions.get(pageNumber)}"/>

<c:if test="${variant.equals(\"yes\")}">
  <c:set var="gameOver" scope="page" value="Тебя вернули домой. Победа"/>
</c:if>

<c:if test="${variant.equals(\"no\")}">
  <c:set var="gameOver" scope="page" value="${currentPage.getEndGame()}"/>
</c:if>

<h2>${gameOver}</h2>
<input type="button" value="Начать сначала" onclick="restart()">

<script>
  function restart() {
    $.ajax({
      url: '/restart',
      type: 'POST',
      contentType: 'application/json;charset=UTF-8',
      async: false,
      success: function () {
        location.reload();
      }
    });
  }
</script>

<hr>
<form id="statistics">
  <h2>Статистика:</h2>
  <p>IP address: ${ip}</p>
  <p>Игрок: ${name}</p>
  <p>Сыграно игр: ${gameCounter}</p>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>
