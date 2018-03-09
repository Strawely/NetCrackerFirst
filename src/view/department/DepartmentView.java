package view.department;

import controller.DepatrmentControllerInter;
import except.CantCreateEmployyException;
import model.department.Departments;
import model.employee.Employee;
import model.employee.Employees;
import view.Observer;
import view.employee.EmployeeView;
import view.utils.SortedAll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Админ on 26.11.2017.
 */
public class DepartmentView extends JFrame implements Observer
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
    private JLabel labeldirecor = new JLabel("Director"), labeldirectorinfo = new JLabel();
    private JPanel paneldirector = new JPanel();
    private String fsname;
    private JButton buttonNewEmp = new JButton("New EmployeeDB"), buttondelete = new JButton("Delete EmployeeDB");
    private JPanel panelbutton = new JPanel();
    private JLabel labelEmployee = new JLabel("Employees");
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu("File"), menuSorted = new JMenu("Sorted");
    private JMenuItem menuItemByFname = new JMenuItem("By first name"), menuItemBySName = new JMenuItem("By second name"),
                        menuItemSalary = new JMenuItem("By salary");
    private DepatrmentControllerInter controller;

    public DepartmentView(Collection<Departments> departments, DepatrmentControllerInter controller)
    {
        super("DepartmentView");
        this.setSize(930, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.controller = controller;
        menuBar.add(menuFile);
        menuBar.add(menuSorted);
        menuSorted.add(menuItemByFname);
        menuSorted.add(menuItemBySName);
        menuSorted.add(menuItemSalary);
        this.setJMenuBar(menuBar);
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
                    controller.deleteEmployee(row, indexs);
//                    for(int i = 0; i < indexs.size(); ++i)
//                    {
//                        DepartmentView.this.departments.get(row).removeEmployee(indexs.get(i));
//                    }
//                    tableEmployye.setEmployees(DepartmentView.this.departments.get(row).getEmployees());
//                    tableemployy.revalidate();
//                    tableemployy.repaint();
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
                    EmployeeView employeeView = new EmployeeView(new Employee(),1 , DepartmentView.this);
                    employeeView.setVisible(true);
//                    if (!DepartmentView.this.departments.get(row).addEmployee(employeeView.getEmployeesModel()))
//                    {
//                        throw new CantCreateEmployyException();
//                    }
                    controller.addEmployee(row, employeeView.getEmployeesModel());
//                    tableEmployye.setEmployees(DepartmentView.this.departments.get(row).getEmployees());
//                    tableemployy.revalidate();
//                    tableemployy.repaint();
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
                EmployeeView employeeView = new EmployeeView(DepartmentView.this.departments.get(row).getDirector(), 0 ,
                        DepartmentView.this);
                employeeView.setVisible(true);
                fsname = DepartmentView.this.departments.get(row).getDirector().getFirstName() +
                        " "  + DepartmentView.this.departments.get(row).getDirector().getSecondName();
                labeldirectorinfo.setText(fsname);
            }
        });
        menuItemByFname.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
//                DepartmentView.this.departments.get(row).setEmployees(
//                        SortedAll.sortbByFirstName(new ArrayList<>(DepartmentView.this.departments.get(row).getEmployees())));
                tableEmployye.setEmployees(SortedAll.sortbByFirstName(new ArrayList<>(DepartmentView.this.departments.get(row).getEmployees())));
                tableemployy.revalidate();
                tableemployy.repaint();
            }
        });

        menuItemBySName.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tableEmployye.setEmployees(SortedAll.sortbBySecondName(new ArrayList<>(DepartmentView.this.departments.get(row).getEmployees())));
                tableemployy.revalidate();
                tableemployy.repaint();
            }
        });

        menuItemSalary.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tableEmployye.setEmployees(SortedAll.sortbBySalary(new ArrayList<>(DepartmentView.this.departments.get(row).getEmployees())));
                tableemployy.revalidate();
                tableemployy.repaint();
            }
        });
    }

    @Override
    public void handleEvent()
    {
        tableEmployye.setEmployees(DepartmentView.this.departments.get(row).getEmployees());
        tableemployy.revalidate();
        tableemployy.repaint();
    }
}
