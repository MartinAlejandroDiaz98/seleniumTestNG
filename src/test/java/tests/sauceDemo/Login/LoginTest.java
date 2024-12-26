package tests.sauceDemo.Login;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.sauceDemo.ProductsPage;
import pages.sauceDemo.LoginPage;
import utilities.BaseTest;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @Test(groups = {regresion, sauceDemo})
    public void loginStandardUser(){
        loginPage.login(loginPage.getStandardUser(), loginPage.getPassLogin(), loginPage.getUrl());
        waitVisible(productsPage.getInventario());
    }

    @Test(groups = {regresion, sauceDemo})
    public void loginLockedUser(){
        loginPage.login(loginPage.getLockedUser(), loginPage.getPassLogin(), loginPage.getUrl());
        String mensajeError = waitVisible(loginPage.getMessageError()).getText();
        Assert.assertEquals(mensajeError, "Epic sadface: Sorry, this user has been locked out.", "El mensaje esperado no es el correcto, se visualiza el siguiente mensaje: " + mensajeError);
    }

    @Test(groups = {regresion, sauceDemo})
    public void loginProblemUser(){
        loginPage.login(loginPage.getProblemUser(), loginPage.getPassLogin(), loginPage.getUrl());
        waitVisible(productsPage.getInventario());
    }

    @Test(groups = {regresion, sauceDemo})
    public void loginPerformanceUser(){
        loginPage.login(loginPage.getPerformanceUser(), loginPage.getPassLogin(), loginPage.getUrl());
        waitVisible(productsPage.getInventario());
    }

    @Test(groups = {regresion, sauceDemo})
    public void loginErrorUser(){
        loginPage.login(loginPage.getErrorUser(), loginPage.getPassLogin(), loginPage.getUrl());
        waitVisible(productsPage.getInventario());
    }

    @Test(groups = {regresion, sauceDemo})
    public void loginVisualUser(){
        loginPage.login(loginPage.getVisualUser(), loginPage.getPassLogin(), loginPage.getUrl());
        waitVisible(productsPage.getInventario());
    }
}
