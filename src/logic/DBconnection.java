package logic;

import java.sql.*;

public class DBconnection {
    private Connection connection;
    private Statement statement;
    private String connectionUrl;

    public DBconnection() {
        connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=netflixdik;integratedSecurity=true;";
        connection = null;
        statement = null;
    }
//connect the database with localhost
    public void connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(connectionUrl);
        statement = connection.createStatement();
    }

    public void CloseConnection() throws SQLException {
        statement.close();
        connection.close();
    }

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }
}
