package model.modl;

import model.company.Companies;
import model.department.Department;
import model.department.Departments;
import model.employee.Employees;

/**
 * Created by Админ on 15.12.2017.
 */
public interface Model
{
    void addCompany(Companies companies);
    void deleteCompany(Companies companies);
    void addDepartment(Departments department);
    void deleteDepartment(Departments departments);
    void addEmployee(Employees employee);
    void deleteEmployee(Employees employee);
}
