package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    
    // Metodo de espera objeto clickable
    public WebElement waitClickable(By locator){
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Metodo de espera objeta visible
    public WebElement waitVisible(By locator){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Click elemento
    public void clickElement(By locator){
        waitClickable(locator).click();
    }

    // Escribo texto
    public void sendsKeys(By locator, String text){
        waitClickable(locator).sendKeys(text);
    }


    
}
