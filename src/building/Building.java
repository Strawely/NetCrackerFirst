package building;

import employee.Employees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Админ on 07.11.2017.
 */
public class Building implements Buildings
{
    private String address;
    private double coordinatesX, coordinatesY;
    private HashSet<Employees> employees;

    public Building(String address, double coordinatesX, double coordinatesY, Collection<Employees> employees) {
        this.address = address;
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.employees = new HashSet<>(employees);
    }

    public Building(String address, double coordinatesX, double coordinatesY)
    {
        this.address = address;
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.employees = new HashSet<>();
    }

    public Building()
    {
        this.address = "";
        this.coordinatesX = 0;
        this.coordinatesY = 0;
        this.employees = new HashSet<Employees>();
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }


    @Override
    public void setCoordinatesX(double x) {
        this.coordinatesX = x;
    }

    @Override
    public void setCoordinatesY(double y)
    {
        this.coordinatesY = y;
    }

    @Override
    public double getCoordinatesX() {
        return coordinatesX;
    }

    @Override
    public double getCoordinatesY() {
        return coordinatesY;
    }


    public void setEmployees(Collection<Employees> employees) {
        this.employees = new HashSet<Employees>(employees);
    }

    public Collection<Employees> getEmployees() {

        return  employees;
    }

    @Override
    public Employees getEmployeeByName(String fname, String sname) {
        for (Employees employee1 : employees) {
            if (fname.equals(employee1.getFirstName()) && sname.equals(employee1.getSecondName())) {
                return employee1;
            }
        }
        return null;
    }

    @Override
    public Employees getEmployeeByPhone(String phone) {
        for (Employees employee1 : employees) {
            if (phone.equals(employee1.getPhoneNumber())) {
                return employee1;
            }
        }
        return null;
    }

    @Override
    public Collection<Employees> getEmployeeBySalary(int salary) {
        ArrayList<Employees> employees = new ArrayList<Employees>();
        for (Employees employees1 : this.employees) {
            if (salary == employees1.getSalary()) {
                employees.add(employees1);
            }
        }
        if (employees.size() == 0) {
            return null;
        }
        return employees;
    }

    @Override
    public void addEmployee(Employees employee) {
        this.employees.add(employee);
    }

    @Override
    public void removeEmployee(Employees employee) {
        this.employees.remove(employee);
    }

    @Override
    public boolean setEmployeeByName(String fname, String sname, Employees employee) {
        for (Employees employee1 : this.employees) {
            if (fname.equals(employee1.getFirstName()) && sname.equals(employee1.getSecondName())) {
                this.employees.remove(employee1);
                this.employees.add(employee);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setEmployeeByPhone(String phone, Employees employee) {
        for (Employees employee1 : this.employees) {
            if (phone.equals(employee1.getPhoneNumber())) {
                this.employees.remove(employee1);
                this.employees.add(employee);
                return true;
            }
        }
        return false;
    }

    @Override
    public int getCountEmployees()
    {
        return this.employees.size();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder().append("building.Building: {").append( address)
                .append(" [").append( coordinatesX).append( ";").append(coordinatesY).append("]\n");
        for (Employees employees : this.employees) {
            s.append(employees.toString()).append("\n");
        }
        s.append("}");
        return s.toString();
    }
}
