package controller;

import model.CompanyService;
import model.ServiceInterface;
import model.SuperService;
import model.company.Companies;
import model.department.Departments;
import model.filial.Filials;
import services.SearchClass;
import services.Serializer;
import view.CompanyView;
import view.CompanyViewAdd;
import view.department.DepartmentView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class CompanyController implements ActionListener, ListSelectionListener {

    DefaultListModel<Companies> companiesDefaultListModel = new DefaultListModel<>();
    DefaultListModel<Filials> filialsDefaultListModel = new DefaultListModel<>();
    DefaultListModel<Departments> departmentsDefaultListModel = new DefaultListModel<>();
    SuperService superService = new SuperService();
    ServiceInterface<Companies> companyModel = superService.getCompanyService();


    CompanyView view;

    public CompanyController(CompanyView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();

        if (src == view.loadCompaniesButton) {
            companiesDefaultListModel.clear();
            String fileName = JOptionPane.showInputDialog("Имя файла");
            while (fileName==null || fileName.equals("")) {
                JOptionPane.showConfirmDialog(view, "Пустое имя файла");
                fileName = JOptionPane.showInputDialog("Имя файла");
            }
            superService = new SuperService(Serializer.loadAll(fileName));
            companyModel = superService.getCompanyService();
            for (Companies company : companyModel.getElements()){
                companiesDefaultListModel.addElement(company);
                }
            view.list1.setModel(companiesDefaultListModel);
        } else if (src == view.searchMenuItem) {
            DefaultListModel tempDefaultListModel = new DefaultListModel<>();
            HashSet<Companies> tempCompanies = view.searchClass.searchCompaniesByName(companyModel.getElements());
            for (Companies i : tempCompanies) {
                tempDefaultListModel.addElement(i);
            }
            view.list1.setModel(tempDefaultListModel);
        } else if (src == view.clearSearchMenuItem) {
            view.list1.setModel(companiesDefaultListModel);
        } else if (src == view.removeCompanyButton) {
            if (view.list1.getSelectedIndex() != -1) {
                companyModel.removeElement(companiesDefaultListModel.getElementAt(view.list1.getSelectedIndex()));
                companiesDefaultListModel.remove(view.list1.getSelectedIndex());
                view.textField1.setText("");
                view.textField2.setText("");
                view.textField3.setText("");
                filialsDefaultListModel.clear();
                departmentsDefaultListModel.clear();
            }
        } else if (src == view.addCompanyButton) {
            CompanyViewAdd companyViewAdd = new CompanyViewAdd();
            companyViewAdd.pack();
            companyViewAdd.setVisible(true);
            Companies newCompany=companyViewAdd.getNewCompany();
            companiesDefaultListModel.addElement(newCompany);
            companyModel.addElement(newCompany);
        } else if (src == view.departmentsButton) {
            DepartmentView departmentView;
            if (view.list1.getSelectedIndex() != -1) {
                departmentView = new DepartmentView(companiesDefaultListModel.getElementAt(view.list1.getSelectedIndex()).getDepartments());
                departmentView.setVisible(true);
            }
        } else if (src == view.removeFilialButton) {
            if (view.list2.getSelectedIndex() != -1) {
                int[] selectedIndices = view.list2.getSelectedIndices();
                int selectedCompanyIndex = view.list1.getSelectedIndex();
                for (int i = 0; i < selectedIndices.length; i++) {
                    companiesDefaultListModel.getElementAt(selectedCompanyIndex).removeFilial(filialsDefaultListModel.getElementAt(selectedIndices[i]));
                }
                view.list1.clearSelection();
                view.list1.setSelectedIndex(selectedCompanyIndex);
            }
        } else if (src == view.removeDepartmentButton) {
            if (view.list3.getSelectedIndex() != -1) {
                int[] selectedIndices = view.list3.getSelectedIndices();
                int selectedCompanyIndex = view.list1.getSelectedIndex();
                for (int i = 0; i < selectedIndices.length; i++) {
                    companiesDefaultListModel.getElementAt(selectedCompanyIndex).removeDepartment(departmentsDefaultListModel.getElementAt(selectedIndices[i]));
                }
                view.list1.clearSelection();
                view.list1.setSelectedIndex(selectedCompanyIndex);
            }
        } else if (src == view.exitButton) {
            System.exit(1);
        } else if (src == view.saveCompaniesButton) {
            String fileName = JOptionPane.showInputDialog("Имя файла");
            while (fileName.equals("")) {
                JOptionPane.showConfirmDialog(view, "Пустое имя файла");
                JOptionPane.showInputDialog("Имя файла");
            }
            Serializer.storeAll(superService, fileName);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (view.list1.getSelectedIndex() != -1) {
            Companies selectedCompany = companiesDefaultListModel.getElementAt(view.list1.getSelectedIndex());
            view.textField1.setText(selectedCompany.getName());
            view.textField2.setText(selectedCompany.getFocusArea());
            view.textField3.setText(selectedCompany.getDirector().toString());
            filialsDefaultListModel.clear();
            for (Filials filial : selectedCompany.getFilials())
                filialsDefaultListModel.addElement(filial);
            view.list2.setModel(filialsDefaultListModel);
            departmentsDefaultListModel.clear();
            for (Departments department : selectedCompany.getDepartments())
                departmentsDefaultListModel.addElement(department);
            view.list3.setModel(departmentsDefaultListModel);

        }
    }
}
