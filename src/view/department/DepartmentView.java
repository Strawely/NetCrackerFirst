//package view.department;
//
//import model.department.Departments;
//import model.employee.Employee;
//import model.employee.Employees;
//import view.SetEmpl;
//import view.employee.EmployeeView;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Vector;
//
///**
// * Created by Админ on 13.11.2017.
// */
//public class DepartmentView extends JFrame implements SetEmpl
//{
//    private JLabel labelName = new JLabel("Name:"), labeldirector = new JLabel("Director:");
//    private JTextField textFieldName = new JTextField("0", 8);
//    private JButton buttonDirector;
//    private JLabel labelemployee = new JLabel("Employes");
//    private Departments modelDepartament;
//    private ArrayList<JPanel> listModel = new ArrayList<>();
//    private JButton buttonOk = new JButton("Ok"), buttonNewEmploye = new JButton("New Employe");
//    private JPanel panel = new  JPanel();
//    private JPanel panelName = new JPanel();
//    private JPanel paneldirector = new JPanel();
//    private JPanel panelemloyy = new JPanel();
//    private DepartmentView departmentView = this;
//    //private JList<JButton> buttonEmployee = new JList<>(listModel);
//
//    public DepartmentView(Departments departments)
//    {
//        super("DepartmentView");
//        this.setSize(500, 300);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        add(panel);
//        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
//        this.modelDepartament = departments;
//        panelName.add(labelName);
//        textFieldName.setText(modelDepartament.getName());
//        panelName.add(textFieldName);
//        panel.add(panelName);
//        paneldirector.add(labeldirector);
//        String sDirector = modelDepartament.getDirector().getFirstName() + " " + modelDepartament.getDirector().getSecondName();
//        buttonDirector = new JButton(sDirector);
//        paneldirector.add(buttonDirector);
//        panel.add(paneldirector);
//        buttonDirector.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                EmployeeView employeeView = new EmployeeView(modelDepartament.getDirector(), EmployeeView.SET_EMPLOY, departmentView);
//                employeeView.setVisible(true);
//            }
//        });
//        panel.add(labelemployee);
//        panelemloyy.setLayout(new BoxLayout(panelemloyy,BoxLayout.Y_AXIS));
 //       for(Employees  employees: modelDepartament)
 //       {
 //           JPanel panel1 = new JPanel();
 //           panelemloyy.add(panel1);
 //           JButton button = new JButton(employees.getFirstName() + " " + employees.getSecondName());
 //           button.setName(employees.getFirstName() + employees.getSecondName());
 //           button.addActionListener(new ActionListener()
 //           {
 //               @Override
 //               public void actionPerformed(ActionEvent e)
 //               {
 //                   String name = button.getName();
 //                   Employees employees1 = modelDepartament.getEmployeesByFSName(name);
 //                   EmployeeView employeeView = new EmployeeView(employees1, EmployeeView.SET_EMPLOY, departmentView);
 //                   employeeView.setVisible(true);
 //               }
 //           });
//
 //           panel1.add(button);
 //           JButton buttonDelete = new JButton("Delete");
 //           buttonDelete.setName(employees.getFirstName() + employees.getSecondName());
 //           buttonDelete.addActionListener(new ActionListener()
 //           {
 //               @Override
 //               public void actionPerformed(ActionEvent e)
 //               {
 //                   String name = buttonDelete.getName();
 //                   modelDepartament.removeEmployees(modelDepartament.getEmployeesByFSName(name));
 //                   panel1.setVisible(false);
 //                   panelemloyy.remove(panel1);
//
 //               }
 //           });
 //           panel1.add(buttonDelete);
 //           listModel.add(panel1);
 //       }
 //       panel.add(panelemloyy);
 //       JPanel panelbutton = new JPanel();
 //       panelbutton.add(buttonOk);
 //       panelbutton.add(buttonNewEmploye);
 //       panel.add(panelbutton);
 //       buttonOk.addActionListener(new ActionListener()
 //       {
 //           @Override
 //           public void actionPerformed(ActionEvent e)
 //           {
 //               setVisible(false);
 //               dispose();
 //           }
 //       });
 //       buttonNewEmploye.addActionListener(new ActionListener()
 //       {
 //           @Override
 //           public void actionPerformed(ActionEvent e)
 //           {
 //               Employees employees = new Employee();
 //               EmployeeView employeeView = new EmployeeView(employees, EmployeeView.NEW_EMPLOY, departmentView);
 //               employeeView.setVisible(true);
 //           }
 //       });
//
 //   }
//
 //   @Override
 //   public void NewEmploy(Employees employees)
 //   {
 //       JPanel panel1 = new JPanel();
 //       panelemloyy.add(panel1);
 //       JButton button = new JButton(employees.getFirstName() + " " + employees.getSecondName());
 //       button.setName(employees.getFirstName() + employees.getSecondName());
 //       button.addActionListener(new ActionListener()
 //       {
 //           @Override
 //           public void actionPerformed(ActionEvent e)
 //           {
 //               String name = button.getName();
 //               Employees employees1 = modelDepartament.getEmployeesByFSName(name);
 //               EmployeeView employeeView = new EmployeeView(employees1, EmployeeView.SET_EMPLOY, departmentView);
 //               employeeView.setVisible(true);
 //           }
 //       });
//
 //       panel1.add(button);
 //       JButton buttonDelete = new JButton("Delete");
 //       buttonDelete.setName(employees.getFirstName() + employees.getSecondName());
 //       buttonDelete.addActionListener(new ActionListener()
 //       {
 //           @Override
 //           public void actionPerformed(ActionEvent e)
 //           {
 //               String name = buttonDelete.getName();
 //               modelDepartament.removeEmployees(modelDepartament.getEmployeesByFSName(name));
 //               panel1.setVisible(false);
 //               panelemloyy.remove(panel1);
//
 //           }
 //       });
 //       panel1.add(buttonDelete);
 //       listModel.add(panel1);
 //       modelDepartament.addEmployees(employees);
//    }
//}
