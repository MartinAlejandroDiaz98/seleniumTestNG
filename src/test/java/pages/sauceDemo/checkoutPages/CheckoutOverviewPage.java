package pages.sauceDemo.checkoutPages;

import org.openqa.selenium.By;

import lombok.Getter;

public class CheckoutOverviewPage {
    @Getter private final By itemPriceInventory = By.xpath("//div[@data-test='inventory-item-price']");
    @Getter private final By summarySubTotalPrice = By.xpath("//div[@data-test='subtotal-label']");
    @Getter private final By btnFinish = By.id("finish");
}
