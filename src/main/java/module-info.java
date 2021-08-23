module com.home.bookmanagementapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires org.jetbrains.annotations;
    requires org.apache.commons.codec;

    opens com.home.bookmanagementapplication to javafx.fxml;
    exports com.home.bookmanagementapplication;
}