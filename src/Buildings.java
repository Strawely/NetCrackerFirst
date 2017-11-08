/**
 * Created by Админ on 07.11.2017.
 */
public interface Buildings
{
    void setAddress(String address);
    String getAddress();
    void setCoordinates(double x, double y);
    double getCoordinatesX();
    double getCoordinatesY();
    void setEmployees(Employees[] employees);
    Employees[] getEmployees();
    Employees getEmployeeByName(String fname, String sname);
    Employees getEmployeeByPhone(String phone);
    Employees[] getEmployeeBySalary(int salary);
    void addEmployee(Employees employee);
    void removeEmployee(Employees employee);
    boolean setEmployeeByName(String fname, String sname, Employees employee);
    boolean setEmployeeByPhone(String phone, Employees employee);

}
