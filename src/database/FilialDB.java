package database;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class FilialDB {
    DBUtil db;

    public FilialDB() {
        db = new DBUtil();
    }

    public FilialDB(String userName, String pass, String connectionURL) {
        db = new DBUtil(userName, pass, connectionURL);
    }

    public void removeByID(int id) {
        try {
            db.connect();
            String sql = "DELETE FROM Filial WHERE Filial.ID = ? ";
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
            return db.executeQuery("SELECT * FROM Filial");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet getSortedTable(int n) {
        try {
            db.connect();
            String sql = "SELECT * FROM Filial ORDER BY ";
            switch(n){
                case 1:sql+="ID";break;
                case 2:sql+="Company_ID";break;
                case 3:sql+="Name";break;
            }
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            return db.executeQuery(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printResult(ResultSet rs) {
        try {
            ResultSetMetaData data = rs.getMetaData();
            System.out.printf("%-4s%-15s%-10s", data.getColumnName(1), data.getColumnName(2), data.getColumnName(3));
            System.out.println();
            while (rs.next()) {
                System.out.printf("%-4s%-15s%-10s", rs.getString(1), rs.getString(2), rs.getString(3));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getSearchResult(int col, String expr) {
        try {
            db.connect();
            String sql;
            //sql= "SELECT * FROM Filial WHERE ? LIKE ?";
            if (!expr.equals("")) {
                switch (col) {
                    case 1:
                        sql = "SELECT * FROM Filial WHERE ID LIKE ?";
                        break;
                    case 2:
                        sql = "SELECT * FROM Filial  WHERE Company_ID LIKE ?";
                        break;
                    case 3:
                        sql = "SELECT * FROM Filial  WHERE Name LIKE ?";
                        break;
                    default:
                        sql = "SELECT * FROM Filial  WHERE ID LIKE ?";
                }
                PreparedStatement statement = db.getConnection().prepareStatement(sql);
                statement.setString(1, expr);
                return db.executeQuery(statement);
            } else {
                sql = "SELECT * FROM Filial";
                return db.executeQuery(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getRecord(int id) {
        try {
            db.connect();
            String sql = "SELECT * FROM Filial WHERE Filial.ID = ? ";
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            return db.executeQuery(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeRecord(int id, int companyID, String name) {
        try {
            db.connect();
            String sql = "UPDATE Filial SET Company_ID=?,Name=? WHERE ID=?";
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            if (companyID == -1)
                statement.setNull(1, companyID);
            else
                statement.setInt(1, companyID);
            statement.setString(2, name);
            statement.setInt(3, id);
            db.executeUpdate(statement);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }  public void addRecord(int companyID, String name) {
        try {
            db.connect();
            String sql = "INSERT INTO Filial (Company_ID,Name) VALUES (?,?)";
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            if (companyID == -1)
                statement.setNull(1, companyID);
            else
                statement.setInt(1, companyID);
            statement.setString(2, name);
            db.executeUpdate(statement);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {

/*
        FilialDB filialDB = new FilialDB();


        filialDB.changeRecord(2, 3, "Sony M");
        filialDB.printResult(filialDB.getRecord(222));

        System.out.println();

        filialDB.changeRecord(2, 1, "Sony N");
        filialDB.printResult(filialDB.getTable());
        System.out.println();

        CompanyDB companyDB = new CompanyDB("root", "123321", "jdbc:mysql://localhost:3306/NetCrackerFirst");

      //  companyDB.changeRecord("4", "1", "Linux", "Sweden");
        //companyDB.printResult(companyDB.getTable());

        System.out.println();

      //  companyDB.changeRecord("4", "3", "Linux", "England");
        //companyDB.printResult(companyDB.getRecord(4));*/
    }
}
