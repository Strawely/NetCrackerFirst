package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.company.Companies;
import model.company.Company;
import services.Serializer;
import services.TestClass;

public class CompanyView extends JDialog {
    private JPanel contentPane;
    private JTextField textField1;
    private JTextField textField2;
    private JButton loadCompaniesButton;
    private JButton filialsButton;
    private JButton buildingsButton;
    private JButton departmentsButton;
    private JButton employeesButton;
    private JTextField textField3;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList<Companies> list1;
    private JButton removeCompanyButton;
    private JButton addCompanyButton;
    private JButton serializeCompanyButton;
    TestClass testClass = new TestClass();

    int i;

    public CompanyView() {
        setModal(true);
        DefaultListModel<Companies> listModel = new DefaultListModel<>();
        list1.setModel(listModel);
        loadCompaniesButton.addActionListener(e -> {
            listModel.clear();
            for (Companies company : testClass.getCompanies())
                listModel.addElement(company);
        });
        removeCompanyButton.addActionListener(e -> {
            if(list1.getSelectedIndex()!=-1) {
                testClass.removeCompany(listModel.getElementAt(list1.getSelectedIndex()));
                listModel.remove(list1.getSelectedIndex());
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
        });
        setContentPane(contentPane);
        list1.addListSelectionListener(e -> {
            if(list1.getSelectedIndex()!=-1) {
                Companies selectedCompany = listModel.getElementAt(list1.getSelectedIndex());
                textField1.setText(selectedCompany.getName());
                textField2.setText(selectedCompany.getFocusArea());
                textField3.setText(selectedCompany.getDirector().toString());
            }
        });
        //TODO: addButton
        addCompanyButton.addActionListener(e -> {

        });
        serializeCompanyButton.addActionListener(e -> {
            if (list1.getSelectedIndex() != -1)
                Serializer.store(listModel.getElementAt(list1.getSelectedIndex()));
        });
    }

    public static void main(String[] args) {
        CompanyView dialog = new CompanyView();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
