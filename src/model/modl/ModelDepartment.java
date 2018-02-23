package model.modl;

import model.Observable;
import model.department.Departments;
import model.employee.Employees;
import view.Observer;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Админ on 28.12.2017.
 */
public class ModelDepartment implements Observable
{
    private ArrayList<Departments> departments;
    private ArrayList<Observer> observers;

    public ModelDepartment(Collection<Departments> departments)
    {
        this.departments = new ArrayList<>(departments);
        observers = new ArrayList<>();
    }

    public Collection<Departments> getDepartnents()
    {
        return departments;
    }

    public void addEmployee(int index, Employees employees)
    {
        departments.get(index).addEmployee(employees);
        notifyAllObservers();
    }

    public void deleteEmployee(int index, ArrayList<Employees> employees)
    {
        departments.get(index).getEmployees().removeAll(employees);
        notifyAllObservers();
    }

    @Override
    public void registerObserver(Observer observer)
    {
        this.observers.add(observer);
    }

    @Override
    public void notifyAllObservers()
    {
        for (Observer observer : observers)
        {
            observer.handleEvent();
        }
    }
}
