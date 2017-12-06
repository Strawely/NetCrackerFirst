package model.employee;

public class Employee implements Employees
{
    private String firstName, secondName, phoneNumber;
    private static String DEFAULT_FIRST_NAME = "", DEFAULT_SECOND_NAME = "", DEFAULT_PHONE_NUMBER = "";
    private static int DEFAULT_SALARY = 0;
    private int salary;

    public Employee() {
        this(DEFAULT_FIRST_NAME, DEFAULT_SECOND_NAME, DEFAULT_PHONE_NUMBER, DEFAULT_SALARY);
    }

    public Employee(String firstName, String secondName, String phoneNumber, int salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public Employee(Employees employees)
    {
        this.firstName = employees.getFirstName();
        this.secondName = employees.getSecondName();
        this.phoneNumber = employees.getPhoneNumber();
        this.salary = employees.getSalary();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return secondName;
    }

    @Override
    public int hashCode()
    {
        return firstName.hashCode() ^ secondName.hashCode() ^ phoneNumber.hashCode() ^ salary;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof  Employees)
        {
            Employees emp = (Employees) obj;
            return (firstName.equals(emp.getFirstName()) && secondName.equals(emp.getSecondName())
                    && phoneNumber.equals(emp.getPhoneNumber()) && salary == emp.getSalary());
        }
        return false;
    }
}
