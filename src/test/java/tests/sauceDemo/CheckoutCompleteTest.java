package tests.sauceDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.sauceDemo.CartPage;
import pages.sauceDemo.LoginPage;
import pages.sauceDemo.ProductsPage;
import pages.sauceDemo.checkoutPages.CheckoutCompletePage;
import pages.sauceDemo.checkoutPages.CheckoutInfoPage;
import pages.sauceDemo.checkoutPages.CheckoutOverviewPage;
import utilities.BaseTest;

public class CheckoutCompleteTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @Test(groups = {regresion, sauceDemo,"Regresion"})
    public void completeBuy(){
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
        clickElement(checkoutOverviewPage.getBtnFinish());
        Assert.assertEquals(getText(checkoutCompletePage.getMsgOrder()).trim(), "Thank you for your order!" ,"Mensaje esperado incorrecto");
    }
    
}
