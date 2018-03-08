package controller;

import model.entity.Shape;
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

    public void calculateTotalArea(){
        view.showArea(modelHandler.calculateTotal());
    }

    public void calculateSelectedShapeArea(String shape){
        view.showArea(modelHandler.calculateSelected(shape));
    }

    public void sortByArea(){
        view.showShapes(modelHandler.sortByArea());
    }

    public void sortByColor(){
        view.showShapes(modelHandler.sortByColor());
    }
}
