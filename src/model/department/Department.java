package model.department;

import model.employee.Employees;

import java.util.Collection;
import java.util.HashSet;


public class Department implements Departments {
    private HashSet<Employees> employees;
    private String name;
    private Employees director;
    private static String DEFAULT_NAME = "";

    public Department(Collection<Employees> employees, String name, Employees director) {
        this.employees = new HashSet<>(employees);
        this.name = name;
        this.director = director;
    }

    public Collection<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employees> employees) {
        this.employees = new HashSet<>(employees);
    }

    @Override
    public void removeEmployee(Employees employee) {
        employees.remove(employee);
    }

    public void addEmployee(Employees employee) {
        employees.add(employee);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employees getDirector() {
        return director;
    }

    public void setDirector(Employees director) {
        this.director = director;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("model.department.Department name: ")
                .append(this.name)
                .append("\nDirector:\n")
                .append(this.director)
                .append("\nEmplyees:");
        for (Employees i : employees) {
            sb.append("\n").append(i);
        }
        return sb.toString();
    }

}
