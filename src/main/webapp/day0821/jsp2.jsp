<%--
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jakarta Server Pages Intro</title>
</head>
<body>
<h1>JSP script type</h1>
<ul>
    <li>&lt% ... %&#62;：直接在到 _jspService() 方法之中</li>
    <li>&lt%= ... %&#62;：作为 out.print() 的参数</li>
    <li>&lt%! ... %&#62;：_jspService()方法之外，as member...</li>
</ul>
<%
    String name = "Y";
    int age = 18;
%>

<%=name%>

<%!
    String role = "admin";

    void method() {
        System.out.println("method...");
    }
%>
</body>
</html>
