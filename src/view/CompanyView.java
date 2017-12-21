package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import model.ServiceInterface;
import model.SuperService;
import model.company.Companies;
import model.department.Departments;
import model.filial.Filials;
import services.SearchClass;
import services.Serializer;
import model.CompanyService;
import view.department.DepartmentView;
import view.department.TableEmployee;

public class CompanyView extends JDialog {
    private JPanel contentPane;
    private JTextField textField1;
    private JTextField textField2;
    private JButton loadCompaniesButton;
    private JButton departmentsButton;
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
    private JButton saveCompaniesButton;
    private JButton removeFilialButton;
    private JButton removeDepartmentButton;
    private JButton exitButton;

   // ServiceInterface<Companies> companyModel1 = new CompanyService();
    SuperService superService = new SuperService();
    ServiceInterface<Companies> companyModel = superService.getCompanyService();
    //  CompanyController companyController;


    public CompanyView(/*CompanyService companyModel,CompanyController companyController*/) {
        /*this.companyModel = companyModel;
        this.companyController = companyController;*/
        setModal(false);
        setContentPane(contentPane);
        this.contentPane.setPreferredSize(new Dimension(500, 300));
        this.JPanel0.setPreferredSize(new Dimension(110, 290));
        this.JPanel1.setPreferredSize(new Dimension(110, 290));
        this.JPanel2.setPreferredSize(new Dimension(110, 290));
        this.setTitle("Company");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        DefaultListModel<Companies> companiesDefaultListModel = new DefaultListModel<>();
        DefaultListModel<Filials> filialsDefaultListModel = new DefaultListModel<>();
        DefaultListModel<Departments> departmentsDefaultListModel = new DefaultListModel<>();

        JMenu newMenu = new JMenu("Menu");
        SearchClass searchClass = new SearchClass();
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
            superService=new SuperService(Serializer.loadAll(JOptionPane.showInputDialog("Имя файла")));
            companyModel=superService.getCompanyService();
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
        addCompanyButton.addActionListener(e -> {
            CompanyViewAdd companyViewAdd = new CompanyViewAdd();
            companyViewAdd.pack();
            companyViewAdd.setVisible(true);
            companiesDefaultListModel.addElement(companyViewAdd.getNewCompany());

        });
        departmentsButton.addActionListener(e -> {
            DepartmentView departmentView;
            if (list1.getSelectedIndex() != -1) {
                departmentView = new DepartmentView(companiesDefaultListModel.getElementAt(list1.getSelectedIndex()).getDepartments());
                departmentView.setVisible(true);

            }
        });
        removeFilialButton.addActionListener(e -> {
            if (list2.getSelectedIndex() != -1) {
                int[] selectedIndices = list2.getSelectedIndices();
                int selectedCompanyIndex = list1.getSelectedIndex();
                for (int i = 0; i < selectedIndices.length; i++) {
                    companiesDefaultListModel.getElementAt(selectedCompanyIndex).removeFilial(filialsDefaultListModel.getElementAt(selectedIndices[i]));
                }
                list1.clearSelection();
                list1.setSelectedIndex(selectedCompanyIndex);
            }
        });
        removeDepartmentButton.addActionListener(e -> {
            if (list3.getSelectedIndex() != -1) {
                int[] selectedIndices = list3.getSelectedIndices();
                int selectedCompanyIndex = list1.getSelectedIndex();
                for (int i = 0; i < selectedIndices.length; i++) {
                    companiesDefaultListModel.getElementAt(selectedCompanyIndex).removeDepartment(departmentsDefaultListModel.getElementAt(selectedIndices[i]));
                }
                list1.clearSelection();
                list1.setSelectedIndex(selectedCompanyIndex);
            }
        });
        exitButton.addActionListener(e -> System.exit(1));
        saveCompaniesButton.addActionListener(e -> Serializer.storeAll(superService,JOptionPane.showInputDialog("Имя файла")));
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
        //System.exit(0);
    }

}
