<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.05.2017
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Posts</title>
</head>
<body>
<table border="1">
    <c:forEach var="post" items="${requestScope.posts}">
        <tr>
            <td><c:out value="${post.txt}"></c:out></td>
           <td><c:out value="${post.id}"></c:out></td>
            <td><a href="/deletePost?id=${post.id}">X</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
