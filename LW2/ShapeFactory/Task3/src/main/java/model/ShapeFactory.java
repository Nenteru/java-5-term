package model;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ShapeFactory  {
    public Shape createShape(int num,double x, double y){
        if(num==1){
            return new Circle(x, y);
        } else if (num==2) {
            return new Line(x,y,200,45);
        } else if (num==3) {
            return new Triangle(x, y);
        }else if (num==4){
            return new Rectangle(x,y,200, 45);
        } else if (num==5){
            return new Hexagon(x,y);
        }else {
            return null;
        }
    }
}
