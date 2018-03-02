/**
 * Created by Denis on 28.02.2018.
 */
public class Main {

    public static void main(String[] args) {
        doPiramida();
    }

    private static void doPiramida() {
        int size;
        Reader reader = new Reader();
        PiramidaPainter painter = new PiramidaPainter();
        size = reader.read();
        painter.paint(size);
    }
}
