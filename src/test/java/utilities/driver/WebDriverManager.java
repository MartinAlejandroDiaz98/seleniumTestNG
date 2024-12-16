package utilities.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utilities.driver.browserEnum.Browser;

public class WebDriverManager {
    //    Esto tiene que ver para utilizar jenkins y los jobs
    //    Dejaremos la linea de codigo comentada hasta integrar el proyecto a CI CD
    //private final boolean runServer = System.getenv("JOB_NAME") != null; 
    private final boolean runServer = false; 
    public void buildDriver(){
        if(runServer){
            buildRemoteDriver();
        } else {
            buildLocalDriver();
        }
    }
//    Creacion de driver para remote VM por ej JENKINS
    private void buildRemoteDriver(){

    }
//    Creacion de driver para pc local
    private void buildLocalDriver(){
//        Leemos la propiedad que le pasamos por comando del browser, en los pipeline o ejecucion por consola!!!
        String browserProperty = System.getProperty("browser");
        if(browserProperty == null){
            // Asignamos por defecto CHROME o el que queramos en caso de no ser pasado
            browserProperty = "CHROME";
        }
        Browser browser = Browser.valueOf(browserProperty.toUpperCase());

    //    Instancio el webdriver segun el valor del BROWSER.
            // inicializando driver..
            WebDriver driver = switch (browser){
                case CHROME ->  new ChromeDriver();
                case EDGE -> new EdgeDriver();
                case FIREFOX -> new FirefoxDriver();
                case SAFARI -> new SafariDriver();
            };
    //        Luego de instanciar e inicializar driver maximizo browser
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    //        Luego de maximizar browser limpio cookies de casos anteriores
            driver.manage().deleteAllCookies();
    //        Asignamos driver al provider. Seteo el driver en el webdriverprovider para que podamos reutilizarlo en otras clases donde queramos ya instanciado! Supongo para usar en los tests
            new WebDriverProvider().set(driver);
    }
//    Mato el driver
    public void killDriver(){
        // matando driver..
        new WebDriverProvider().get().quit();
    }
    
}
