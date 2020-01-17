module NetflixStatistix {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;

    opens UI.LogIn;
}