package utilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.driver.WebDriverManager;

public class BaseTest extends BasePage {
    // Creamos objeto WebDriverManager para buildear el driver!
    private final WebDriverManager webDriverManager = new WebDriverManager(); 

    // Constantes TAGS agrupar test
    protected final String regresion = "Regresion";
    protected final String sauceDemo = "Sauce Demo";

    // Metodo @HOOK para iniciar driver antes de cada test
    @BeforeMethod(alwaysRun = true)
    public void masterSetUp(){
        webDriverManager.buildDriver();
    }
    // Metodo @HOOK para matar driver despues de cada test
    @AfterMethod(alwaysRun = true)
    public void masterTearDown(){
        webDriverManager.killDriver();
    }
}
