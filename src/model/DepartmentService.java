package model;

import model.department.Department;
import model.department.Departments;
import model.employee.Employees;

import java.io.Serializable;
import java.util.HashSet;

public class DepartmentService implements ServiceInterface<Departments>,Serializable{
    private HashSet<Departments> departments;

    public DepartmentService() {
        HashSet<Employees> employees;
        ServiceInterface<Employees> employeeService = new EmployeeService();
        employees = employeeService.getElements();
        departments = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            departments.add(new Department(employees, "Department" + i, (Employees) employees.toArray()[1]));
        }
    }

    public DepartmentService(HashSet<Departments> departments) {
        this.departments = departments;
    }


    public HashSet<Departments> getElements() {
        return departments;
    }

    public void setElements(HashSet<Departments> elements) {
        departments = elements;
    }

    public void removeElement(Departments element) {
        departments.remove(element);
    }


    public void addElement(Departments element) {
        departments.add(element);
    }
}
