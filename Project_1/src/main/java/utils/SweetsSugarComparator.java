package utils;

import model.entity.Sweets;

import java.util.Comparator;

/**
 * Created by Denis on 04.04.2018.
 */
public class SweetsSugarComparator implements Comparator<Sweets> {
    @Override
    public int compare(Sweets o1, Sweets o2) {
        return o1.getSugar() - o2.getSugar();
    }
}
