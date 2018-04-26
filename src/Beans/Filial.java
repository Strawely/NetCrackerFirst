package Beans;

import javax.ejb.Local;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface Filial {

    ResultSet getTable();

    ResultSet getSortedTable(int n);

    ResultSet getRecord(int id);

    ResultSet getSearchResult(int col, String expr);

    void addRecord(int companyID, String name, String coordinates, String startOfWork, String endOfWork);

    void changeRecord(int id, int companyID, String name, String coordinates, String startOfWork, String endOfWork);

    void removeByID(int id);

    int importFromXML(int id);

    int convertToXML(int id);

    ArrayList getXMLList();
}
