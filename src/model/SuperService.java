package model;

import model.building.Buildings;
import model.company.Companies;
import model.department.Departments;
import model.employee.Employees;
import model.filial.Filials;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class SuperService implements Serializable {
    private EmployeeService employeeService;
    private DepartmentService departmentService;
    private CompanyService companyService;
    private FilialService filialService;
    private BuildingService buildingService;


    public SuperService() {
        employeeService = new EmployeeService();
        departmentService = new DepartmentService();
        companyService = new CompanyService();
        filialService = new FilialService();
        buildingService = new BuildingService();
    }

    public SuperService(HashSet<Employees> employees, HashSet<Departments> departments, HashSet<Companies> companies, HashSet<Filials> filials, HashSet<Buildings> buildings) {
        employeeService = new EmployeeService(employees);
        departmentService = new DepartmentService(departments);
        companyService = new CompanyService(companies);
        filialService = new FilialService(filials);
        buildingService = new BuildingService(buildings);
    }

    public SuperService(SuperService superService) {
        this(superService.getEmployeeService().getElements(), superService.getDepartmentService().getElements(), superService.getCompanyService().getElements(), superService.getFilialService().getElements(), superService.getBuildingService().getElements());
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public void setCompanyService(HashSet<Companies> companies) {
        this.companyService = new CompanyService(companies);
    }

    public FilialService getFilialService() {
        return filialService;
    }

    public void setFilialService(HashSet<Filials> filials) {
        this.filialService = new FilialService(filials);
    }

    public BuildingService getBuildingService() {
        return buildingService;
    }

    public void setBuildingService(HashSet<Buildings> buildings) {
        this.buildingService = new BuildingService(buildings);
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(HashSet<Departments> departments) {
        this.departmentService = new DepartmentService(departments);
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(HashSet<Employees> employees) {
        this.employeeService = new EmployeeService(employees);
    }


}