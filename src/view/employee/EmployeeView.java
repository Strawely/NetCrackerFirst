package view.employee;

import model.employee.Employees;
import view.SetEmpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Админ on 12.11.2017.
 */
public class EmployeeView extends JFrame
{
    private Employees employeesModel;
    private JLabel labalfirstname = new JLabel("First Name");
    private JLabel labalsecondtname = new JLabel("Second Name");
    private JLabel labelphone = new JLabel("Phone");
    private JLabel labelsalary = new JLabel("Salary");
    private JTextField textFieldfirstname = new JTextField("0", 8), textsecondtname = new JTextField("0", 8);
    private JTextField textFieldfphone = new JTextField("0", 11), textsalary = new JTextField("0", 8);
    private JButton buttonOk = new JButton("Ok"), buttonset = new JButton("Change");
    public final static int NEW_EMPLOY = 1;
    public final static int SET_EMPLOY = 1;
    private int status;
    private SetEmpl setEmpl;

    public EmployeeView(Employees employees, int status, SetEmpl setEmpl)
    {
        super("EmployeeView");
        this.setResizable(false);
        this.setSize(300, 200);
        this.status = status;
        this.setEmpl = setEmpl;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.employeesModel = employees;
        textFieldfirstname.setText(employeesModel.getFirstName());
        textsecondtname.setText(employeesModel.getSecondName());
        textFieldfphone.setText(employeesModel.getPhoneNumber());
        String salary = "";
        salary += employeesModel.getSalary();
        textsalary.setText(salary);
        JPanel panel = new JPanel();
        this.add(panel);
        panel.setLayout(new BorderLayout());
        JPanel panelname = new JPanel();
        panelname.add(labalfirstname);
        panelname.add(textFieldfirstname);
        panel.add(panelname, BorderLayout.NORTH);
        JPanel panelsname = new JPanel();
        JPanel panelcenter = new JPanel();
        JPanel panelphone = new JPanel();
        panelcenter.setLayout(new BorderLayout());
        panelsname.add(labalsecondtname);
        panelsname.add(textsecondtname);
        panelcenter.add(panelsname, BorderLayout.NORTH);
        panelphone.add(labelphone);
        panelphone.add(textFieldfphone);
        panelcenter.add(panelphone, BorderLayout.CENTER);
        JPanel panelsalary = new JPanel();
        panelsalary.add(labelsalary);
        panelsalary.add(textsalary);
        panelcenter.add(panelsalary, BorderLayout.SOUTH);
        panel.add(panelcenter, BorderLayout.CENTER);
        JPanel panelbut = new JPanel();
        panelbut.add(buttonset);
        panelbut.add(buttonOk);
        panel.add(panelbut, BorderLayout.SOUTH);
        buttonOk.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (status == EmployeeView.SET_EMPLOY)
                {
                    setVisible(false);
                    dispose();
                }
                if (status == EmployeeView.NEW_EMPLOY)
                {
                    setEmpl.NewEmploy(employees);
                }
            }
        });
        buttonset.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    employeesModel.setFirstName(textFieldfirstname.getText());
                    employeesModel.setSecondName(textsecondtname.getText());
                    employeesModel.setPhoneNumber(textFieldfphone.getText());

                        employeesModel.setSalary(Integer.parseInt(textsalary.getText()));
                    }
                    catch (Exception e1)
                    {
                        JOptionPane.showMessageDialog(EmployeeView.this, "Ошибка", "Вы вы вели плохие параметры", JOptionPane.WARNING_MESSAGE);
                    }
                }

        });
    }

    private class ButtonClickListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String command = e.getActionCommand();
            if (command.equals("Ok"))
            {
                dispose();
            }
            if (command.equals("Change"))
            {
                employeesModel.setFirstName(textFieldfirstname.getText());
                employeesModel.setSecondName(textsecondtname.getText());
                employeesModel.setPhoneNumber(textFieldfphone.getText());
                employeesModel.setSalary(Integer.parseInt(textsalary.getText()));
            }
        }
    }
}
