<%--
  Created by IntelliJ IDEA.
  User: vupho
  Date: 11/29/2023
  Time: 1:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <form action="CreateGetAllAccount" method="post">
    <label>ID:</label>
    <input name="id" type="text" />
    <br />
    <label>Full name:</label>
    <input name="fullName" type="text" />
    <br />
    <label>Password:</label>
    <input name="password" type="text" />
    <br />
    <label>Email:</label>
    <input name="email" type="text" />
    <br />
    <label>Phone:</label>
    <input name="phone" type="text" />
    <br />
    <label>Status:</label>
    <input type="text" name="status">
    <br />
    <button type="submit">Add</button>
    <button type="reset">CLear</button>
  </form>
  </body>
</html>
