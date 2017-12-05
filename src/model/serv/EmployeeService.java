package model.serv;

import model.employee.Employee;
import model.employee.Employees;

import java.util.HashSet;

/**
 * Created by Админ on 01.12.2017.
 */
public class EmployeeService
{
    HashSet<Employees> employees;

    public EmployeeService() {
        employees = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            employees.add(new Employee("FirstName" + i, "SecondName" + i, "0" + i, i * 1000));
        }
    }
    public EmployeeService(HashSet<Employees> employees){
        this.employees=employees;
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
