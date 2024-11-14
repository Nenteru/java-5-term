package com.example.lb2_javafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable  {
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker color;
    @FXML
    private TextField textF;
    ShapeFactory shapeFactory = new ShapeFactory();
    Shape shape = null;
    GraphicsContext gr;
    private boolean isDragging = false;
    private double dragOffsetX = 0;
    private double dragOffsetY = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gr = canvas.getGraphicsContext2D();
    }
    public void onMouseClick(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        gr.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        shape = shapeFactory.createShape(Integer.parseInt(textF.getText()), x, y);
        shape.setColor(color.getValue());
        shape.draw(gr);
        dragOffsetX = mouseEvent.getX() - shape.getX();
        dragOffsetY = mouseEvent.getY() - shape.getY();
    }
    public void OnClick() {
        if(shape != null){
            shape.setColor(color.getValue());
            shape.draw(gr);
        }
    }
    public void MouseDragged(MouseEvent mouseEvent) {
        if (shape != null) {
            isDragging = true;
            double newX = mouseEvent.getX() - dragOffsetX;
            double newY = mouseEvent.getY() - dragOffsetY;
            shape.setPosition(newX, newY);
            gr.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            shape.draw(gr);
        }
    }
    public void MouseReleased(MouseEvent mouseEvent) {
        if (isDragging) {
            isDragging = false;
            double newX = mouseEvent.getX() - dragOffsetX;
            double newY = mouseEvent.getY() - dragOffsetY;
            shape.setPosition(newX, newY);
            gr.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            shape.draw(gr);
        }
    }

}