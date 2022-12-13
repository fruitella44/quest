<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 10.11.2022
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Вопрос - Ответ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="<c:url value="jquery-3.6.0.min.js"/>"></script>
</head>

<body style="background-image: url('https://i.imgur.com/27TXzpl.jpg')">
<c:set var="currentPage" scope="page" value="${questions.get(pageNumber)}"/>

<div class="container text-center">
    <div class="row justify-content-md-center">
        <h2 class="text-light">${currentPage.getQuestion()}</h2>

        <div class="col-md-auto">
        <form>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="answer" value="accept" id="flexCheckDefault">
                <label class="text-light form-check-label" for="flexCheckDefault">
                    ${currentPage.getAccept()}
                </label>
            </div>

            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="answer" value="reject" id="flexCheckChecked">
                <label class="text-light form-check-label" for="flexCheckChecked" >
                    ${currentPage.getReject()}
                </label>
            </div>
            <button type="submit" class="btn btn-primary" formaction="/logic">Принять</button>
        </form>
        </div>

        <div class="fixed-bottom">
            <form id="info">
                <h2 class="text-light">Информация:</h2>
                <p class="text-light">IP адрес: ${ipAddress}</p>
                <p class="text-light">Игрок: ${name}</p>
                <p class="text-light">Общее количество игр от всех пользователей: ${gameCounter}</p>
                <p class="text-light">Дата публикации: ${dateReleaseUpdate}</p>
            </form>
        </div>
    </div>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>


