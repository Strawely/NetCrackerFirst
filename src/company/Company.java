package company;

import filial.Filials;
import department.Departments;
import employee.Employee;
import employee.Employees;

import java.util.HashSet;

public class Company implements Companies {

    private static final String DEFAULT_STRING_VALUE = "";

    private String name;
    private String focusArea;

    private Employees director;

    private HashSet<Filials> branches;
    private HashSet<Departments> departments;

    public Company() {
        name = DEFAULT_STRING_VALUE;
        focusArea = DEFAULT_STRING_VALUE;
        director = new Employee();
        branches = new HashSet<Filials>();
        departments = new HashSet<Departments>();
    }

    public Company(String name, String focusArea, Employees director, Filials[] branches, Departments[] departments) {
        this.name = name;
        this.focusArea = focusArea;
        this.director = director;
        this.branches = new HashSet<Filials>();
        this.departments = new HashSet<Departments>();
        for (Filials element :
                branches) {
            this.branches.add(element);
        }
        for (Departments element :
                departments) {
            this.departments.add(element);
        }
    }

    @Override
    public Filials getBranchByName(String name){
        Filials result = null;
        for (Filials element :
                branches) {
            if (element.getName().equals(name)){
                result = element;
                break;
            }
        }
        return result;
    }

    @Override
    public Departments getDepartmentByName(String name){
        Departments result = null;
        for (Departments element :
                departments) {
            if (element.getName().equals(name)){
                result = element;
                break;
            }
        }
        return result;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getFocusArea() {
        return focusArea;
    }

    @Override
    public void setFocusArea(String focusArea) {
        this.focusArea = focusArea;
    }

    @Override
    public Employees getDirector() {
        return director;
    }

    @Override
    public void setDirector(Employee director) {
        this.director = director;
    }

    @Override
    public void setDirector(Employees director) {
        this.director = director;
    }

    @Override
    public HashSet<Filials> getBranches() {
        return branches;
    }

    @Override
    public void setBranches(HashSet<Filials> branches) {
        this.branches = branches;
    }

    @Override
    public HashSet<Departments> getDepartments() {
        return departments;
    }

    @Override
    public void setDepartments(HashSet<Departments> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: " + name + "\n");
        stringBuilder.append("Director: " + director.toString() + "\n");
        stringBuilder.append("Focus area: " + focusArea + "\n");
        stringBuilder.append("Filials:\n");
        for (Filials element :
                branches) {
            stringBuilder.append("  " + element.toString() + "\n");
        }
        stringBuilder.append("Departments:\n");
        for (Departments element :
                departments) {
            stringBuilder.append("  " + element.toString() + "\n");
        }
        return stringBuilder.toString();
    }
}
