<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%=new java.util.Date()%>
<hr>
<%--jsp 脚本片段--%>
<%
    int sum = 0;
    for (int i = 1; i <= 100; i++) {
        sum += i;
    }
    out.println("<h1>Sum=" + sum + "</h1>");
%>
</body>
</html>
