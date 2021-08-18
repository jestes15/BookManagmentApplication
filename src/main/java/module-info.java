module com.home.bookmanagmentapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.home.bookmanagmentapplication to javafx.fxml;
    exports com.home.bookmanagmentapplication;
}