package model.serv;

import model.company.Companies;
import model.department.Departments;
import model.employee.Employees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Админ on 01.12.2017.
 */
public class SuperService
{
    private EmployeeService employeeService;
    private DepartmentService departmentService;
    private ArrayList<Companies> companyService;

    public SuperService(HashSet<Employees> employees, HashSet<Departments> departmentses, Collection<Companies> companies)
    {
        employeeService = new EmployeeService(employees);
        departmentService = new DepartmentService(departmentses);
        companyService = new ArrayList<>(companies);
    }

    public ArrayList<Companies> getCompanyService()
    {
        return companyService;
    }

    public void setCompanyService(Collection<Companies> companyService)
    {
        this.companyService = new ArrayList<>(companyService);
    }

    public DepartmentService getDepartmentService()
    {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }

    public EmployeeService getEmployeeService()
    {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }


}