package view;

import javax.swing.*;
import java.awt.*;


import controller.CompanyController;


import controller.DepatrmentController;
import model.ServiceInterface;
import model.SuperService;
import model.company.Companies;
import model.department.Departments;
import model.filial.Filials;
import model.modl.ModelDepartment;

import services.SearchClass;

public class CompanyView extends JDialog {
    public JPanel contentPane;
    public JTextField textField1;
    public JTextField textField2;
    public JButton loadCompaniesButton;
    public JButton departmentsButton;
    public JTextField textField3;
    public JButton buttonOK;
    public JButton buttonCancel;
    public JList list1;
    public JButton removeCompanyButton;
    public JButton addCompanyButton;
    public JButton serializeCompaniesButton;
    public JList list2;
    public JList list3;
    public JPanel JPanel1;
    public JPanel JPanel0;
    public JPanel JPanel2;
    public JButton saveCompaniesButton;
    public JButton removeFilialButton;
    public JButton removeDepartmentButton;
    public JButton exitButton;
    public JMenuItem searchMenuItem;
    public SearchClass searchClass;
    public JMenuItem clearSearchMenuItem;
    // ServiceInterface<Companies> companyModel1 = new CompanyService();
   // SuperService superService = new SuperService();
   // ServiceInterface<Companies> companyModel = superService.getCompanyService();
    //  CompanyController companyController;


    public CompanyView(/*CompanyService companyModel,CompanyController companyController*/) {
        /*this.companyModel = companyModel;
        this.companyController = companyController;*/
        setModal(false);
        setContentPane(contentPane);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.contentPane.setPreferredSize(new Dimension(500, 300));
        this.JPanel0.setPreferredSize(new Dimension(110, 290));
        this.JPanel1.setPreferredSize(new Dimension(110, 290));
        this.JPanel2.setPreferredSize(new Dimension(110, 290));
        this.setTitle("Company");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

     //   DefaultListModel<Companies> companiesDefaultListModel = new DefaultListModel<>();
     //   DefaultListModel<Filials> filialsDefaultListModel = new DefaultListModel<>();
     //   DefaultListModel<Departments> departmentsDefaultListModel = new DefaultListModel<>();

        JMenu newMenu = new JMenu("Menu");
        searchClass = new SearchClass();
        searchMenuItem = new SearchClass.SearchMenuItem();
        newMenu.add(searchMenuItem);
        clearSearchMenuItem = new SearchClass.ClearSearch();
        newMenu.add(clearSearchMenuItem);
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(newMenu);
        this.setJMenuBar(jMenuBar);

        CompanyController controller=new CompanyController(this);

        loadCompaniesButton.addActionListener(controller);
        searchMenuItem.addActionListener(controller);
        clearSearchMenuItem.addActionListener(controller);
        removeCompanyButton.addActionListener(controller);
        addCompanyButton.addActionListener(controller);
        exitButton.addActionListener(controller);
        list1.addListSelectionListener(controller);
        departmentsButton.addActionListener(controller);
        removeFilialButton.addActionListener(controller);
        removeDepartmentButton.addActionListener(controller);
        saveCompaniesButton.addActionListener(controller);


        /*searchMenuItem.addActionListener(e -> {
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
            for (Companies employee : companyModel.getElements())
                companiesDefaultListModel.addElement(employee);
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
                for (Filials department : selectedCompany.getFilials())
                    filialsDefaultListModel.addElement(department);

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
                ModelDepartment modelDepartment = new ModelDepartment(companiesDefaultListModel.getElementAt(list1.getSelectedIndex()).getDepartments());
                DepatrmentController depatrmentController = new DepatrmentController(modelDepartment);
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
        saveCompaniesButton.addActionListener(e -> Serializer.storeAll(superService,JOptionPane.showInputDialog("Имя файла")));*/
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
