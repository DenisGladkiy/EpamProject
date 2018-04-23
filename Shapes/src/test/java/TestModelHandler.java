import controller.Controller;
import controller.ModelHandler;
import model.Model;
import model.entity.Circle;
import model.entity.Rectangle;
import model.entity.Shape;
import model.entity.Triangle;
import org.junit.BeforeClass;
import org.junit.Test;
import mvc.view.View;
import static org.junit.Assert.*;

/**
 * Created by Denis on 22.03.2018.
 */
public class TestModelHandler {
    private static Controller controller;
    private static Shape[] shapes;

    @BeforeClass
    public static void initialize(){
        shapes = new Shape[3];
        shapes[0] = new Rectangle("red", 4, 5);
        shapes[1] = new Circle("blue", 8);
        shapes[2] = new Triangle("green", 6, 3);
        Model model = new Model(shapes);
        ModelHandler modelHandler = new ModelHandler(model);
        View view = new View();
        controller = new Controller(modelHandler, view);
    }

    @Test
    public void testTotalArea(){
        int expected = 229;
        int result = controller.calculateTotalArea();
        assertEquals(expected, result);
    }

    @Test
    public void testSelectedArea(){
        int expected = 20;
        int result = controller.calculateSelectedShapeArea("model.entity.Rectangle");
        assertEquals(expected, result);
    }

    @Test
    public void testSortByArea(){
        controller.sortByArea();
        assertTrue(shapes[0] instanceof Triangle);
    }

    @Test
    public void testSortByColor(){
        controller.sortByColor();
        assertTrue(shapes[0] instanceof Circle);
    }
}
