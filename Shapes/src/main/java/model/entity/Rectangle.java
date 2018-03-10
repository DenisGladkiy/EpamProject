package model.entity;

/**
 * Created by Denis on 08.03.2018.
 */
public class Rectangle extends Shape {

    private int length;
    private int width;

    public Rectangle(){}

    public Rectangle(String color, int length, int width){
        super(color);
        this.length = length;
        this.width = width;
    }

    public int calcArea() {
        return length*width;
    }

    public String toString(){
        return super.toString() + " Rectangle " + calcArea();
    }
}
