package model;

import model.building.Building;
import model.building.Buildings;
import model.employee.Employees;

import java.io.Serializable;
import java.util.HashSet;

public class BuildingService implements ServiceInterface<Buildings>,Serializable{
    private HashSet<Buildings> buildings;
    private ServiceInterface<Employees> employeeService = new EmployeeService();
    private HashSet<Employees> employees = employeeService.getElements();

    BuildingService() {
        buildings = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            buildings.add(new Building("Address" + i, i, i, employees));
        }
    }

    BuildingService(HashSet<Buildings> buildings) {
        this.buildings = buildings;
    }

    public HashSet<Buildings> getElements() {
        return buildings;
    }

    public void setElements(HashSet<Buildings> elements) {
        buildings = elements;
    }

    public void removeElement(Buildings building) {
        buildings.remove(building);
    }

    public void addElement(Buildings building) {
        buildings.add(building);
    }


}
