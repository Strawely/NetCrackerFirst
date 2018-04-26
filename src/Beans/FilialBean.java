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
import java.sql.*;
import java.util.*;
import java.util.Date;

@Stateless(name = "FilialEJB")
public class FilialBean implements Filial {
    private Connection connection;
    private Statement statement;

    public FilialBean() {
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


    private void executeUpdate(PreparedStatement preparedStatement) {
        try {
            connect();
            if (connection != null) {
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private ResultSet executeQuery(String sql) {
        try {
            connect();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private ResultSet executeQuery(PreparedStatement preparedStatement) {
        try {
            connect();
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
            return executeQuery("SELECT * FROM Filial");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getSortedTable(int n) {
        try {
            String sql = "SELECT * FROM Filial ORDER BY ";
            switch (n) {
                case 1:
                    sql += "ID";
                    break;
                case 2:
                    sql += "Company_ID";
                    break;
                case 3:
                    sql += "Name";
                    break;
                case 4:
                    sql+="Coordinates";
                    break;
                case 5:
                    sql+="StartOfWork";
                    break;
                case 6:
                    sql+="EndOfWork";
                    break;
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            return executeQuery(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getSearchResult(int col, String expr) {
        try {
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
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, expr);
                return executeQuery(statement);
            } else {
                sql = "SELECT * FROM Filial";
                return executeQuery(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getRecord(int id) {
        try {
            String sql = "SELECT * FROM Filial WHERE Filial.ID = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            return executeQuery(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeRecord(int id, int companyID, String name, String coordinates, String startOfWork, String endOfWork) {
        try {
            Time time = new Time(00-00-00);
            String sql = "UPDATE Filial SET Company_ID=?,Name=?,Coordinates=?,StartOfWork=?,EndOfWork=? WHERE ID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            if (companyID == -1)
                statement.setNull(1, companyID);
            else
                statement.setInt(1, companyID);
            statement.setString(2, name);
            if (coordinates.equals("") || coordinates.equals("null"))
                statement.setNull(3, 1);
            else
                statement.setString(3, coordinates);
            if (startOfWork.equals("") || startOfWork.equals("null"))
                statement.setNull(4, 1);
            else
                statement.setTime(4, time.valueOf(startOfWork));
            if (endOfWork.equals("") || endOfWork.equals("null"))
                statement.setNull(5, 1);
            else
                statement.setTime(5, time.valueOf(endOfWork));

            statement.setInt(6, id);
            executeUpdate(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addRecord(int companyID, String name, String coordinates, String startOfWork, String endOfWork) {
        try {
            Time time = new Time(00-00-00);

            String sql = "INSERT INTO Filial (Company_ID,Name,Coordinates,StartOfWork,EndOfWork) VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            if (companyID == -1)
                statement.setNull(1, companyID);
            else
                statement.setInt(1, companyID);
            statement.setString(2, name);
            if (coordinates.equals("") || coordinates.equals("null"))
                statement.setNull(3, 1);
            else
                statement.setString(3, coordinates);
            if (startOfWork.equals("") || startOfWork.equals("null"))
                statement.setNull(4, 1);
            else
                statement.setTime(4, time.valueOf(startOfWork));
            if (endOfWork.equals("") || endOfWork.equals("null"))
                statement.setNull(5, 1);
            else
                statement.setTime(5, time.valueOf(endOfWork));

            executeUpdate(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addRecord(int id, int companyID, String name) {
        try {
            String sql = "INSERT INTO Filial (ID,Company_ID,Name) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            if (companyID == -1)
                statement.setNull(2, companyID);
            else
                statement.setInt(2, companyID);
            statement.setString(3, name);
            executeUpdate(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeByID(int id) {
        try {
            String sql = "DELETE FROM Filial WHERE Filial.ID = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            executeUpdate(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getXMLList() {
        File myFolder = new File("XML/Filials");
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
                Document document = builder.parse(new File("XML/Filials/" + id + ".xml"));
                int company_ID;
                String name;
                Element filial = ((Element) document.getElementsByTagName("Filial").item(0));
                company_ID = Integer.parseInt(filial.getElementsByTagName("Company_ID").item(0).getTextContent().equals("null") ?
                        "-1" : filial.getElementsByTagName("Company_ID").item(0).getTextContent());
                name = filial.getElementsByTagName("Name").item(0).getTextContent();
                addRecord(id, company_ID, name);
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
                Element row = doc.createElement("Filial");
                doc.appendChild(row);
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    node = doc.createElement(metaData.getColumnName(i));
                    value = rs.getString(i);
                    node.appendChild(doc.createTextNode(value == null ? "null" : value));
                    row.appendChild(node);
                }
                DOMSource domSource = new DOMSource(doc);
                StreamResult out_stream = new StreamResult("XML/Filials/" + id + ".xml");
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
