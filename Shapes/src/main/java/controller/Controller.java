package controller;

import view.View;

/**
 * Created by Denis on 08.03.2018.
 */
public class Controller {
    ModelHandler modelHandler;
    View view;

    public Controller(ModelHandler modelHandler, View view){
        this.modelHandler = modelHandler;
        this.view = view;
    }

    public void showAll(){
        view.showShapes(modelHandler.drawAllShapes());
    }

    public int calculateTotalArea(){
        int result = modelHandler.calculateTotal();
        view.showArea(result);
        return result;
    }

    public int calculateSelectedShapeArea(String shape){
        int result = modelHandler.calculateSelected(shape);
        view.showArea(result);
        return result;
    }

    public void sortByArea(){
        view.showShapes(modelHandler.sortByArea());
    }

    public void sortByColor(){
        view.showShapes(modelHandler.sortByColor());
    }
}
