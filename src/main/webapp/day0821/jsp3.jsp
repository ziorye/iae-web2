<%@ page import="day0821.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: who-am-i
  Date: 8/18/23
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<User> users = new ArrayList<>();
    users.add(new User("Tom", 55.0));
    users.add(new User("John", 65.0));
    users.add(new User("Tim", 75.0));
%>

<html>
<head>
    <title>JSP demo</title>
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
    <%
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
    %>
            <tr>
                <td><%= i +1 %></td>
                <td><%= user.getName() %></td>
                <td><%= user.getBalance() %></td>
            </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
