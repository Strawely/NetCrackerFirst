package view.department;

import except.CantCreateEmployyException;
import model.department.Departments;
import model.employee.Employee;
import model.employee.Employees;
import view.employee.EmployeeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Админ on 26.11.2017.
 */
public class DepartmentView extends JFrame
{
    private ArrayList<Departments> departments;
    private JPanel paneldepartments = new JPanel();
    private TableDepartment tableDepartment;
    private JTable table;
    private JScrollPane scrollPane;
    private JPanel panelinfo;
    private JPanel panelEmployye;
    private TableEmployee tableEmployye;
    private JTable tableemployy;
    private JScrollPane scrollPaneEmployy;
    private int row = 0;
    private JLabel labeldirecor = new JLabel("Dircotor"), labeldirectorinfo = new JLabel();
    private JPanel paneldirector = new JPanel();
    private String fsname;
    private JButton buttonNewEmp = new JButton("New Employee"), buttondelete = new JButton("Delete Employee");
    private JPanel panelbutton = new JPanel();
    private JLabel labelEmployee = new JLabel("Employees");

    public DepartmentView(Collection<Departments> departments)
    {
        super("DepartmentView");
        this.setSize(930, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.departments = new ArrayList<>(departments) ;
        tableDepartment = new TableDepartment(paneldepartments ,this.departments);
        table = new JTable(tableDepartment);
        scrollPane = new JScrollPane(table);
        this.setLayout(new GridLayout(1, 2));
        add(scrollPane);
        panelinfo = new  JPanel();
        panelinfo.setLayout(new BoxLayout(panelinfo, BoxLayout.Y_AXIS));
        paneldirector.add(labeldirecor);
        fsname = this.departments.get(0).getDirector().getFirstName() + " " + this.departments.get(0).getDirector().getSecondName();
        labeldirectorinfo.setText(fsname);
        paneldirector.add(labeldirectorinfo);
        panelinfo.add(paneldirector);
        panelinfo.add(labelEmployee);
        panelEmployye = new JPanel();
        tableEmployye = new TableEmployee(panelEmployye , this.departments.get(0).getEmployees());
        tableemployy = new JTable(tableEmployye);
        tableemployy.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPaneEmployy = new JScrollPane(tableemployy);
        panelinfo.add(scrollPaneEmployy);
        add(panelinfo);
        panelbutton.add(buttonNewEmp);
        panelbutton.add(buttondelete);
        panelinfo.add(panelbutton);
        table.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                row = table.rowAtPoint(e.getPoint());
                fsname = DepartmentView.this.departments.get(row).getDirector().getFirstName() +
                         " "  + DepartmentView.this.departments.get(row).getDirector().getSecondName();
                labeldirectorinfo.setText(fsname);
                tableEmployye.setEmployees(DepartmentView.this.departments.get(row).getEmployees());
                tableemployy.revalidate();
                tableemployy.repaint();
            }
        });
        buttondelete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ArrayList<Employees> indexs = tableEmployye.deleteEmployy();
                if (indexs.size() != 0)
                {
                    for(int i = 0; i < indexs.size(); ++i)
                    {
                        DepartmentView.this.departments.get(row).removeEmployees(indexs.get(i));
                    }
                    tableEmployye.setEmployees(DepartmentView.this.departments.get(row).getEmployees());
                    tableemployy.revalidate();
                    tableemployy.repaint();
                }
            }
        });
        buttonNewEmp.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    EmployeeView employeeView = new EmployeeView(new Employee(), DepartmentView.this);
                    employeeView.setVisible(true);
                    if (!DepartmentView.this.departments.get(row).addEmployees(employeeView.getEmployeesModel()))
                    {
                        throw new CantCreateEmployyException();
                    }
                    tableEmployye.setEmployees(DepartmentView.this.departments.get(row).getEmployees());
                    tableemployy.revalidate();
                    tableemployy.repaint();
                }
                catch (CantCreateEmployyException e1)
                {
                    JOptionPane.showMessageDialog(DepartmentView.this, "Данный сотрудник уже существует", "Ошибка", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        labeldirectorinfo.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                EmployeeView employeeView = new EmployeeView(DepartmentView.this.departments.get(row).getDirector(),
                        DepartmentView.this);
                employeeView.setVisible(true);
                fsname = DepartmentView.this.departments.get(row).getDirector().getFirstName() +
                        " "  + DepartmentView.this.departments.get(row).getDirector().getSecondName();
                labeldirectorinfo.setText(fsname);
            }
        });
    }
}
