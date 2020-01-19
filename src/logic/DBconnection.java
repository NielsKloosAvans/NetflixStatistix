package logic;

import java.sql.*;

public class DBconnection {
    private Connection connection;
    private Statement statement;
    private String connectionUrl;

    public DBconnection() {
        connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Netflix;user=sa;password=Dockersql123;";
        connection = null;
        statement = null;
    }

    //connect the database with localhost
    public void connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(connectionUrl);
        statement = connection.createStatement();
    }

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }
}
