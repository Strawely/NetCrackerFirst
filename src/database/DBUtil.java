package database;


import java.io.DataInputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private Connection connection;
    private Statement statement;
    private String userName;
    private String pass;
    private String connectionUrl;
    private Properties properties;

    public DBUtil() {
        userName = "root";
        pass = "";
        connectionUrl = "jdbc:mysql://localhost:3306/NetCrackerFirst";
    }

    public DBUtil(String userName, String pass, String connectionUrl) {
        this.userName = userName;
        this.pass = pass;
        this.connectionUrl = connectionUrl;
    }

    public void connect() {
        try {
            properties = new Properties();
            properties.setProperty("user", userName);
            properties.setProperty("password", pass);
            properties.setProperty("useSSL", "false");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionUrl, properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(String sql) {
        try {
            if (connection != null) {
                statement = connection.createStatement();
                statement.executeUpdate(sql);
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement.getConnection() == connection && connection != null) {
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection() {
        return connection;
    }


    public ResultSet executeQuery(String sql) {
        try {
            if (connection != null) {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                //statement.close();
                return resultSet;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet executeQuery(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement.getConnection() == connection && connection != null) {
                return preparedStatement.executeQuery();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void disconnect() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }


}
