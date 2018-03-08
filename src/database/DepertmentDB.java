package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Created by Админ on 08.03.2018.
 */
public class DepertmentDB
{
    private DBUtil db;

    public DepertmentDB()
    {
        db = new DBUtil();
    }

    public DepertmentDB(String userName, String pass, String connectionURL)
    {
        db = new DBUtil(userName, pass, connectionURL);
    }

    public void removeByID(int id) {
        try {
            db.connect();
            db.executeUpdate("DELETE FROM department WHERE department.ID = " + id);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getTable() {
        try {
            db.connect();
            return db.executeQuery("SELECT * FROM department");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printResult(ResultSet rs) {
        try {
            ResultSetMetaData data = rs.getMetaData();
            System.out.printf("%-4s%-12s%-12s%-10s", data.getColumnName(1), data.getColumnName(2), data.getColumnName(3),
                    data.getColumnName(4));
            System.out.println();
            while (rs.next()) {
                System.out.printf("%-4s%-12s%-12s%-10s", rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4));
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
            return db.executeQuery("SELECT * FROM department WHERE department.ID = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeRecord(int id, String name, int id_director, int id_company) {
        try {
            db.connect();
            db.executeUpdate("UPDATE department SET name='" + name +
                    "', id_director="  + id_director +
                    " , id_company = " + id_company   +
                    " WHERE ID=" + id);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void changeRecord(int id, String name) {
        try {
            db.connect();
            db.executeUpdate("UPDATE department SET name='" + name +
                    "', id_director= null, id_company = null WHERE ID=" + id);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void newWith(int id, String name, int id_director, int id_company)
    {
        try {
            db.connect();
            db.executeUpdate("INSERT INTO " +
                    "Department (ID, name, id_director, id_company)" +
                    " VALUES" +
                    "(" + id + ", '" + name + "', " +
                    id_director  + ", " + id_company + ")");
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void newWith(int id, String name)
    {
        try {
            db.connect();
            db.executeUpdate("INSERT INTO " +
                    "Department (ID, name, id_director, id_company)" +
                    " VALUES" +
                    "(" + id + ", '" + name + "', null, null )");
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        DepertmentDB depertmentDB = new DepertmentDB("root", "123321", "jdbc:mysql://localhost:3306/NetCrackerFirst");
        depertmentDB.newWith(4, "name4", 1, 1);
        depertmentDB.printResult(depertmentDB.getRecord(4));
        depertmentDB.printResult(depertmentDB.getTable());
        depertmentDB.changeRecord(4, "name5");
        depertmentDB.printResult(depertmentDB.getRecord(4));
        depertmentDB.removeByID(4);
        depertmentDB.printResult(depertmentDB.getTable());
    }
}
