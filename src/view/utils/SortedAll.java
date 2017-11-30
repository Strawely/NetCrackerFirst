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
    private static<T extends Employees> ArrayList<T> sortted(ArrayList<T> collection, Comparator comparator)
    {
        collection.sort(comparator);
        return collection;
    }

    public static<T extends Employees> ArrayList<T> sortbByFirstName(ArrayList<T> arrayList)
    {
        return sortted(arrayList, Comparator.comparing(Employees::getFirstName));
    }

    public static<T extends Employees> ArrayList<T> sortbBySecondName(ArrayList<T> arrayList)
    {
        return sortted(arrayList, Comparator.comparing(Employees::getSecondName));
    }

    public static<T extends Employees> ArrayList<T> sortbBySalary(ArrayList<T> arrayList)
    {
        return sortted(arrayList, Comparator.comparing(Employees::getSalary));
    }
}
