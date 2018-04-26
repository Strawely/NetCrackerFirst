package model.user;

import java.time.LocalTime;

/**
 * Created by Роман on 18.04.2018.
 */
public class User {
    private double x,y;
    private LocalTime time;

    public User(double x, double y, LocalTime time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
