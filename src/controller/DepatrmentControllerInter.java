package controller;

import model.employee.Employees;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Админ on 14.12.2017.
 */
public interface DepatrmentControllerInter
{
    void addEmployee(int index, Employees employee);
    void deleteEmployee(int index, ArrayList<Employees> employees);
}
