import controller.Controller;
import model.entity.Circle;

/**
 * Created by Denis on 08.03.2018.
 */
public class Executor {
    Controller controller;

    public Executor(Controller controller){
        this.controller = controller;
    }

    public void execute(){
        controller.showAll();
        controller.calculateTotalArea();
        controller.calculateSelectedShapeArea("circle");
        controller.sortByArea();
        controller.sortByColor();
    }
}
