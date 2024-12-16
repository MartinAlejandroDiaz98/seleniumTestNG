package utilities.driver;

import org.openqa.selenium.WebDriver;

public class WebDriverProvider {
    // Declaracion THREADLOCAL para que cada hilo tenga su valor o creacion del webdriver y no interfieran
    private static final ThreadLocal <WebDriver> threadlocal = new ThreadLocal<>();

    // Declaramos un metodo SET del thread local para ASIGNAR VALOR del webDriver
    public void set(WebDriver driver){
        threadlocal.set(driver);
    }

    // Declaramos un metodo GET para obtener del thread local el valor del webDriver
    public WebDriver get(){
         return threadlocal.get();
    }
    
}
