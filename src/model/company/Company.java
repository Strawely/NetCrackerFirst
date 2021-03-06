package model.company;

import model.filial.Filials;
import model.department.Departments;
import model.employee.Employee;
import model.employee.Employees;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public class Company implements Companies,Serializable {

    private static final String DEFAULT_STRING_VALUE = "";

    private String name;
    private String focusArea;

    private Employees director;

    private HashSet<Filials> filials;
    private HashSet<Departments> departments;

    public Company() {
        name = DEFAULT_STRING_VALUE;
        focusArea = DEFAULT_STRING_VALUE;
        director = new Employee();
        filials = new HashSet<>();
        departments = new HashSet<>();
    }

    public Company(String name, String focusArea, Employees director, Collection<Filials> filials, Collection<Departments> departments) {
        this.name = name;
        this.focusArea = focusArea;
        this.director = director;
        this.filials = new HashSet<>(filials);
        this.departments = new HashSet<>(departments);
    }

    @Override
    public Filials getFilialByName(String name) {
        Filials result = null;
        for (Filials element :
                filials) {
            if (element.getName().equals(name)) {
                result = element;
                break;
            }
        }
        return result;
    }

    @Override
    public Departments getDepartmentByName(String name) {
        Departments result = null;
        for (Departments element :
                departments) {
            if (element.getName().equals(name)) {
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
    public HashSet<Filials> getFilials() {
        return filials;
    }

    @Override
    public void setFilials(HashSet<Filials> branches) {
        this.filials = branches;
    }

    @Override
    public void addFilial(Filials filial) {
        filials.add(filial);
    }

    @Override
    public void removeFilial(Filials filial) {
        filials.remove(filial);
    }

    @Override
    public void removeDepartment(Departments department) {
        departments.remove(department);
    }

    @Override
    public void addDepartment(Departments department) {
        departments.add(department);
    }

    @Override
    public HashSet<Departments> getDepartments() {
        return departments;
    }

    @Override
    public void setDepartments(HashSet<Departments> departments) {
        this.departments = departments;
    }

    public boolean removeDepatment(Departments department)
    {
        return this.departments.remove(department);
    }

    public boolean addDepatment(Departments department)
    {
        return this.departments.add(department);
    }


    @Override
    public String toString() {
        return name;
    }
}
