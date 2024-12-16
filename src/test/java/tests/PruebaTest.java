package tests;

import org.testng.annotations.Test;
import utilities.BaseTest;

public class PruebaTest extends BaseTest{
    @Test
    public void prueba0001(){
        navigateTo("https://www.google.com.ar/");
    }
}
