<%@ page import="model.filial.MappedFilial" %>
<%@ page import="model.user.User" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.time.LocalTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 17.04.2018
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filials</title>
</head>
<body>
<title>Map with filials</title>
<form action="/map/filialMap">
    <style type="text/css">
        div#map_container {
            width: 100%;
            height: 450px;
        }
    </style>
    <script type="text/javascript"
            src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAlqbxT2duTQGOhvFA3NaIqC4044_OCJ34"></script>
    <div id="map_container"></div>
    Your time:
    <input id="time" name="time" value="<%=LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))%>"/>
    <br>
    Your coordinates:
    <br>
    X:<input id="x" name="x"/><br>
    Y:<input id="y" name="y"/><br>
    <input type="submit" formmethod="post" value="FindNearestFilial"/>
    <input type="submit" formmethod="get" value="Reset"/>

    <script type="text/javascript">
        function init() {
            max = false;
            meMarker = new google.maps.Marker;
            map = new google.maps.Map(document.getElementById("map_container"), {
                center: new google.maps.LatLng(53.2025808, 50.1512085),
                zoom: 12,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            });
            map.addListener('click', function (e) {
                addMe(e.latLng, map)
            });
        }
        function addMe(latLng, map) {
            if (max) {
                meMarker.setMap(null);
            }
            meMarker = new google.maps.Marker({
                position: latLng,
                map: map
            });
            map.panTo(latLng);
            document.getElementById("x").setAttribute('value', latLng.lat().toFixed(7));
            document.getElementById("y").setAttribute('value', latLng.lng().toFixed(7));
            max = true;
        }
        function addFilial(x, y) {
            new google.maps.Marker({
                position: {
                    lat: Number(x),
                    lng: Number(y)
                },
                map: map
            });
            map.panTo(new google.maps.LatLng(Number(x),Number(y)));
        }
        init();
    </script>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("rs");
        String s = ""; //Marker title
        while (rs.next()) {
            if (rs.getString("Coordinates") != null) {
                s = rs.getString("Name") + " Working hours: " + rs.getTime("StartOfWork").toString() + "-" + rs.getTime("EndOfWork").toString();
    %>
    <script type="text/javascript">
        addFilial(<%=rs.getString("Coordinates").split(":")[0]%>,
            <%=rs.getString("Coordinates").split(":")[1]%>)
    </script>
    <%
            }
        }
    %>
</form>
</body>
</html>
