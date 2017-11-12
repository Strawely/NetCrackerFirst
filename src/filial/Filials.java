package filial;

import building.Buildings;

import java.util.Collection;

/**
 * Created by Админ on 07.11.2017.
 */
public interface Filials
{
    void setName(String name);
    String getName();
    void setBuildings(Collection<Buildings> buildings);
    Collection<Buildings> getBuildings();
    void addBuilding(Buildings buildings);
    void removeBuilding(Buildings buildings);
    Buildings getBuildingByAddress(String address);
    Buildings getBuildingByCoordinates(double x, double y);
    // building.Buildings getBuildingByWorkings(employee.Employees[] workings);
    boolean setBuildingByAddress(Buildings building, String address);
    boolean setBuildingByCoordinates(double x, double y, Buildings building);
    int getCountBuildings();
    // boolean setBuildingByWorkings(employee.Employees[] workings, building.Buildings buildings);
}
