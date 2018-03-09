package view;

import model.*;
import model.company.Companies;
import model.company.Company;
import model.department.Departments;
import model.employee.Employee;
import model.employee.Employees;
import model.filial.Filials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Collection;
import java.util.HashSet;

public class CompanyViewAdd extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JList list1;
    private JList list2;
    private JList list3;
    private JTextField textField1;
    private JTextField textField2;
    private JScrollPane JScrollPaneFilials;
    private JScrollPane JScrollPaneDepartments;
    private JScrollPane JScrollPaneDirector;
    Companies company;

    public CompanyViewAdd() {
        setContentPane(contentPane);
        setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.contentPane.setPreferredSize(new Dimension(400, 300));
        this.JScrollPaneFilials.setPreferredSize(new Dimension(80, 100));
        this.JScrollPaneDepartments.setPreferredSize(new Dimension(80, 100));
        this.JScrollPaneDirector.setPreferredSize(new Dimension(80, 100));
        ServiceInterface<Departments> departmentModel = new DepartmentService();
        ServiceInterface<Filials> filialModel = new FilialService();
        EmployeeService employeeModel = new EmployeeService();

        DefaultListModel<Departments> departmentsDefaultListModel = new DefaultListModel<>();
        for (Departments d : departmentModel.getElements())
            departmentsDefaultListModel.addElement(d);
        list1.setModel(departmentsDefaultListModel);
        list1.setSelectedIndex(list1.getFirstVisibleIndex() + 1);
        DefaultListModel<Filials> filialsDefaultListModel = new DefaultListModel<>();
        for (Filials f : filialModel.getElements())
            filialsDefaultListModel.addElement(f);
        list2.setModel(filialsDefaultListModel);
        list2.setSelectedIndex(list2.getFirstVisibleIndex() + 1);
        DefaultListModel<Employees> employeesDefaultListModel = new DefaultListModel<>();
        for (Employees e : employeeModel.getElements())
            employeesDefaultListModel.addElement(e);
        list3.setModel(employeesDefaultListModel);
        list3.setSelectedIndex(list3.getFirstVisibleIndex() + 1);
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HashSet<Departments> departmentsHashSet = new HashSet<>(list1.getSelectedValuesList());
                HashSet<Filials> filialsHashSet = new HashSet<>(list2.getSelectedValuesList());
                Employees employeeD = (Employees) list3.getSelectedValue();
                company = new Company(textField1.getText(), textField2.getText(), employeeD, filialsHashSet, departmentsHashSet);
                setVisible(false);
                dispose();
            }
        });
    }

    public Companies getNewCompany() {
        return company;
    }


}
