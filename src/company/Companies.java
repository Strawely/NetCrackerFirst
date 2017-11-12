package company;

import filial.Filials;
import department.Departments;
import employee.Employee;
import employee.Employees;

import java.util.HashSet;

public interface Companies {


    Filials getBranchByName(String name);

    Departments getDepartmentByName(String name);

    String getName();

    void setName(String name);

    String getFocusArea();

    void setFocusArea(String focusArea);

    Employees getDirector();

    void setDirector(Employee director);

    void setDirector(Employees director);

    HashSet<Filials> getBranches();

    void setBranches(HashSet<Filials> branches);

    HashSet<Departments> getDepartments();

    void setDepartments(HashSet<Departments> departments);
}
