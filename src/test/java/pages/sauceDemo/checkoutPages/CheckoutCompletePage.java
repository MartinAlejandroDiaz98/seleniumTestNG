package pages.sauceDemo.checkoutPages;

import org.openqa.selenium.By;

import lombok.Getter;

public class CheckoutCompletePage {
    @Getter private final By msgOrder = By.xpath("//h2[@data-test='complete-header']");
    @Getter private final By btnBackHome = By.id("back-to-products");
    
}
