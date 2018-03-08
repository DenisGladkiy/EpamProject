package model.entity;

/**
 * Created by Denis on 08.03.2018.
 */
public class Triangle extends Shape {

    private int width;
    private int height;

    public Triangle(){}

    public Triangle(String color, int width, int height){
        super(color);
        this.width = width;
        this.height = height;
    }
    public int calcArea() {
        return width*height;
    }

    public String toString(){
        return super.toString() + " triangle";
    }
}
