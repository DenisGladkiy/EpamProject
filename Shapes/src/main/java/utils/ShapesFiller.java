package utils;

import model.Model;
import model.entity.Circle;
import model.entity.Rectangle;
import model.entity.Triangle;
import java.util.Random;

/**
 * Created by Denis on 08.03.2018.
 */
public class ShapesFiller {
    Random random;
    Model model;
    String color;
    String[] colors = {"red", "green", "blue", "yellow"};

    public ShapesFiller(Model model){
        this.model = model;
        random = new Random();
    }

    public void fillShapes(){
        addCircles(4);
        addRectangle(4);
        addTriangle(4);
    }

    private void addCircles(int circlesNumber){
        int radius;
        for(int i = 0; i < circlesNumber; i++){
            color = colors[random.nextInt(3)];
            radius = 1 + random.nextInt(9);
            model.addShape(new Circle(color, radius));
        }
    }

    private void addRectangle(int rectangleNumber){
        int length;
        int width;
        for(int i = 0; i < rectangleNumber; i++){
            color = colors[random.nextInt(3)];
            length = 1 + random.nextInt(9);
            width = 1 + random.nextInt(9);
            model.addShape(new Rectangle(color, length, width));
        }
    }

    private void addTriangle(int triangleNumber){
        int width;
        int height;
        for(int i = 0; i < triangleNumber; i++){
            color = colors[random.nextInt(3)];
            width = 1 + random.nextInt(9);
            height = 1 + random.nextInt(9);
            model.addShape(new Triangle(color, width, height));
        }
    }
}
