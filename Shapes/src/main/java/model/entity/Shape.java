package model.entity;

/**
 * Created by Denis on 08.03.2018.
 */
public abstract class Shape implements Drawable{

    private String shapeColor;

    public Shape(){}

    public Shape(String shapeColor){
        this.shapeColor = shapeColor;
    }

    public abstract int calcArea();

    public String draw(){
        return toString();
    }

    @Override
    public String toString(){
        return shapeColor;
    }
}
