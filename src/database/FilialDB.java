package database;


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
        db.connect();
        db.executeUpdate("DELETE FROM Filial WHERE Filial.ID = " + id);
        db.disconnect();
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

    public ResultSet getRecord(int id) {
        try {
            //if (getTable().getMetaData().getColumnCount() < id)
            db.connect();
            return db.executeQuery("SELECT * FROM Filial WHERE Filial.ID = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeRecord(int id, int companyID, String name) {
        try {
            db.connect();
            db.executeUpdate("UPDATE Filial SET Company_ID='" + companyID+
                    "',Name='" + name +
                    "' WHERE ID=" + id);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {

        FilialDB filialDB = new FilialDB("root", "123321", "jdbc:mysql://localhost:3306/NetCrackerFirst");

        filialDB.changeRecord(2,3,"Sony M");
        filialDB.printResult(filialDB.getRecord(222));

        System.out.println();

        filialDB.changeRecord(2,1,"Sony N");
        filialDB.printResult(filialDB.getTable());
        System.out.println();

        CompanyDB companyDB = new CompanyDB("root", "123321", "jdbc:mysql://localhost:3306/NetCrackerFirst");

        companyDB.changeRecord(4, 1, "Linux", "Sweden");
        companyDB.printResult(companyDB.getTable());

        System.out.println();

        companyDB.changeRecord(4, 3, "Linux", "England");
        companyDB.printResult(companyDB.getRecord(4));
    }
}
