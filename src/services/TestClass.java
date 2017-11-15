package services;

import model.filial.Filial;
import model.filial.Filials;
import model.building.Building;
import model.building.Buildings;
import model.company.Companies;
import model.company.Company;
import model.department.Department;
import model.department.Departments;
import model.employee.Employee;
import model.employee.Employees;

import java.util.ArrayList;
import java.util.HashSet;

public class TestClass {
    HashSet<Companies> companies = new HashSet<>();

    public TestClass() {
        Employees employee1 = new Employee("firstName1", "secondName1", "11-11-11", 1000);
        Employees employee2 = new Employee("firstName2", "secondName2", "22-22-22", 2000);
        Employees employee3 = new Employee("firstName3", "secondName3", "33-33-33", 3000);
        Employees employee4 = new Employee("firstName4", "secondName4", "44-44-44", 4000);
        Employees employeeD = new Employee("firstName0", "secondName0", "00-00-00", 10000);
        Employees employeeD1 = new Employee("firstName01", "secondName01", "01-01-01", 100000);

        Employees[] employees1 = {employee1, employee2, employeeD};
        Employees[] employees2 = {employee3, employee4, employeeD1};

        HashSet<Employees> empl1 = new HashSet<>();
        HashSet<Employees> empl2 = new HashSet<>();
        for (int i = 0; i < employees1.length; ++i) {
            empl1.add(employees1[i]);
            empl2.add(employees2[i]);
        }

        Departments department1 = new Department(empl1, "department1", employeeD);
        Departments department2 = new Department(empl2, "department2", employeeD1);
        Departments department3 = new Department(empl2, "department3", employee3);

        Buildings building1 = new Building("address1", 1, 1, empl1);
        Buildings building2 = new Building("address2", 2, 2, empl2);
        Buildings building3 = new Building("address3", 3, 3, empl2);


        HashSet<Buildings> buildings = new HashSet<>();
        buildings.add(building1);
        buildings.add(building2);
        Filials filial = new Filial("filial0", buildings);

        HashSet<Filials> filials = new HashSet<>();
        filials.add(filial);
        HashSet<Departments> departments = new HashSet<>();
        departments.add(department1);
        departments.add(department2);

        companies.add(new Company("Company0", "focusArea0", new Employee("firstName5", "secondName5", "55-55-55", 1200),
                filials, departments));
        buildings.add(building3);
        filials.add(new Filial("filial1", buildings));
        departments.add(department3);
        companies.add(new Company("Company1", "focusArea1", new Employee("firstName6", "secondName6", "66-66-66", 2200),
                filials, departments));

    }

    public HashSet<Companies> getCompanies() {
        return companies;
    }
    public void removeCompany(Companies company){
        companies.remove(company);
    }
    public void addCompany(Companies company){
        companies.add(company);
    }
}
