package tests.sauceDemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sauceDemo.CartPage;
import pages.sauceDemo.LoginPage;
import pages.sauceDemo.ProductsPage;
import pages.sauceDemo.checkoutPages.CheckoutInfoPage;
import utilities.BaseTest;

public class CheckoutInfoTest extends BaseTest{
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage();
    CartPage cartPage = new CartPage();
    
    @Test(groups = {regresion, sauceDemo})
    public void emptyFirstName(){
        String productName = "Sauce Labs Bike Light";
        loginPage.login(loginPage.getStandardUser(), loginPage.getPassLogin(), loginPage.getUrl());
        productsPage.selectProductWithName(productName);
        clickElement(productsPage.getBtnCart());
        Assert.assertEquals(productName, getText(cartPage.getInventoryName()), "Producto seleccionado erroneo");
        clickElement(cartPage.getBtnCheckout());
        checkoutInfoPage.errorMessageInfoCheckout("","Diaz","1234","Error: First Name is required");
    }
    @Test(groups = {regresion, sauceDemo})
    public void empyLastName(){
        String productName = "Sauce Labs Bike Light";
        loginPage.login(loginPage.getStandardUser(), loginPage.getPassLogin(), loginPage.getUrl());
        productsPage.selectProductWithName(productName);
        clickElement(productsPage.getBtnCart());
        Assert.assertEquals(productName, getText(cartPage.getInventoryName()), "Producto seleccionado erroneo");
        clickElement(cartPage.getBtnCheckout());
        checkoutInfoPage.errorMessageInfoCheckout("Martin","","1234","Error: Last Name is required");
    }
    @Test(groups = {regresion, sauceDemo})
    public void empyPostalCode(){
        String productName = "Sauce Labs Bike Light";
        loginPage.login(loginPage.getStandardUser(), loginPage.getPassLogin(), loginPage.getUrl());
        productsPage.selectProductWithName(productName);
        clickElement(productsPage.getBtnCart());
        Assert.assertEquals(productName, getText(cartPage.getInventoryName()), "Producto seleccionado erroneo");
        clickElement(cartPage.getBtnCheckout());
        checkoutInfoPage.errorMessageInfoCheckout("Martin","Diaz","","Error: Postal Code is required");    }
    
}
