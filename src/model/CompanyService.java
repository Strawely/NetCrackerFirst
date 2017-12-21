package model;

import model.filial.Filial;
import model.filial.Filials;
import model.building.Building;
import model.building.Buildings;
import model.company.Companies;
import model.company.Company;
import model.department.Departments;
import model.employee.Employees;

import java.io.Serializable;
import java.util.*;

public class CompanyService implements ServiceInterface<Companies>,Serializable{
    private HashSet<Companies> companies = new HashSet<>();


    public CompanyService() {
        ServiceInterface<Employees> employeeService = new EmployeeService();
        ServiceInterface<Departments> departmentService = new DepartmentService();
        ServiceInterface<Filials> filialService = new FilialService();
        HashSet<Employees> employees = employeeService.getElements();
        HashSet<Departments> departments = departmentService.getElements();
        HashSet<Filials> filials = filialService.getElements();

        ServiceInterface<Buildings> buildingService = new BuildingService();
        HashSet<Buildings> buildings = buildingService.getElements();


        Companies company1 = new Company("Oracle", "focusArea1", (Employees) employees.toArray()[0], filials, departments); //departmentsByCompany.get("Oracle"));
        Companies company2 = new Company("Microsoft", "focusArea2", (Employees) employees.toArray()[1], filials, departments); //departmentsByCompany.get("Microsoft"));

        addElement(company1);
        addElement(company2);
    }

    public CompanyService(HashSet<Companies> companies) {
        this.companies = companies;
    }

    public HashSet<Companies> getElements() {
        return companies;
    }

    public void setElements(HashSet<Companies> elements) {
        companies = elements;
    }

    public void removeElement(Companies element) {
        companies.remove(element);
    }

    public void addElement(Companies element) {
        companies.add(element);
    }


}
