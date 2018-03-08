package model.entity;

/**
 * Created by Denis on 08.03.2018.
 */
public class Circle extends Shape {

    private int radius;

    public Circle(String color, int radius){
        super(color);
        this.radius = radius;
    }
    public int calcArea() {
        return radius*2;
    }

    public String toString(){
        return super.toString() + " circle";
    }
}
