import controller.Controller;
import model.Model;
import controller.ModelHandler;
import utils.ShapesFiller;
import view.View;

/**
 * Created by Denis on 08.03.2018.
 */
public class Starter {

    public static void main(String[] args) {
        new Starter().start();
    }

    private void start(){
        Model model = new Model();
        initializeModel(model);
        ModelHandler modelHandler = new ModelHandler(model);
        View view = new View();
        Controller controller = new Controller(modelHandler, view);
        execute(controller);
    }

    private void initializeModel(Model model){
        ShapesFiller filler = new ShapesFiller(model);
        filler.fillShapes();
    }

    private void execute(Controller controller){
        new Executor(controller).execute();
    }
}
