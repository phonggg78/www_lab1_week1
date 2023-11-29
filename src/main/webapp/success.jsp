<%@ page import="com.example.vanquangphong_lab1.models.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: vupho
  Date: 11/29/2023
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Account Information</h1>
<table>
    <tr>
        <th>Account Id</th>
        <th>Full name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Status</th>
    </tr>
    <%
        List<Account> accs = (List<Account>) request.getAttribute("accounts");
        for (Account account : accs)    {
    %>
    <tr>
        <td><%= account.getAccount_id() %></td>
        <td><%= account.getFull_name() %></td>
        <td><%= account.getEmail() %></td>
        <td><%= account.getPhone() %></td>
        <td><%= account.getStatus() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
