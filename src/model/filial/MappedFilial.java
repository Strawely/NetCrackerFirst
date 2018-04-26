package model.filial;

public class MappedFilial {
    private String name;
    private double x, y;
    private int startOfWork;
    private int endOfWork;

    public MappedFilial(String name, double x, double y, int startOfWork, int endOfWork) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.startOfWork = startOfWork;
        this.endOfWork = endOfWork;
    }

    public MappedFilial(String name) {
        this(name, 0, 0, -1, -1);
    }

    public MappedFilial(String name, double x, double y) {
        this(name, x, y, -1, -1);
    }

    public MappedFilial(String name, int startOfWork, int endOfWork) {
        this(name, 0, 0, startOfWork, endOfWork);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getStartOfWork() {
        return startOfWork;
    }

    public void setStartOfWork(int startOfWork) {
        this.startOfWork = startOfWork;
    }

    public int getEndOfWork() {
        return endOfWork;
    }

    public void setEndOfWork(int endOfWork) {
        this.endOfWork = endOfWork;
    }

    public boolean isWorking(int hour) {
        if (startOfWork != -1 && endOfWork != -1 && x != 0 && y != 0 && hour >= startOfWork && hour <= endOfWork)
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return "MappedFilial{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", startOfWork=" + startOfWork +
                ", endOfWork=" + endOfWork +
                '}';
    }
}
