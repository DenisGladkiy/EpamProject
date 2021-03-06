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

    public abstract float calcArea();

    public String draw(){
        return toString();
    }

    public String getColor(){
        return shapeColor;
    }

    @Override
    public String toString(){
        return shapeColor;
    }
}
