package org.example.clicker;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Counter;

public class HelloController {

    Counter counter = new Counter();

    @FXML
    private Label welcomeText;

    @FXML
    protected void onButtonClickUp() {
        counter.Up();
        welcomeText.setText("Нажатий: " + String.valueOf(counter.getK()));
    }

    @FXML
    protected void onButtonClickDown() {
        counter.Down();
        welcomeText.setText("Нажатий: " + String.valueOf(counter.getK()));
    }
}