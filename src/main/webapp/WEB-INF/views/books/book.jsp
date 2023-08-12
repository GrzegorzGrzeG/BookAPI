<%--
  Created by IntelliJ IDEA.
  User: ggrzs
  Date: 12.08.2023
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book info</title>
</head>
<body>
<table border="1">
    <thead>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    <th>category</th>
    <th>publisher</th>
    </thead>
    <tbody>
    <tr>
        <td>${book.isbn}</td>
        <td>${book.title}</td>
        <td>${book.author}</td>
        <td>${book.category}</td>
        <td>${book.publisher}</td>
    </tr>
    </tbody>
</table>

</body>
</html>
