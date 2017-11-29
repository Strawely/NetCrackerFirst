package model;

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

import java.util.*;

public class CompanyModel implements CompanyModelInterface {
    HashSet<Companies> companies = new HashSet<>();
//    HashSet<Filials> filials = new HashSet<>();
//    HashSet<Buildings> buildings = new HashSet<>();
//    HashSet<Departments> departments = new HashSet<>();


    public CompanyModel() {
        Employees employee1 = new Employee("firstName1", "secondName1", "11-11-11", 1000);
        Employees employee2 = new Employee("firstName2", "secondName2", "22-22-22", 2000);
        Employees employee3 = new Employee("firstName3", "secondName3", "33-33-33", 3000);
        Employees employee4 = new Employee("firstName4", "secondName4", "44-44-44", 4000);
        Employees employee5 = new Employee("firstName5", "secondName5", "55-55-55", 5000);
        Employees employee6 = new Employee("firstName6", "secondName6", "66-66-66", 6000);
        Employees employeeD = new Employee("firstName0", "secondName0", "00-00-00", 10000);
        Employees employeeD1 = new Employee("firstName01", "secondName01", "01-01-01", 100000);

        HashSet<Employees> employees1 = new HashSet<>();
        employees1.add(employee1);
        employees1.add(employee2);

        HashSet<Employees> employees2 = new HashSet<>();
        employees2.add(employee3);
        employees2.add(employee4);

        HashSet<Employees> employees3 = new HashSet<>();
        employees2.add(employee5);
        employees2.add(employee6);


//        Map<String, Collection<Departments>> departmentsByCompany = new HashMap<>();
//        departmentsByCompany = fillDepartmentsByCompany(departmentsByCompany);

        Departments department1 = new Department(employees1, "department1", employeeD);
        Departments department2 = new Department(employees2, "department2", employeeD1);
        Departments department3 = new Department(employees3, "department3", employee3);

        HashSet<Departments> departments1 = new HashSet<>();
        departments1.add(department1);
        departments1.add(department2);
        departments1.add(department3);

        HashSet<Departments> departments2 = new HashSet<>();
        departments2.add(department1);
        departments2.add(department2);
        Buildings building1 = new Building("address1", 1, 1, employees1);
        Buildings building2 = new Building("address2", 2, 2, employees2);
        Buildings building3 = new Building("address3", 3, 3, employees3);

        HashSet<Buildings> buildings = new HashSet<>();
        buildings.add(building1);
        buildings.add(building2);
        buildings.add(building3);


        Filials filial1 = new Filial("filial1", buildings);
        Filials filial2 = new Filial("filial2", buildings);
        HashSet<Filials> filials1 = new HashSet<>();
        filials1.add(filial1);

        HashSet<Filials> filials2 = new HashSet<>();
        filials2.add(filial1);
        filials2.add(filial2);

        Companies company1 = new Company("Oracle", "focusArea1", employeeD, filials1, departments1); //departmentsByCompany.get("Oracle"));
        Companies company2=new Company("Microsoft", "focusArea2", employeeD, filials2, departments2); //departmentsByCompany.get("Microsoft"));
        companies.add(company1);
        companies.add(company2);
    }

    public HashSet<Companies> getCompanies() {
        return companies;
    }

    public void removeCompany(Companies company) {
        companies.remove(company);
    }

    public void addCompany(Companies company) {
        companies.add(company);
    }


  /*  private HashSet<Employees> filledEmployees(Employees[] employees){
        HashSet<Employees> employeesHashSet=new HashSet<>();
        for (Employees i:employees) {
            employeesHashSet.add(i);
        }
        return employeesHashSet;

    }*/
    /*private Map<String, Collection<Departments>> fillDepartmentsByCompany(Map<String, Collection<Departments>> departmentsByCompany) {
        Departments department1 = new Department(employees1, "department1", employeeD);
        Departments department2 = new Department(employees2, "department2", employeeD1);
        Departments department3 = new Department(employees3, "department3", employee3);

        HashSet<Departments> departments1 = new HashSet<>();
        departments1.add(department1);
        departments1.add(department2);
        departments1.add(department3);

        HashSet<Departments> departments2 = new HashSet<>();
        departments2.add(department1);
        departments2.add(department2);
        departmentsByCompany.put("Oracle", departments1);
        departmentsByCompany.put("Microsoft", departments2);
        return departmentsByCompany;
    }*/

    /*private HashSet<Buildings> filledBuildings(HashSet<Buildings> buildings) {
        return new HashSet<>(buildings);
    }

    private HashSet<Filials> filledFilials(HashSet<Filials> filials) {
        return new HashSet<>(filials);
    }

    private void fillCompanies(HashSet<Buildings> buildings, HashSet<Filials> filials) {

    }*/
}
