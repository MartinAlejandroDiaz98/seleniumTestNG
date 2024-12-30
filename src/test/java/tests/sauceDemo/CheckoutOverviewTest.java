package tests.sauceDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.sauceDemo.CartPage;
import pages.sauceDemo.LoginPage;
import pages.sauceDemo.ProductsPage;
import pages.sauceDemo.checkoutPages.CheckoutInfoPage;
import pages.sauceDemo.checkoutPages.CheckoutOverviewPage;
import utilities.BaseTest;

public class CheckoutOverviewTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    
    @Test(groups = {regresion, sauceDemo})
    public void validatePrice(){
        String productName = "Sauce Labs Bike Light";
        loginPage.login(loginPage.getStandardUser(), loginPage.getPassLogin(), loginPage.getUrl());
        productsPage.selectProductWithName(productName);
        clickElement(productsPage.getBtnCart());
        Assert.assertEquals(productName, getText(cartPage.getInventoryName()), "Producto seleccionado erroneo");
        clickElement(cartPage.getBtnCheckout());
        checkoutInfoPage.typeInfoCheckout("Martin", "Diaz", "12345");
        String inventoryPrice = getText(checkoutOverviewPage.getItemPriceInventory());
        String summaryPrice = getText(checkoutOverviewPage.getSummarySubTotalPrice());
        Assert.assertTrue(summaryPrice.contains(inventoryPrice));
    }
    
}
