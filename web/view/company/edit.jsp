<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 23.02.2018
  Time: 20:13
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
        <td>id</td>
        <td><input disabled name="id" value='<%=rs.getString("id")%>'/></td>
    </tr>
    <tr>
        <td>Director_ID</td>
        <td><input name="director_id" value='<%=rs.getString("Director_ID")%>'>
        </td>
    </tr>
    <tr>
        <td>Name</td>
        <td><input type="text" name="name" value='<%=rs.getString("Name")%>'>
        </td>
    </tr>
    <tr>
        <td>FocusArea</td>
        <td><input type="text" name="focusarea" value='<%=rs.getString("FocusArea")%>'>
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
