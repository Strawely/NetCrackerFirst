package model.department;

import model.employee.Employees;

import java.util.Collection;
import java.util.Comparator;


public interface Departments {
    Collection<Employees> getEmployees();

    void setEmployees(Collection<Employees> employees);

    boolean addEmployee(Employees employee);

    boolean removeEmployee(Employees employee);

    String getName();

    void setName(String name);

    Employees getDirector();

    void setDirector(Employees director);

    int getCountEmploye();
}
