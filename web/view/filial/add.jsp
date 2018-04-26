<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 03.03.2018
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Filial</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>Company_ID</td>
            <td><input name="company_id">
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>Coordinates</td>
            <td><input type="text" name="coordinates">
            </td>
        </tr>
        <tr>
            <td>StartOfWork</td>
            <td><input type="text" name="startOfWork">
            </td>
        </tr>
        <tr>
            <td>EndOfWork</td>
            <td><input type="text" name="endOfWork">
            </td>
        </tr>
    </table>

    <input type="submit" value="Add"/>
</form>
</body>
</html>
