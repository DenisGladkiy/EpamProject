package utils;

import model.entity.Shape;
import oracle.jrockit.jfr.StringConstantPool;

import java.util.Comparator;

/**
 * Created by Denis on 09.03.2018.
 */
public class ColorComparator implements Comparator <Shape> {
    public int compare(Shape s1, Shape s2) {
        return s1.getColor().compareTo(s2.getColor());
    }
}
