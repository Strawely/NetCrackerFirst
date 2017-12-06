package services;


import model.company.Companies;
import model.department.Departments;
import model.employee.Employees;

import javax.swing.*;
import java.util.HashSet;

public class SearchClass {

    public static class SearchMenuItem extends JMenuItem {
        public SearchMenuItem() {
            super("Search");
        }
    }

    public static class ClearSearch extends JMenuItem {
        public ClearSearch() {
            super("Clear search");
        }
    }


    public HashSet<Companies> searchCompaniesByName(HashSet<Companies> elements) {
        String searchCriteria = JOptionPane.showInputDialog("Введи критерий поиска");
        HashSet<Companies> searchResult = new HashSet<>();
        for (Companies element : elements) {
            if (element.getName().contains(searchCriteria))
                searchResult.add(element);
        }
        return searchResult;
    }

    public HashSet<Departments> searchDepartments(HashSet<Departments> elements) {
        String searchCriteria = JOptionPane.showInputDialog("Введи критерий поиска");
        HashSet<Departments> searchResult = new HashSet<>();
        for (Departments element : elements){
            if(element.getName().contains(searchCriteria))
                searchResult.add(element);
        }
        return searchResult;
    }
    public HashSet<Employees> searchEmployees(HashSet<Employees> elements) {
        String searchCriteria = JOptionPane.showInputDialog("Введи критерий поиска");
        HashSet<Employees> searchResult = new HashSet<>();
        for (Employees element : elements){
            if(element.getSecondName().contains(searchCriteria))
                searchResult.add(element);
        }
        return searchResult;
    }


}
