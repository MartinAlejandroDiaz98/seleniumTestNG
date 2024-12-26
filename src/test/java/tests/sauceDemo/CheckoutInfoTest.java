package tests.sauceDemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sauceDemo.CartPage;
import pages.sauceDemo.CheckoutInfoPage;
import pages.sauceDemo.LoginPage;
import pages.sauceDemo.ProductsPage;
import utilities.BasePage;
import utilities.BaseTest;

public class CheckoutInfoTest extends BaseTest{
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage();
    CartPage cartPage = new CartPage();
    
    @Test
    public void emptyFirstName(){
        String productName = "Sauce Labs Bike Light";
        loginPage.login(loginPage.getStandardUser(), loginPage.getPassLogin(), loginPage.getUrl());
        productsPage.selectProductWithName(productName);
        clickElement(productsPage.getBtnCart());
        Assert.assertEquals(productName, getText(cartPage.getInventoryName()), "Producto seleccionado carro erroneo");
        clickElement(cartPage.getBtnCheckout());
        sendsKeys(checkoutInfoPage.getLastName(), "Diaz");
        sendsKeys(checkoutInfoPage.getPostalCode(), "1234");
        clickElement(checkoutInfoPage.getBtnContinue());
        String mensajeError = getText(checkoutInfoPage.getMessageError());
        Assert.assertEquals(mensajeError, "Error: First Name is required", "Mensaje obtenido: " + mensajeError);
    }
    @Test
    public void empyLastName(){
        String productName = "Sauce Labs Bike Light";
        loginPage.login(loginPage.getStandardUser(), loginPage.getPassLogin(), loginPage.getUrl());
        productsPage.selectProductWithName(productName);
        clickElement(productsPage.getBtnCart());
        Assert.assertEquals(productName, getText(cartPage.getInventoryName()), "Producto seleccionado carro erroneo");
        clickElement(cartPage.getBtnCheckout());
        sendsKeys(checkoutInfoPage.getFirstName(), "Martin");
        sendsKeys(checkoutInfoPage.getPostalCode(), "1234");
        clickElement(checkoutInfoPage.getBtnContinue());
        String mensajeError = getText(checkoutInfoPage.getMessageError());
        Assert.assertEquals(mensajeError, "Error: Last Name is required", "Mensaje obtenido: " + mensajeError);
    }
    @Test
    public void empyPostalCode(){
        String productName = "Sauce Labs Bike Light";
        loginPage.login(loginPage.getStandardUser(), loginPage.getPassLogin(), loginPage.getUrl());
        productsPage.selectProductWithName(productName);
        clickElement(productsPage.getBtnCart());
        Assert.assertEquals(productName, getText(cartPage.getInventoryName()), "Producto seleccionado carro erroneo");
        clickElement(cartPage.getBtnCheckout());
        sendsKeys(checkoutInfoPage.getFirstName(), "Martin");
        sendsKeys(checkoutInfoPage.getLastName(), "Diaz");
        clickElement(checkoutInfoPage.getBtnContinue());
        String mensajeError = getText(checkoutInfoPage.getMessageError());
        Assert.assertEquals(mensajeError, "Error: Postal Code is required", "Mensaje obtenido: " + mensajeError);
    }
    
}
