package view;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

import model.ServiceInterface;
import model.company.Companies;
import model.department.Departments;
import model.filial.Filials;
import services.SearchClass;
import services.Serializer;
import model.CompanyService;

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
    private JList list1;
    private JButton removeCompanyButton;
    private JButton addCompanyButton;
    private JButton serializeCompaniesButton;
    private JList list2;
    private JList list3;
    private JPanel JPanel1;
    private JPanel JPanel0;
    private JPanel JPanel2;
    ServiceInterface<Companies> companyModel=new CompanyService();
  //  CompanyController companyController;


    public CompanyView(/*CompanyService companyModel,CompanyController companyController*/) {
        /*this.companyModel = companyModel;
        this.companyController = companyController;*/
        setModal(true);
        setContentPane(contentPane);
        this.contentPane.setPreferredSize(new Dimension(500, 300));
        this.JPanel0.setPreferredSize(new Dimension(110, 290));
        this.JPanel1.setPreferredSize(new Dimension(110, 290));
        this.JPanel2.setPreferredSize(new Dimension(110, 290));
        this.setTitle("Company");

        DefaultListModel<Companies> companiesDefaultListModel = new DefaultListModel<>();
        DefaultListModel<Filials> filialsDefaultListModel = new DefaultListModel<>();
        DefaultListModel<Departments> departmentsDefaultListModel = new DefaultListModel<>();

        JMenu newMenu = new JMenu("Menu");
        SearchClass searchClass=new SearchClass();
        JMenuItem searchMenuItem = new SearchClass.SearchMenuItem();
        newMenu.add(searchMenuItem);
        JMenuItem clearSearchMenuItem = new SearchClass.ClearSearch();
        newMenu.add(clearSearchMenuItem);
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(newMenu);
        this.setJMenuBar(jMenuBar);

        searchMenuItem.addActionListener(e -> {
            DefaultListModel tempDefaultListModel = new DefaultListModel<>();
            HashSet<Companies> tempCompanies = searchClass.searchCompaniesByName(companyModel.getElements());
            for (Companies i : tempCompanies) {
                    tempDefaultListModel.addElement(i);
            }
            list1.setModel(tempDefaultListModel);
        });
        clearSearchMenuItem.addActionListener(e -> {
            list1.setModel(companiesDefaultListModel);
        });

        //Controller
        list1.setModel(companiesDefaultListModel);
        list2.setModel(filialsDefaultListModel);
        list3.setModel(departmentsDefaultListModel);


        loadCompaniesButton.addActionListener(e -> {
            companiesDefaultListModel.clear();
            for (Companies company : companyModel.getElements())
                companiesDefaultListModel.addElement(company);
        });

        removeCompanyButton.addActionListener(e -> {
            if (list1.getSelectedIndex() != -1) {
                companyModel.removeElement(companiesDefaultListModel.getElementAt(list1.getSelectedIndex()));
                companiesDefaultListModel.remove(list1.getSelectedIndex());
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                filialsDefaultListModel.clear();
                departmentsDefaultListModel.clear();
            }
        });

        list1.addListSelectionListener(e -> {
            if (list1.getSelectedIndex() != -1) {
                Companies selectedCompany = companiesDefaultListModel.getElementAt(list1.getSelectedIndex());
                textField1.setText(selectedCompany.getName());
                textField2.setText(selectedCompany.getFocusArea());
                textField3.setText(selectedCompany.getDirector().toString());

                filialsDefaultListModel.clear();
                for (Filials filial : selectedCompany.getFilials())
                    filialsDefaultListModel.addElement(filial);

                departmentsDefaultListModel.clear();
                for (Departments department : selectedCompany.getDepartments())
                    departmentsDefaultListModel.addElement(department);

            }
        });
        serializeCompaniesButton.addActionListener(e -> {
            for (int i = 0; i < companiesDefaultListModel.getSize(); i++)
                Serializer.store(companiesDefaultListModel.getElementAt(i));
        });

        addCompanyButton.addActionListener(e -> {
            CompanyViewAdd companyViewAdd = new CompanyViewAdd();
            companyViewAdd.pack();
            companyViewAdd.setVisible(true);

        });
    }


    public static void main(String[] args) {
        CompanyView companyView = new CompanyView();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.getMessage();
        }
        companyView.pack();
        companyView.setVisible(true);

        System.exit(0);
    }

}
