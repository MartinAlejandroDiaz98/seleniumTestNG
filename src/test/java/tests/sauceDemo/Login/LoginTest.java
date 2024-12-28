package tests.sauceDemo.Login;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.sauceDemo.ProductsPage;
import pages.sauceDemo.LoginPage;
import utilities.BaseTest;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @DataProvider(name = "users")
    public Object[][] dataProvider(){
        return new Object[][]{
            {loginPage.getStandardUser()},
            {loginPage.getPerformanceUser()},
            {loginPage.getProblemUser()},
            {loginPage.getErrorUser()},
            {loginPage.getVisualUser()}
        };
    }

    @Test(groups = {regresion, sauceDemo}, dataProvider = "users")
    public void loginWithUsers(String user){
        loginPage.login(user, loginPage.getPassLogin(), loginPage.getUrl());
        waitVisible(productsPage.getInventario());
    }

    @Test(groups = {regresion, sauceDemo})
    public void loginLockedUser(){
        loginPage.login(loginPage.getLockedUser(), loginPage.getPassLogin(), loginPage.getUrl());
        String mensajeError = waitVisible(loginPage.getMessageError()).getText();
        Assert.assertEquals(mensajeError, "Epic sadface: Sorry, this user has been locked out.", "El mensaje esperado no es el correcto, se visualiza el siguiente mensaje: " + mensajeError);
    }
}
