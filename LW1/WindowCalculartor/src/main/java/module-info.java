module org.example.windowcalculartor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.scripting;


    opens org.example.windowcalculartor to javafx.fxml;
    exports org.example.windowcalculartor;
}