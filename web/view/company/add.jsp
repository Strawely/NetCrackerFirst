<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 03.03.2018
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Company</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
        </tr>
        <tr>
            <td>Director_ID</td>
            <td><input name="director_id">
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>FocusArea</td>
            <td><input type="text" name="focusarea">
            </td>
        </tr>
    </table>

    <input type="submit" value="Add"/>
</form>
</body>
</html>
