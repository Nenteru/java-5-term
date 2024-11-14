package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Triangle extends Shape{

    public Triangle (double x, double y)
    {
        super(x,y);
        this.color=getColor();
    }
    public double area(){
        return 0;
    }

    public void draw (GraphicsContext gc)
    {
        gc.setStroke(color);
        gc.strokeLine(10, 10, 190, 190);
        gc.strokeLine(10, 10, 190, 10);
        gc.strokeLine(190, 10, 190, 190);

    }
}
