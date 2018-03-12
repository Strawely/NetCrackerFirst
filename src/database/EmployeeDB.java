package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Created by Админ on 26.02.2018.
 */
public class EmployeeDB
{
    private DBUtil db;

    public EmployeeDB()
    {
        db = new DBUtil();
    }

    public EmployeeDB(String userName, String pass, String connectionURL)
    {
        db = new DBUtil(userName, pass, connectionURL);
    }

    public void removeByID(int id) {
        try {
            db.connect();
            db.executeUpdate("DELETE FROM Employee WHERE Employee.ID = " + id);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getTable() {
        try {
            db.connect();
            return db.executeQuery("SELECT * FROM Employee");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printResult(ResultSet rs) {
        try {
            ResultSetMetaData data = rs.getMetaData();
            System.out.printf("%-4s%-12s%-12s%-12s%-12s%-10s", data.getColumnName(1), data.getColumnName(2), data.getColumnName(3),
                    data.getColumnName(4), data.getColumnName(5), data.getColumnName(6));
            System.out.println();
            while (rs.next()) {
                System.out.printf("%-4s%-12s%-12s%-12s%-12s%-10s", rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getRecord(int id) {
        try {
            //if (getTable().getMetaData().getColumnCount() < id)
            db.connect();
            return db.executeQuery("SELECT * FROM Employee WHERE Employee.ID = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeRecord(int id, String firstname, String secondname, String phonenumber, int salary, int id_department) {
        try {
            db.connect();
            db.executeUpdate("UPDATE Employee SET Firstname='" + firstname+
                    "', Secondname='" + secondname +
                    "', phonenumber='" + phonenumber +
                    "', salary = " + salary +
                    " , id_department = " + id_department +
                    " WHERE ID=" + id);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void newWith(int id, String firstname, String secondname, String phonenumber, int salary, int id_department)
    {
        try {
        db.connect();
        db.executeUpdate("INSERT INTO " +
                "Employee (ID, Fistname, Secondname, Phonenumber, Salary, id_department)" +
                " VALUES" +
                "(" + id + ", '" + firstname + "', '" + secondname + "', '"
                + phonenumber + "', " +  salary + "," +  id_department + ")");
        db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void newWith(int id, String firstname, String secondname, String phonenumber, int salary)
    {
        try {
            db.connect();
            db.executeUpdate("INSERT INTO " +
                    "Employee (ID, Fistname, Secondname, Phonenumber, Salary, id_department)" +
                    " VALUES" +
                    "(" + id + ", '" + firstname + "', '" + secondname + "', '"
                    + phonenumber + "', " +  salary + ", null )");
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        EmployeeDB employeeDB = new EmployeeDB("root", "123321", "jdbc:mysql://localhost:3306/NetCrackerFirst");
        employeeDB.newWith(6, "any", "potapova", "147", 14754);
        employeeDB.printResult(employeeDB.getRecord(6));
        employeeDB.removeByID(6);
    }
}
