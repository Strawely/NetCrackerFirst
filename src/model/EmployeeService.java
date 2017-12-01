package model;

import model.employee.Employee;
import model.employee.Employees;

import java.util.HashSet;

public class EmployeeService {
    HashSet<Employees> employees;

    EmployeeService() {
        employees = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            employees.add(new Employee("FirstName" + i, "SecondName" + i, "0" + i, i * 1000));
        }
    }


    public HashSet<Employees> getElements() {
        return employees;
    }


    public void removeElement(Employees element) {
        employees.remove(element);
    }


    public void addElement(Employees element) {
        employees.add(element);
    }
}
