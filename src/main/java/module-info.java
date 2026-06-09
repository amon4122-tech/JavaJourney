module com.example.personalassistant {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.personalassistant to javafx.fxml;
    exports com.example.personalassistant;
}