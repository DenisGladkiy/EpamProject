package model;

import model.entity.Shape;

import java.util.Arrays;

/**
 * Created by Denis on 08.03.2018.
 */
public class Model {
    private Shape[] shapes;

    public Model(){
        shapes = new Shape[12];
    }

    public Model(Shape[] shapes){
        this.shapes = shapes;
    }

    public void addShape(Shape shape){
        for(int i = 0; i < shapes.length; ++i){
            if(null == shapes[i]){
                shapes[i] = shape;
                break;
            }
        }
    }

    public void setShapes(Shape[] shapes){
        this.shapes = shapes;
    }

    public Shape[] getShapes(){
        return shapes;
    }

    public String toString(){
        return Arrays.toString(shapes);
    }
}
