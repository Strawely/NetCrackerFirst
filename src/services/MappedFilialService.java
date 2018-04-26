package services;


import model.user.User;

import java.sql.ResultSet;
import java.time.LocalTime;

public class MappedFilialService {
    public static int findNearestFilial(ResultSet rs, User user) {
        double distance, minDistance = Double.MAX_VALUE;
        int num = -1;
        String coordinates;
        LocalTime startOfWork, endOfWork;
        try {
            //for (int i = 0; i < mappedFilials.length; i++) {
            while (rs.next()) {
                startOfWork = rs.getTime("StartOfWork") != null ? rs.getTime("StartOfWork").toLocalTime() : null;
                endOfWork = rs.getTime("EndOfWork") != null ? rs.getTime("EndOfWork").toLocalTime() : null;
                coordinates = rs.getString("Coordinates");
                if (coordinates != null) {
                    distance = getDistance(Double.parseDouble(coordinates.split(":")[0]), user.getX(),
                            Double.parseDouble(coordinates.split(":")[1]), user.getY());
                    if (user.getTime().equals(startOfWork) ||
                            user.getTime().equals(endOfWork) ||
                            ((user.getTime().isAfter(startOfWork) && user.getTime().isBefore(endOfWork))) &&
                                    minDistance > distance) {
                        num = rs.getInt("ID");
                        minDistance = distance;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    private static double getDistance(double x1, double x2, double y1, double y2) {
        return Math.hypot(x2 - x1, y2 - y1);
    }
/*
    public static MappedFilial[] fillMappedFilials(MappedFilial[] mappedfilials, int range) {
        MappedFilial[] filials = new MappedFilial[mappedfilials.length];
        Random random = new Random();
        for (int i = 0; i < filials.length; i++)
            filials[i] = new MappedFilial("Filial " + i,
                    random.nextDouble() * 100 % range,
                    random.nextDouble() * 100 % range,
                    random.nextInt(24) % 12,
                    12 + random.nextInt(24) % 12);
        return filials;
    }
*/
}
