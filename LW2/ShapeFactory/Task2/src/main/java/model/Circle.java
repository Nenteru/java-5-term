package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Shape;

class Circle extends Shape {

    public Circle (double x, double y) {
        super(x,y);
        this.color=getColor();

    }

    public double area() {
        return 0;
    }

    public void draw (GraphicsContext gc)
    {
        gc.setStroke(color);

        double centerX = 200, centerY = 200, radius = 125;
        int numPoints = 100;

        double step = 2 * Math.PI / numPoints;
        for (int i = 0; i < numPoints; i++) {
            double angle = i * step;
            double x1 = centerX + radius * Math.cos(angle);
            double y1 = centerY + radius * Math.sin(angle);

            double nextAngle = (i + 1) * step;
            double x2 = centerX + radius * Math.cos(nextAngle);
            double y2 = centerY + radius * Math.sin(nextAngle);

            gc.strokeLine(x1, y1, x2, y2);
        }
    }

}