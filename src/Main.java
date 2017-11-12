import filial.Filial;
import filial.Filials;
import building.Building;
import building.Buildings;
import company.Companies;
import company.Company;
import department.Department;
import department.Departments;
import employee.Employee;
import employee.Employees;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Employees employee1 = new Employee("firstName1", "secondName1", "11-11-11", 1000);
        Employees employee2 = new Employee("firstName2", "secondName2", "22-22-22", 2000);
        Employees employee3 = new Employee("firstName3", "secondName3", "33-33-33", 3000);
        Employees employee4 = new Employee("firstName4", "secondName4", "44-44-44", 4000);
        Employees employeeD = new Employee("firstName0", "secondName0", "00-00-00", 10000);
        Employees employeeD1 = new Employee("firstName01", "secondName01", "01-01-01", 100000);

        Employees[] employees1 = {employee1, employee2, employeeD};
        Employees[] employees2 = {employee3, employee4, employeeD1};

        ArrayList<Employees> empl1 = new ArrayList<>();
        ArrayList<Employees> empl2 = new ArrayList<>();
        for (int i = 0; i < employees1.length; ++i)
        {
            empl1.add(employees1[i]);
            empl2.add(employees2[i]);
        }

        Departments department1 = new Department(empl1, "department1", employeeD);
        Departments department2 = new Department(empl2, "department2", employeeD1);

        Buildings building1 = new Building("address1", 1, 1, empl1);
        Buildings building2 = new Building("address2", 2, 2, empl2);

        ArrayList<Buildings> buildings = new ArrayList<>();
        buildings.add(building1);
        buildings.add(building2);
        Filials branch1=new Filial("branch1",buildings);

        ArrayList<Filials> branches = new ArrayList<>();
        branches.add(branch1);
        ArrayList<Departments> departments = new ArrayList<>();
        departments.add(department1);
        departments.add(department2);

        Companies company = new Company("Company0", "focusArea0", new Employee("firstName5", "secondName5", "55-55-55", 1200),
                branches, departments);

        System.out.println(company);


    }
}
