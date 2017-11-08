import javafx.util.Pair;

/**
 * Created by Админ on 07.11.2017.
 */
public interface Branches
{
    void setName(String name);
    String getName();
    void setBuildings(Buildings[] buildings);
    Buildings[] getBuildings();
    void addBuilding(Buildings buildings);
    void removeBuilding(Buildings buildings);
    Buildings getBuildingByAddress(String address);
    Buildings getBuildingByCoordinates(double x, double y);
    // Buildings getBuildingByWorkings(Employees[] workings);
    boolean setBuildingByAddress(Buildings building, String address);
    boolean setBuildingByCoordinates(double x, double y, Buildings building);
    // boolean setBuildingByWorkings(Employees[] workings, Buildings buildings);
}
