package Reflection.modifyString;

import java.lang.reflect.Field;

/**
 * Created by Denis on 08.04.2018.
 */
public class PrivateFieldModifier {
    VarContainer container;

    public PrivateFieldModifier(VarContainer container){
        this.container = container;
    }

    public void modifyPrivateField() throws NoSuchFieldException, IllegalAccessException {
//        Class<?> clazz = container.getClass();
//        Field field = clazz.getDeclaredField("variable");
//        field.setAccessible(true);
//        field.set(container, "Good by");
        String value = container.getVariable();
        Class<?> clazz = value.getClass();
        Field field = clazz.getDeclaredField("value");
        field.setAccessible(true);
        field.set(value, "Reflection".toCharArray());
    }
}
