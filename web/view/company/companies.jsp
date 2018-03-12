<%@ page import="model.employee.Employees" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="model.EmployeeService" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 23.02.2018
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Companies</title>
</head>
<body>
<form action="/view/company/" method="post">
<%
    ResultSet rs = (ResultSet) request.getAttribute("rs");
%>

    <table>
        <tr>
            <td>
                <h4>Search by</h4>
            </td>
            <td valign="top">
                <select name="col">
                    <option value="1">ID</option>
                    <option value="2">Director_ID</option>
                    <option value="3">Name</option>
                    <option value="4">FocusArea</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input name="expr" size="10"/>
            </td>
            <td>
                <input type="submit" formmethod="post" value="Search"/>
            </td>
        </tr>

    </table>
    <table border="1">
        <thead>
        <tr>
            <th><a href="sort?n=1">ID</a></th>
            <th><a href="sort?n=2">Director_ID</a></th>
            <th><a href="sort?n=3">Name</a></th>
            <th><a href="sort?n=4">FocusArea</a></th>
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
            <td><%=rs.getString("Director_ID")%>
            </td>
            <td><%=rs.getString("Name")%>
            </td>
            <td><%=rs.getString("FocusArea")%>
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
    <h3><a href="add">Add company</a></h3>
    <br>
    <a href='../..'>Main menu</a>
</form>
</body>
</html>
