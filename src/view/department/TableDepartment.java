package view.department;

import model.department.Departments;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Админ on 26.11.2017.
 */
public class TableDepartment extends DefaultTableModel
{
    private Component component;
    private ArrayList<Departments> departments;

    public TableDepartment(Component component, ArrayList<Departments> departments)
    {
        this.component = component;
        this.departments = departments;
    }

    @Override
    public int getRowCount()
    {
        if (departments == null)
        {
            return 0;
        }
        else
        {
            return departments.size();
        }
    }

    @Override
    public int getColumnCount()
    {
        return 1;
    }

    @Override
    public String getColumnName(int column)
    {
        switch (column) {
            case (0):
                return "Departments";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return departments.get(row).getName();
            default:
                return "";
        }
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        if (row != departments.size()) {
            if (column != 0 ) {
                JOptionPane.showMessageDialog(this.component, "Неверные координаты точки");
                return;
            }
        }
        if (column == 0) {
            departments.get(row).setName((String) aValue);
        }
    }
}
