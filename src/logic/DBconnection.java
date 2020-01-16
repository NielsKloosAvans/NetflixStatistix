package logic;

import java.sql.*;

public class DBconnection {
    private Connection connection;
    private Statement statement;
    private String connectionUrl;

    public DBconnection() {
        connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Netflixstatistix1;integratedSecurity=true;";
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

    public ResultSet readQuery(String SQL) throws Exception {
        return this.statement.executeQuery(SQL);
    }


    public void queryExecute(String SQL) throws Exception {
        this.statement.execute(SQL);
    }

    public int updateQuery(String SQL) throws Exception {
        return this.statement.executeUpdate(SQL);
    }


    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }
}
