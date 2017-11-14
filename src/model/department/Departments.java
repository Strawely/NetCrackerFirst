package model.department;

import model.employee.Employees;

import java.util.Collection;


public interface Departments {
    Collection<Employees> getEmployees();

    void setEmployees(Collection<Employees> employees);

    void addEmployee(Employees employee);

    void removeEmployee(Employees employee);

    String getName();

    void setName(String name);

    Employees getDirector();

    void setDirector(Employees director);

}
