package pages.sauceDemo;

import org.openqa.selenium.By;

import lombok.Getter;

public class CheckoutInfoPage {
    @Getter private final By firstName = By.id("first-name");
    @Getter private final By lastName = By.id("last-name");
    @Getter private final By postalCode = By.id("postal-code");
    @Getter private final By btnContinue = By.id("continue");
    @Getter private final By btnCancel = By.id("cancel");
    @Getter private final By messageError = By.cssSelector("h3[data-test]");

}
