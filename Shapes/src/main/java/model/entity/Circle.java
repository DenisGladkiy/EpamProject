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
    public float calcArea() {
        return 3.14f * radius * radius;
    }

    public String toString(){
        return super.toString() + " Circle" + " " + String.valueOf(calcArea());
    }
}
