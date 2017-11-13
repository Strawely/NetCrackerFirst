package company;

import filial.Filials;
import department.Departments;
import employee.Employee;
import employee.Employees;

import java.util.HashSet;

public interface Companies {


    Filials getFilialByName(String name);

    Departments getDepartmentByName(String name);

    String getName();

    void setName(String name);

    String getFocusArea();

    void setFocusArea(String focusArea);

    Employees getDirector();

    void setDirector(Employee director);

    void setDirector(Employees director);

    HashSet<Filials> getFilials();

    void setFilials(HashSet<Filials> branches);

    void addFilial(Filials filial);
    void removeFilial(Filials filial);

    HashSet<Departments> getDepartments();

    void setDepartments(HashSet<Departments> departments);

    void addDepartment(Departments department);
    void removeDepartment(Departments department);
}
