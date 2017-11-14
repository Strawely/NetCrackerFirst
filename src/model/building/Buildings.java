package model.building;

import model.employee.Employees;

import java.util.Collection;


public interface Buildings
{
    void setAddress(String address);
    String getAddress();
    void setCoordinatesX(double x);
    void setCoordinatesY(double y);
    double getCoordinatesX();
    double getCoordinatesY();
    void setEmployees(Collection<Employees> employees);
    Collection<Employees> getEmployees();
    Employees getEmployeeByName(String fname, String sname);
    Employees getEmployeeByPhone(String phone);
    Collection<Employees> getEmployeeBySalary(int salary);
    void addEmployee(Employees employee);
    void removeEmployee(Employees employee);
    boolean setEmployeeByName(String fname, String sname, Employees employee);
    boolean setEmployeeByPhone(String phone, Employees employee);
    int getCountEmployees();
}
