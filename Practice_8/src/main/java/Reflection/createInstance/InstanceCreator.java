package Reflection.createInstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Denis on 08.04.2018.
 */
public class InstanceCreator {


    public ArithmeticOperation createInstance(){
        ArithmeticOperation ao = null;
        Class<?> clazz = ArithmeticOperation.class;
        try {
            Constructor<?> constructor = clazz.getConstructor(double.class);
            ao = (ArithmeticOperation) constructor.newInstance(10.5);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return ao;
    }

    public double readPrivate(ArithmeticOperation ao){
        if(ao != null) {
            Class<?> clazz = ao.getClass();
            try {
                Field field = clazz.getDeclaredField("value");
                field.setAccessible(true);
                return field.getDouble(ao);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return 0.0;
        }else{
            return 0.0;
        }
    }

    public void setPrivate(ArithmeticOperation ao, double val){
        if(ao != null) {
            Class<?> clazz = ao.getClass();
            try {
                Field field = clazz.getDeclaredField("value");
                field.setAccessible(true);
                field.setDouble(ao, val);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
