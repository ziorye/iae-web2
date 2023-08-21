<%--
  Created by IntelliJ IDEA.
  User: who-am-i
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>JSP jstl forEach</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>No.</th>
        <th>Name</th>
        <th>Balance</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user" varStatus="status">
    <tr>
        <td>${status.count}</td>
        <td>${user.name}</td>
        <td>${user.balance}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<hr>

<c:forEach begin="1" end="10" step="1" var="page">
    ${page}
</c:forEach>

</body>
</html>
