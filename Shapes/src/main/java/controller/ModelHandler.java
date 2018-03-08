package controller;

import model.Model;
import model.entity.Shape;

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
        builder.append("All Shapes\n");
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
        return 0;
    }

    String sortByArea(){
        return "sortByArea";
    }

    String sortByColor(){
        return "sortByColor";
    }
}
