<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 25.02.2018
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filials</title>
</head>
<body>
<%
    ResultSet rs = (ResultSet) request.getAttribute("rs");
%>
<form action="" method="post">
    <table border="1">
        <thead>
        <tr>
            <th><a href="sort?n=1">ID</a></th>
            <th><a href="sort?n=2">Company_ID</a></th>
            <th><a href="sort?n=3">Name</a></th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            while (rs.next()) {
        %>
        <tr>
            <td><%=rs.getString("ID")%>
            </td>
            <td><%=rs.getString("Company_ID")%>
            </td>
            <td><%=rs.getString("Name")%>
            </td>
            <td>
                <a href='edit?id=<%=rs.getString("ID")%>'>Edit</a>
                <a href='delete?id=<%=rs.getString("ID")%>'>Delete</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <a href="add"><h3>Add filial</h3></a>
    <br>
    <a href='../..'>Main menu</a>
</form>
</body>
</html>
