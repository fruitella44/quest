<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 09.11.2022
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.javarush.module_3.QuestLogic" %>
<%@ page import="com.javarush.module_3.TetsClass" %>

<html lang="ru">
<head>
    <meta charset="utf-8">
    <link href="assets/style.css" rel="stylesheet">
    <title>step_by_step</title>
</head>
<body>
<h1>step-by-step</h1>
<p>

<%--    <% TetsClass tetsClass = new TetsClass(); %>--%>
<%--    <%=tetsClass.getTest()%>--%>


    <% QuestLogic questLogic = new QuestLogic(); %>
    <%=questLogic.questionAndAnswer()%>
</p>


<%--<p><input type="button" value=" Выбрать действие "></p>--%>
</body>
</html>
