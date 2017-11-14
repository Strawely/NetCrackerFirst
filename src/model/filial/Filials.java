package model.filial;

import model.building.Buildings;

import java.util.Collection;


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
    // model.building.Buildings getBuildingByWorkings(model.employee.Employees[] workings);
    boolean setBuildingByAddress(Buildings building, String address);
    boolean setBuildingByCoordinates(double x, double y, Buildings building);
    int getCountBuildings();
    // boolean setBuildingByWorkings(model.employee.Employees[] workings, model.building.Buildings buildings);
}
