package controller;

import model.Model;
import model.entity.Shape;
import utils.AreaComparator;
import utils.ColorComparator;

import java.util.Arrays;

/**
 * Created by Denis on 08.03.2018.
 */
public class ModelHandler {
    Model model;
    Shape[] shapes;

    public ModelHandler(Model model){
        this.model = model;
        shapes = model.getShapes();
    }

    String drawAllShapes(){
        StringBuilder builder = new StringBuilder();
        for(Shape shape : shapes){
            builder.append(shape.draw() + "; ");
        }
        return builder.toString();
    }

    int calculateTotal(){
        int totalArea = 0;
        for(Shape shape : shapes){
            totalArea += shape.calcArea();
        }
        return totalArea;
    }

    int calculateSelected(String shape){
        int totalArea = 0;
        try {
            for (Shape sh : shapes) {
                if (Class.forName(shape).isInstance(sh)) {
                    totalArea += sh.calcArea();
                }
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return totalArea;
    }

    String sortByArea(){
        Arrays.sort(shapes, new AreaComparator());
        return "Shapes sorted by area \n" + drawAllShapes();
    }

    String sortByColor(){
        Arrays.sort(shapes, new ColorComparator());
        return "Shapes sorted by color \n" + drawAllShapes();
    }
}
