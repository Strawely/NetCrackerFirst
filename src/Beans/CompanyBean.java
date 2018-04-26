package Beans;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.ejb.Stateless;
import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.*;
import java.util.ArrayList;


@Stateless(name = "CompanyEJB")
public class CompanyBean implements Company {
    private Connection connection;
    private Statement statement;

    public CompanyBean() {
    }

    private DataSource getMysqlDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(3306);
        dataSource.setDatabaseName("NetCrackerFirst");
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setUseSSL(false);
        return dataSource;
    }

    private void connect() {
        try {
            connection = getMysqlDataSource().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(PreparedStatement preparedStatement) {
        try {
            if (connection != null) {
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ResultSet executeQuery(String sql) {
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet executeQuery(PreparedStatement preparedStatement) {
        try {
            if (connection != null) {
                return preparedStatement.executeQuery();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public ResultSet getTable() {
        try {
            connect();
            return executeQuery("SELECT * FROM Company");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getSortedTable(int n) {
        try {
            connect();
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
            PreparedStatement statement = connection.prepareStatement(sql);
            return executeQuery(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getRecord(int id) {
        try {
            connect();
            String sql = "SELECT * FROM Company WHERE ID = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            return executeQuery(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getSearchResult(int col, String expr) {
        try {
            connect();
            String sql;
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
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, expr);
                return executeQuery(statement);
            } else {
                sql = "SELECT * FROM Company";
                return executeQuery(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addRecord(int directorID, String name, String focusArea) {
        try {
            connect();
            String sql = "INSERT INTO Company (Director_ID,Name,FocusArea) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            if (directorID == -1)
                statement.setNull(1, directorID);
            else
                statement.setInt(1, directorID);
            statement.setString(2, name);
            statement.setString(3, focusArea);
            executeUpdate(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addRecord(int id, int directorID, String name, String focusArea) {
        try {
            connect();
            String sql = "INSERT INTO Company (ID,Director_ID,Name,FocusArea) VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            if (directorID == -1)
                statement.setNull(2, directorID);
            else
                statement.setInt(2, directorID);
            statement.setString(3, name);
            statement.setString(4, focusArea);
            executeUpdate(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeRecord(int id, int directorID, String name, String focusArea) {
        try {
            connect();
            String sql = "UPDATE Company SET Director_ID=?,Name=?,FocusArea=? WHERE ID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            if (directorID == -1)
                statement.setNull(1, directorID);
            else
                statement.setInt(1, directorID);
            statement.setString(2, name);
            statement.setString(3, focusArea);
            statement.setInt(4, id);
            executeUpdate(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeByID(int id) {
        try {
            connect();
            String sql = "DELETE FROM Company WHERE Company.ID = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            executeUpdate(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getXMLList() {
        File myFolder = new File("XML/Companies");
        File[] files = myFolder.listFiles();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++)
            list.add(files[i].getName());
        return list;
    }

    @Override
    public int importFromXML(int id) {
        try {
            if (getXMLList().contains(id + ".xml")) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new File("XML/Companies/" + id + ".xml"));
                int director_ID;
                String name, focusArea;
                Element company = ((Element) document.getElementsByTagName("Company").item(0));
                director_ID = Integer.parseInt(company.getElementsByTagName("Director_ID").item(0).getTextContent().equals("null") ?
                        "-1" : company.getElementsByTagName("Director_ID").item(0).getTextContent());
                name = company.getElementsByTagName("Name").item(0).getTextContent();
                focusArea = company.getElementsByTagName("FocusArea").item(0).getTextContent();
                addRecord(id, director_ID, name, focusArea);
            } else
                return -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int convertToXML(int id) {
        try {
            ResultSet rs = getRecord(id);
            ResultSetMetaData metaData;
            if (rs.next() && rs.isLast()) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.newDocument();
                String value;
                Element node;
                metaData = rs.getMetaData();
                Element row = doc.createElement("Company");
                doc.appendChild(row);
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    node = doc.createElement(metaData.getColumnName(i));
                    value = rs.getString(i);
                    node.appendChild(doc.createTextNode(value == null ? "null" : value));
                    row.appendChild(node);
                }
                DOMSource domSource = new DOMSource(doc);
                StreamResult out_stream = new StreamResult("XML/Companies/" + id + ".xml");
                TransformerFactory tFactory = TransformerFactory.newInstance();
                Transformer transformer = tFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
                        "yes");
                transformer.setOutputProperty(OutputKeys.INDENT,
                        "yes");
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                transformer.transform(domSource, out_stream);
            } else
                return -1; //if there is no row with that id
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
