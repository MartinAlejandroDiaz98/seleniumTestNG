package pages.sauceDemo;

import org.openqa.selenium.By;

import lombok.Getter;

public class CartPage {

    @Getter private final By inventoryName = By.xpath("//div[@data-test='inventory-item-name']");
    @Getter private final By btnCheckout = By.id("checkout");

}
