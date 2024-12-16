package utilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.driver.WebDriverManager;

public class BaseTest extends BasePage {
    // Creamos objeto WebDriverManager para buildear el driver!
    private final WebDriverManager webDriverManager = new WebDriverManager(); 

    // Metodo @HOOK para iniciar driver antes de cada test
    @BeforeMethod
    public void masterSetUp(){
        webDriverManager.buildDriver();
    }
    // Metodo @HOOK para matar driver despues de cada test
    @AfterMethod
    public void masterTearDown(){
        webDriverManager.killDriver();
    }
}
