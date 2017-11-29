package model.department;

import model.employee.Employees;

import java.util.Collection;
import java.util.Comparator;

/**
 * Created by Админ on 07.11.2017.
 */
public interface Departments extends Iterable<Employees>, Comparator<Employees>
{
    Collection<Employees> getEmployees();

    public void setEmployees(Collection<Employees> employees);

    public String getName();

    public void setName(String name);

    public Employees getDirector();

    Employees getEmployeesByName(String fname, String sname);

    Employees getEmployeesByFSName(String fsname);

    boolean addEmployees(Employees employees);

    void removeEmployees(Employees employees);

    int getCountEmploye();

    public void setDirector(Employees director);
}
