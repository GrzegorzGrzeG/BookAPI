<%--
  Created by IntelliJ IDEA.
  User: ggrzs
  Date: 12.08.2023
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="book" method="post">
    <label for="isbn">isbn: <form:input path="isbn"/></label>
    <label for="title">title: <form:input path="title"/></label>
    <label for="author">author: <form:input path="author"/></label>
    <label for="category">category: <form:input path="category"/></label>
    <label for="publisher">publisher: <form:input path="publisher"/></label>
    <input type="submit">
</form:form>

</body>
</html>
