package department;

import employee.Employees;

import java.util.HashSet;

/**
 * Created by Админ on 07.11.2017.
 */
public class Department implements Departments
{
    private HashSet<Employees> employees;
    private String name;
    private Employees director;
    private static String DEFAULT_NAME = "";

    public Department(Employees[] employees, String name, Employees director) {
        HashSet<Employees> employees1 = new HashSet<>();
        for (int i = 0; i < employees.length; i++) {
            employees1.add(employees[i]);
        }
        this.employees = new HashSet<>(employees1);

        this.name = name;
        this.director = director;
    }

    public Employees[] getEmployees() {
        return (Employees[]) employees.toArray();
    }

    public void setEmployees(Employees[] employees) {
        HashSet<Employees> employees1 = new HashSet<>();
        for (int i = 0; i < employees.length; i++) {
            employees1.add(employees[i]);
        }
        this.employees = new HashSet<>(employees1);
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
                .append("department.Department name: ")
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
