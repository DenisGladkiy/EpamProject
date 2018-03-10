package utils;

import model.entity.Shape;

import java.util.Comparator;

/**
 * Created by Denis on 09.03.2018.
 */
public class AreaComparator implements Comparator<Shape> {
    public int compare(Shape s1, Shape s2) {
        return s1.calcArea() - s2.calcArea();
    }
}
