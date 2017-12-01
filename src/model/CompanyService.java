package model;

import model.filial.Filial;
import model.filial.Filials;
import model.building.Building;
import model.building.Buildings;
import model.company.Companies;
import model.company.Company;
import model.department.Departments;
import model.employee.Employees;

import java.util.*;

public class CompanyService {
    HashSet<Companies> companies = new HashSet<>();


    public CompanyService() {
        EmployeeService employeeService = new EmployeeService();
        DepartmentService departmentService = new DepartmentService();
        HashSet<Employees> employees = employeeService.getElements();
        HashSet<Departments> departments = departmentService.getElements();

        Buildings building1 = new Building("address1", 1, 1, employees);
        Buildings building2 = new Building("address2", 2, 2, employees);
        Buildings building3 = new Building("address3", 3, 3, employees);

        HashSet<Buildings> buildings = new HashSet<>();
        buildings.add(building1);
        buildings.add(building2);
        buildings.add(building3);

        Filials filial1 = new Filial("filial1", buildings);
        Filials filial2 = new Filial("filial2", buildings);
        HashSet<Filials> filials1 = new HashSet<>();
        filials1.add(filial1);

        HashSet<Filials> filials2 = new HashSet<>();
        filials2.add(filial1);
        filials2.add(filial2);

        Companies company1 = new Company("Oracle", "focusArea1", (Employees) employees.toArray()[0], filials1, departments); //departmentsByCompany.get("Oracle"));
        Companies company2 = new Company("Microsoft", "focusArea2", (Employees) employees.toArray()[1], filials2, departments); //departmentsByCompany.get("Microsoft"));
        companies.add(company1);
        companies.add(company2);
    }
    public CompanyService(HashSet<Companies> companies ){
        this.companies=companies;
    }

    public HashSet<Companies> getElements() {
        return companies;
    }

    public void removeElement(Companies element) {
        companies.remove(element);
    }

    public void addElement(Companies element) {
        companies.add(element);
    }


}
