package model;

import model.department.Department;
import model.department.Departments;
import model.employee.Employees;
import view.Observer;


import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DepartmentService implements ServiceInterface<Departments>,Serializable, Observable{
    private HashSet<Departments> departments;
    private List<Observer> observerList;

    public DepartmentService() {
        HashSet<Employees> employees;
        ServiceInterface<Employees> employeeService = new EmployeeService();
        employees = employeeService.getElements();
        departments = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            departments.add(new Department(employees, "Department" + i, (Employees) employees.toArray()[1]));
        }
        observerList = new ArrayList<>();
        notifyAllObservers();
    }

    public DepartmentService(HashSet<Departments> departments) {
        this.departments = departments;
        observerList = new ArrayList<>();
        notifyAllObservers();
    }


    public HashSet<Departments> getElements() {
        return departments;
    }

    public void setElements(HashSet<Departments> elements) {
        departments = elements;
        notifyAllObservers();
    }

    public void removeElement(Departments element) {
        departments.remove(element);
        notifyAllObservers();
    }

    public Departments getElementByName(String name)
    {
        for(Departments department : departments)
        {
            if(name.equals(department.getName()))
            {
                return department;
            }
        }
        return null;
    }


    public void addElement(Departments element) {
        departments.add(element);
        notifyAllObservers();
    }

    @Override
    public void registerObserver(Observer observer)
    {
        this.observerList.add(observer);
    }

    @Override
    public void notifyAllObservers()
    {
        for (Observer observer: observerList)
        {
            observer.handleEvent();
        }
    }
}
