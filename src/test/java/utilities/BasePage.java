package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.driver.WebDriverProvider;

public class BasePage {
    // --------------------------------------------------------------------------------------------------------------------------------------------------
    // Variables necesarias de BASEPAGE
    private final static int defaultTimeout = 15;  //Tiempo timeout para esperas y demas seteado
    protected WebDriverWait wait;
    // --------------------------------------------------------------------------------------------------------------------------------------------------

    // Metodo para obtener el driver de la clase provider, recordemos que iniciamos navegador borramos cookies y maximizamos pagina todo en un solo lugar
    protected WebDriver getDriver(){
        return new WebDriverProvider().get();
    }
    // Metodo para iniciar el WAIT\
    protected WebDriverWait getWait(){
        return wait = new WebDriverWait(getDriver(), Duration.ofSeconds(defaultTimeout));
    }

    // Metodo navegacion
    public void navigateTo(String url){
        getDriver().get(url);
    }

    
}
