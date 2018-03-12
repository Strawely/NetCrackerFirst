package database;


import java.io.PrintWriter;
import java.sql.*;

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
            String sql = "DELETE FROM Company WHERE Company.ID = ? ";
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            db.executeUpdate(statement);
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

    public ResultSet getSortedTable(int n) {
        try {
            db.connect();
            /*
            String sql = "SELECT * FROM Company ORDER BY ?";
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            switch (n){
                case 1:statement.setString(1,"ID");break;
                case 2:statement.setString(1,"Director_ID");break;
                case 3:statement.setString(1,"Name");break;
                case 4:statement.setString(1,"FocusArea");break;
            }*/

            String sql = "SELECT * FROM Company ORDER BY ";
            switch (n) {
                case 1:
                    sql += "ID";
                    break;
                case 2:
                    sql += "Director_ID";
                    break;
                case 3:
                    sql += "Name";
                    break;
                case 4:
                    sql += "FocusArea";
                    break;
            }
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            return db.executeQuery(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getRecord(int id) {
        try {
            db.connect();
            String sql = "SELECT * FROM Company WHERE ID = ? ";
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            return db.executeQuery(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getSearchResult(int col, String expr) {
        try {
            db.connect();
            String sql;
            //sql= "SELECT * FROM Company WHERE ? LIKE ?";
            if (!expr.equals("")) {
                switch (col) {
                    case 1:
                        sql = "SELECT * FROM Company WHERE ID LIKE ?";
                        break;
                    case 2:
                        sql = "SELECT * FROM Company WHERE Director_ID LIKE ?";
                        break;
                    case 3:
                        sql = "SELECT * FROM Company WHERE Name LIKE ?";
                        break;
                    case 4:
                        sql = "SELECT * FROM Company WHERE FocusArea LIKE ?";
                        break;
                    default:
                        sql = "SELECT * FROM Company WHERE ID LIKE ?";
                }
                PreparedStatement statement = db.getConnection().prepareStatement(sql);
                statement.setString(1, expr);
                return db.executeQuery(statement);
            } else {
                sql = "SELECT * FROM Company";
                return db.executeQuery(sql);
            }
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

    public void addRecord(int directorID, String name, String focusArea) {
        try {
            db.connect();
            String sql = "INSERT INTO Company (Director_ID,Name,FocusArea) VALUES (?,?,?)";
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            if (directorID == -1)
                statement.setNull(1, directorID);
            else
                statement.setInt(1, directorID);
            statement.setString(2, name);
            statement.setString(3, focusArea);
            db.executeUpdate(statement);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeRecord(int id, int directorID, String name, String focusArea) {
        try {
            db.connect();
            String sql = "UPDATE Company SET Director_ID=?,Name=?,FocusArea=? WHERE ID=?";
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            if (directorID == -1)
                statement.setNull(1, directorID);
            else
                statement.setInt(1, directorID);
            statement.setString(2, name);
            statement.setString(3, focusArea);
            statement.setInt(4, id);
            db.executeUpdate(statement);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
