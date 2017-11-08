/**
 * Created by Админ on 07.11.2017.
 */
public interface Departments
{
    Employees[] getEmployees();

    public void setEmployees(Employees[] employees);

    public String getName();

    public void setName(String name);

    public Employees getDirector();

    public void setDirector(Employees director);
}
