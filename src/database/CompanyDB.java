package database;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class CompanyDB {
    DBUtil db;

    public CompanyDB() {
        db = new DBUtil();
    }

    public CompanyDB(String userName, String pass, String connectionURL) {
        db = new DBUtil(userName, pass, connectionURL);
    }

    public void removeByID(int id) {
        try {
            db.connect();
            db.executeUpdate("DELETE FROM Company WHERE Company.ID = " + id);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getTable() {
        try {
            db.connect();
            return db.executeQuery("SELECT * FROM Company");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getRecord(int id) {
        try {
            db.connect();
            return db.executeQuery("SELECT * FROM Company WHERE Company.ID = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void printResult(ResultSet rs) {
        try {
            ResultSetMetaData data = rs.getMetaData();
            System.out.printf("%-4s%-12s%-15s%-10s", data.getColumnName(1), data.getColumnName(2), data.getColumnName(3), data.getColumnName(4));
            System.out.println();
            while (rs.next()) {
                System.out.printf("%-4s%-12s%-15s%-10s", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeRecord(int id, int directorID, String name, String focusArea) {
        try {
            db.connect();
            db.executeUpdate("UPDATE Company SET Director_ID='" + directorID +
                    "',Name='" + name +
                    "',FocusArea='" + focusArea +
                    "' WHERE ID=" + id);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
