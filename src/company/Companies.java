package company;

import branch.Branches;
import department.Departments;
import employee.Employee;
import employee.Employees;

import java.util.HashSet;

public interface Companies {


    Branches getBranchByName(String name);

    Departments getDepartmentByName(String name);

    String getName();

    void setName(String name);

    String getFocusArea();

    void setFocusArea(String focusArea);

    Employees getDirector();

    void setDirector(Employee director);

    void setDirector(Employees director);

    HashSet<Branches> getBranches();

    void setBranches(HashSet<Branches> branches);

    HashSet<Departments> getDepartments();

    void setDepartments(HashSet<Departments> departments);
}
