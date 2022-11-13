<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 10.11.2022
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.javarush.module_3.javaClasses.Answer" %>

<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Вопрос - Ответ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>

<body style="background-color: lightblue">

<div class="position-relative">
    <div class="position-absolute top-0 start-50 translate-middle-x">
        <h1>Вопрос - Ответ</h1>
        <p>Имя: ${name}</p>

<%--        <% Answer answer = (Answer) session.getAttribute("answer");%>--%>
        <% Answer answer = new Answer();%>
        <c:set var ="accept" value="<%=answer.isWin()%>"/>
        <c:set var ="reject" value="<%=answer.isLose()%>"/>

        <form action="login" method="post">
            <h2>Ты потерял память. Принять вызов НЛО? ${question1}</h2>
            <button type="submit">Принять ${answer}</button>
            <button type="submit">Отказаться ${answer}</button>
        </form>
        <hr>

        <c:if test="${accept}">
            <form action="login" method="post">
                <h2>Ты принял вызов. Поднимешься на мостик к капитану? ${question2}</h2>
                <button type="submit">Принять ${answer}</button>
                <button type="submit">Отказаться ${answer}</button>
            </form>
            <hr>
        </c:if>


        <c:if test="${accept}">
            <form action="login" method="post">
                <h2>Ты поднялся на мостик. Ты кто? Рассказать правду о себе? ${question3}</h2>
                <button type="submit">Принять ${answer}</button>
                <button type="submit">Отказаться ${answer}</button>
            </form>
            <hr>
        </c:if>


        <button onclick="restart()">Начать заного</button>
    </div>
</div>


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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>


