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
    <input type="time" id="time" name="time" value="<%=LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))%>"/>
    <br>
    Your coordinates:
    <br>
    X:<input id="x" name="x"/><br>
    Y:<input id="y" name="y"/><br>
    <input type="submit" formmethod="post" value="FindNearestFilial"/>
    <input type="submit" formmethod="get" value="Reset"/>
    <script type="text/javascript">
        function init() {
            myMarker = new google.maps.Marker;
            map = new google.maps.Map(document.getElementById("map_container"), {
                center: new google.maps.LatLng(53.2025808, 50.1512085),
                zoom: 12,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            });
            map.addListener('click', function (e) {
                myMarker.setMap(null);
                addMe(e.latLng, map)
            });
        }
        function addMe(latLng, map) {
            myMarker = new google.maps.Marker({
                position: latLng,
                map: map
            });
            map.panTo(latLng);
            document.getElementById("x").setAttribute('value', latLng.lat().toFixed(7));
            document.getElementById("y").setAttribute('value', latLng.lng().toFixed(7));
        }
        function showMe(x, y, time) {
            myMarker.setMap(null);
            myMarker = new google.maps.Marker({
                position: {
                    lat: x,
                    lng: y
                },
                map: map
            });
            document.getElementById("x").setAttribute('value', x.toFixed(7));
            document.getElementById("y").setAttribute('value', y.toFixed(7));
            document.getElementById("time").setAttribute('value', time);

        }
        function addFilial(x, y, title, type) {

            var contentString = '<div id="content">' +
                '<div id="siteNotice">' +
                '</div>' +
                '<b><b>' + title.split(' ')[0] + '</b></p>' +
                '<div id="bodyContent">' +
                '<p><b><br> Working hours: <br></b>' + title.split(' ')[1] + '</p>' +
                '</div>' +
                '</div>';
            var marker;
            if (type === 1) {
                marker = new google.maps.Marker({
                    position: {
                        lat: Number(x),
                        lng: Number(y)
                    },
                    icon: 'http://maps.google.com/mapfiles/ms/icons/green-dot.png',
                    title: String(title),
                    map: map
                });
            }
            else if (type === 2) {
                marker = new google.maps.Marker({
                    position: {
                        lat: Number(x),
                        lng: Number(y)
                    },
                    icon: 'http://maps.google.com/mapfiles/ms/icons/red-dot.png',
                    title: String(title),
                    map: map
                });
            }
            else {
                marker = new google.maps.Marker({
                    position: {
                        lat: Number(x),
                        lng: Number(y)
                    },
                    icon: 'http://maps.google.com/mapfiles/ms/icons/blue-dot.png',
                    title: String(title),
                    map: map
                });
            }


            var infowindow = new google.maps.InfoWindow({
                content: contentString
            });
            marker.addListener('click', function () {
                infowindow.open(map, marker);
            });
            map.panTo(new google.maps.LatLng(Number(x), Number(y)));
        }
        init();
    </script>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("rs");
        ResultSet nearest = (ResultSet) request.getAttribute("nearest");
        User user = (User) request.getAttribute("user");
        String s;
        LocalTime startOfWork, endOfWork, actualTime = LocalTime.now();
        int type;
        if (nearest != null && user != null) {
            actualTime = LocalTime.parse(user.getTime().toString(), DateTimeFormatter.ofPattern("HH:mm"));
            nearest.next();
        }
        while (rs.next()) {
            startOfWork = LocalTime.parse(rs.getTime("StartOfWork").toString(), DateTimeFormatter.ofPattern("HH:mm:ss"));
            endOfWork = LocalTime.parse(rs.getTime("EndOfWork").toString(), DateTimeFormatter.ofPattern("HH:mm:ss"));
            if (rs.getString("Coordinates") != null) {
                s = rs.getString("Name") + " " + rs.getTime("StartOfWork").toString() + "-" + rs.getTime("EndOfWork").toString();
                if (startOfWork.isBefore(actualTime) && (endOfWork.isAfter(actualTime)))
                    type = 1;
                else
                    type = 2;
                if (nearest != null && nearest.getInt(1) == rs.getInt(1)) {
                    type = 3;
                }
    %>
    <script type="text/javascript">
        addFilial(<%=rs.getString("Coordinates").split(":")[0]%>,
            <%=rs.getString("Coordinates").split(":")[1]%>,
            "<%=s%>", <%=type%>)
        <% if(user!=null){
            %>
        showMe(<%=user.getX()%>, <%=user.getY()%>, '<%=user.getTime().format(DateTimeFormatter.ofPattern("HH:mm")).toString()%>');
        <%
        }
        %>
    </script>
    <%
            }
        }

    %>
</form>
</body>
</html>
