package view.department;

import model.department.Departments;
import model.employee.Employees;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Админ on 26.11.2017.
 */
public class TableEmployee extends DefaultTableModel
{
    private Component component;
    private ArrayList<Employees> employees;
    private ArrayList<Boolean> flags;

    public TableEmployee(Component component, Collection<Employees> employeesCollection)
    {
        this.component = component;
        this.employees = new ArrayList<>(employeesCollection);
        flags = new ArrayList<>();
        for (Employees emplo : employees)
        {
            flags.add(false);
        }
    }

    public void setEmployees(Collection<Employees> employeesCollection)
    {
        this.employees = new ArrayList<>(employeesCollection);
        flags = new ArrayList<>();
        for (Employees emplo : employees)
        {
            flags.add(false);
        }
    }
    @Override
    public int getRowCount()
    {
        if (employees == null)
        {
            return 0;
        }
        else
        {
            return employees.size();
        }
    }

    @Override
    public int getColumnCount()
    {
        return 5;
    }

    @Override
    public String getColumnName(int column)
    {
        switch (column) {
            case (0):
                return "";
            case (1):
                return "Fname";
            case (2):
                return "Sname";
            case (3):
                return "Phone";
            case (4):
                return "Salary";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0)
            return Boolean.class;
        if (columnIndex == 4)
        return Integer.class;
        else return String.class;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case (0):
                return  new Boolean(flags.get(row));
            case 1:
                return employees.get(row).getFirstName();
            case 2:
                return employees.get(row).getSecondName();
            case 3:
                return employees.get(row).getPhoneNumber();
            case 4:
                return employees.get(row).getSalary();
            default:
                return "";
        }
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        if (row != employees.size()) {
            if (column > 4 || column < 0) {
                JOptionPane.showMessageDialog(this.component, "Неверные координаты точки");
                return;
            }
        }
        if (column == 0)
        {
            flags.set(row, (Boolean) aValue);
        }
        if (column == 1) {
            employees.get(row).setFirstName((String) aValue);
        }
        if (column == 2)
        {
            employees.get(row).setSecondName((String) aValue);
        }
        if (column == 3)
        {
            employees.get(row).setPhoneNumber((String) aValue);
        }
        if (column == 4)
        {
            employees.get(row).setSalary(((Integer) aValue));
        }
    }

    public ArrayList<Employees> deleteEmployy()
    {
        ArrayList<Employees> index = new ArrayList<>();
        for (int i = 0 ; i < flags.size(); ++i)
        {
            if(flags.get(i))
            {
                index.add(employees.get(i));
            }
        }
        return index;
    }
}
