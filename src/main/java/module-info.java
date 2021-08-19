module com.home.bookmanagmentapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;
    requires org.postgresql.jdbc;

    opens com.home.bookmanagmentapplication to javafx.fxml;
    exports com.home.bookmanagmentapplication;
}