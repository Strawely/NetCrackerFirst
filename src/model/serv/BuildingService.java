package model.serv;

import model.building.Building;
import model.building.Buildings;
import model.employee.Employees;

import java.util.HashSet;

/**
 * Created by Админ on 01.12.2017.
 */
public class BuildingService
{
    HashSet<Buildings> buildings;
    EmployeeService employeeService = new EmployeeService();
    HashSet<Employees> employees = employeeService.getElements();

    BuildingService() {
        buildings = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            buildings.add(new Building("Address" + i, i, i, employees));
        }
    }

    BuildingService(HashSet<Buildings> buildings) {
        this.buildings = buildings;
    }
    public HashSet<Buildings> getElements(){
        return buildings;
    }
    public void removeElement(Buildings building){
        buildings.remove(building);
    }
    public void addElement(Buildings building){
        buildings.add(building);
    }

}
