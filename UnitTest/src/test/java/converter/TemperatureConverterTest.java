package converter;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Created by Denis on 17.03.2018.
 */
@RunWith(Parameterized.class)
public class TemperatureConverterTest {
    private static TemperatureConverter temperatureConverter;
    private double celsius;
    private double fahrenheit;
    private double kelvin;

    public TemperatureConverterTest(double celsius, double fahrenheit, double kelvin){
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
        this.kelvin = kelvin;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{{-17.8, 0, 255.4},{0.0, 32.0, 273.2},{30.0, 86.0, 303.2}});
    }

    @BeforeClass
    public static void initialize(){
        temperatureConverter = new TemperatureConverter();
    }

    @Test
    public void testFtoC(){
        double fahrenheit = 0.0;
        double expected = -17.7778;
        double result = (double)Math.round(temperatureConverter.convertFtoC(fahrenheit)*10000)/10000;
        assertTrue(buildReply(expected, result), expected == result);
    }

    @Test
    public void paramTestFtoC(){
        double result = (double)Math.round(temperatureConverter.convertFtoC(fahrenheit)*10)/10;
        assertTrue(buildReply(celsius, result), celsius == result);
    }

    @Test
    public void paramTestCtoF(){
        double result = (double)Math.round(temperatureConverter.convertCtoF(celsius)*10)/10;
        assertTrue(buildReply(fahrenheit, result), fahrenheit == result);
    }

    @Test
    public void paramTestCtoK(){
        double result = (double)Math.round(temperatureConverter.convertCtoK(celsius)*10)/10;
        assertTrue(buildReply(kelvin, result), kelvin == result);
    }

    @Test
    public void paramTestKtoC(){
        double result = (double)Math.round(temperatureConverter.convertKtoC(kelvin)*10)/10;
        assertTrue(buildReply(celsius, result), celsius == result);
    }

    @Test
    public void paramTestFtoK(){
        double result = (double)Math.round(temperatureConverter.convertFtoK(fahrenheit)*10)/10;
        assertTrue(buildReply(kelvin, result), kelvin == result);
    }

    @Test
    public void paramTestKtoF(){
        double result = (double)Math.round(temperatureConverter.convertKtoF(kelvin)*10)/10;
        assertTrue(buildReply(fahrenheit, result), fahrenheit == result);
    }

    private String buildReply(double expected, double result){
        return "Expected " + String.valueOf(expected) + ", Result " + String.valueOf(result);
    }
}
