<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %><%--
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
    ArrayList<String> files = (ArrayList<String>) request.getAttribute("files");
%>
<form action="/view/filial/" method="post">

    <table>
        <tr>
            <td>
                <h4>Search by</h4>
            </td>
            <td valign="top">
                <select name="col">
                    <option value="1">id</option>
                    <option value="2">Company_ID</option>
                    <option value="3">Name</option>
                </select>
            </td>

        </tr>
        <tr>
            <td>
                <input name="expr" size="6"/>
            </td>
            <td>
                <input type="submit" formmethod="post" value="Search"/>
            </td>
            <td valign="bottom">
                <select name="file">
                    <%for (String s : files) {%>
                    <option value="<%=s%>"><%=s%>
                    </option>
                    <% }%>
                </select>
                <input name="load" type="submit" formmethod="post" value="Load from XML"/>
            </td>
        </tr>

    </table>
    <table border="1">
        <thead>
        <tr>
            <th><a href="sort?n=1">id</a></th>
            <th><a href="sort?n=2">Company_ID</a></th>
            <th><a href="sort?n=3">Name</a></th>
            <th><a href="sort?n=4">Coordinates</a></th>
            <th><a href="sort?n=5">StartOfWork</a></th>
            <th><a href="sort?n=6">EndOfWork</a></th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            while (rs.next()) {
        %>
        <tr>
            <td><%=rs.getString("id")%>
            </td>
            <td><%=rs.getString("Company_ID")%>
            </td>
            <td><%=rs.getString("Name")%>
            </td>
            <td><%=rs.getString("Coordinates")%>
            </td>
            <td><%=rs.getString("StartOfWork")%>
            </td>
            <td><%=rs.getString("EndOfWork")%>
            </td>
            <td>
                <a href='edit?id=<%=rs.getString("id")%>'>Edit</a>
                <a href='delete?id=<%=rs.getString("id")%>'>Delete</a>
                <a href='xml?saveID=<%=rs.getString("id")%>'>Save as XML</a>
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
