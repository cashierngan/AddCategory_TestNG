package Lesson24ParameterMultiBrowser;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameter {
    @Test
    @Parameters ({"number1", "number2", "message"})
    public void sumNumber(@Optional("8") int a, int b, String message){
        System.out.println(message + ": " + (a + b));
    }
}
