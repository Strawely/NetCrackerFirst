package view.utils;

import model.department.Departments;
import model.employee.Employees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/**
 * Created by Админ on 30.11.2017.
 */
public class SortedAll
{
    private static ArrayList<Employees> sortted(ArrayList<Employees> collection, Comparator comparator)
    {
        collection.sort(comparator);
        return collection;
    }

    public static ArrayList<Employees> sortbByFirstName(ArrayList<Employees> arrayList)
    {
        return sortted(arrayList, Comparator.comparing(Employees::getFirstName));
    }

    public static ArrayList<Employees> sortbBySecondName(ArrayList<Employees> arrayList)
    {
        return sortted(arrayList, Comparator.comparing(Employees::getSecondName));
    }

    public static ArrayList<Employees> sortbBySalary(ArrayList<Employees> arrayList)
    {
        return sortted(arrayList, Comparator.comparing(Employees::getSalary));
    }
}
