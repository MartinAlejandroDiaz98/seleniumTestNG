package tests.sauceDemo.Home;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.sauceDemo.ProductsPage;
import pages.sauceDemo.CartPage;
import pages.sauceDemo.LoginPage;
import utilities.BaseTest;

public class ProductTest extends BaseTest{
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    @Test
    public void carritoValidacion(){
        String productoElegido = "Sauce Labs Backpack";
        // Login
        loginPage.login(loginPage.getStandardUser(), loginPage.getPassLogin(), loginPage.getUrl());
        waitVisible(productsPage.getInventario());
        // Agrego producto al carrito
        productsPage.selectProductWithName(productoElegido);
        // Voy al carrito y valido precio
        clickElement(productsPage.getBtnCart());
        waitVisible(cartPage.getInventoryName());
        String itemName = find(cartPage.getInventoryName()).getText();
        // Valido productgo agregado correctamente
        Assert.assertEquals(itemName, productoElegido);
    }

    @Test
    public void filterOrder(){
        loginPage.login(loginPage.getStandardUser(), loginPage.getPassLogin(), loginPage.getUrl());
        waitVisible(productsPage.getInventario());
        selectWithText(productsPage.getOrderFilter(), "Name (Z to A)");
        selectWithText(productsPage.getOrderFilter(), "Name (A to Z)");    
    }
}
