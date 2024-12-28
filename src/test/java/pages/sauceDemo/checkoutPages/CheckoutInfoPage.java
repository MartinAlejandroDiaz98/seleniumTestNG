package pages.sauceDemo.checkoutPages;

import org.openqa.selenium.By;
import org.testng.Assert;

import lombok.Getter;
import utilities.BasePage;

public class CheckoutInfoPage extends BasePage {
    @Getter private final By firstName = By.id("first-name");
    @Getter private final By lastName = By.id("last-name");
    @Getter private final By postalCode = By.id("postal-code");
    @Getter private final By btnContinue = By.id("continue");
    @Getter private final By btnCancel = By.id("cancel");
    @Getter private final By messageError = By.cssSelector("h3[data-test]");


    // Info checkout
    public void errorMessageInfoCheckout(String firstName, String lastName, String postalCode, String mensajeEsperado){
        if(!firstName.isEmpty()){
            sendsKeys(getFirstName(), firstName);
        }
        if(!lastName.isEmpty()){
            sendsKeys(getLastName(), lastName);
        }
        if(!postalCode.isEmpty()){
            sendsKeys(getPostalCode(), postalCode);
        }
        clickElement(btnContinue); 
        String mensajeError = getText(messageError);
        Assert.assertEquals(mensajeError, mensajeEsperado, "Mensaje erroneo, el mensaje actual obtenido es: " + mensajeError);
    }
}
