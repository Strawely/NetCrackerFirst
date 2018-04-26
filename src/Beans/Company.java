package Beans;

import javax.ejb.Local;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface Company {

    ResultSet getTable();

    ResultSet getSortedTable(int n);

    ResultSet getRecord(int id);

    ResultSet getSearchResult(int col, String expr);

    void addRecord(int directorID, String name, String focusArea);

    void changeRecord(int id, int directorID, String name, String focusArea);

    void removeByID(int id);

    int convertToXML(int id);

    int importFromXML(int id);

    ArrayList getXMLList();
}
