module org.example.clicker {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.clicker to javafx.fxml;
    exports org.example.clicker;
}