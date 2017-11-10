package branch;

import building.Buildings;
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
    // building.Buildings getBuildingByWorkings(employee.Employees[] workings);
    boolean setBuildingByAddress(Buildings building, String address);
    boolean setBuildingByCoordinates(double x, double y, Buildings building);
    // boolean setBuildingByWorkings(employee.Employees[] workings, building.Buildings buildings);
    int getCountBuildings();
}
