package model;

import model.company.Companies;
import model.department.Departments;
import model.employee.Employees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class SuperService
{
    private model.EmployeeService employeeService;
    private model.DepartmentService departmentService;
    private CompanyService companyService;

    public SuperService(HashSet<Employees> employees, HashSet<Departments> departmentses, HashSet<Companies> companies)
    {
        employeeService = new model.EmployeeService(employees);
        departmentService = new model.DepartmentService(departmentses);
        companyService = new CompanyService(companies);
    }

    public CompanyService getCompanyService()
    {
        return companyService;
    }

    public void setCompanyService(HashSet<Companies> companyService)
    {
        this.companyService = new CompanyService(companyService);
    }

    public model.DepartmentService getDepartmentService()
    {
        return departmentService;
    }

    public void setDepartmentService(model.DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }

    public model.EmployeeService getEmployeeService()
    {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }


}