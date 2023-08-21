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
    <title>JSP jstl if</title>
</head>
<body>
<c:if test="${type == 1}">
    admin
</c:if>
<c:if test="${type != 1}">
    user
</c:if>
</body>
</html>
