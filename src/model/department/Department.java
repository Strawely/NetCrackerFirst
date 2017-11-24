package model.department;

import model.employee.Employees;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Админ on 07.11.2017.
 */
public class Department implements Departments
{
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
        return  employees;
    }

    public void setEmployees(Collection<Employees> employees) {
        this.employees = new HashSet<>(employees);
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

    @Override
    public Employees getEmployeesByName(String fname, String sname)
    {
        for (Employees employe : this.employees)
        {
            if(fname.equals(employe.getFirstName()) && sname.equals(employe.getSecondName()))
            {
                return employe;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Employees getEmployeesByFSName(String fsname)
    {
        for (Employees employe : this.employees)
        {
            String s = employe.getFirstName() + employe.getSecondName();
            if(fsname.equals(s))
            {
                return employe;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void addEmployees(Employees employees)
    {
        this.employees.add(employees);
    }

    @Override
    public void removeEmployees(Employees employees)
    {
        this.employees.remove(employees);
    }

    @Override
    public int getCountEmploye()
    {
        return this.employees.size();
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

    @Override
    public Iterator<Employees> iterator()
    {
        return employees.iterator();
    }
}
