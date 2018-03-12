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
    <title>Edit</title>
</head>
<body>
<%
    ResultSet rs = (ResultSet) request.getAttribute("rs");
    while (rs.next()) {
%>
<form action="" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input disabled name="id" value='<%=rs.getString("ID")%>'/></td>
        </tr>
        <tr>
            <td>Company_ID</td>
            <td><input name="company_id" value='<%=rs.getString("Company_ID")%>'>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value='<%=rs.getString("Name")%>'>
            </td>
        </tr>
    </table>

    <input type="submit" value="Update"/>
</form>
<%
    }
%>
</body>
</html>
