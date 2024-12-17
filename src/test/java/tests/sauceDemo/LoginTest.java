package tests.sauceDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.sauceDemo.InventoryPage;
import pages.sauceDemo.LoginPage;
import utilities.BaseTest;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    String url = "https://www.saucedemo.com/";
    String password = "secret_sauce";
    String standardUser = "standard_user";
    String lockedUser = "locked_out_user";
    String problemUser = "problem_user";
    String performanceUser = "performance_glitch_user";
    String errorUser = "error_user";
    String visualUser = "visual_user";

    @Test(groups = {regresion, sauceDemo})
    public void loginStandardUser(){
        navigateTo(url);
        sendsKeys(loginPage.getUsername(), standardUser);
        sendsKeys(loginPage.getPassword(), password);
        clickElement(loginPage.getBtnLogin());
        waitVisible(inventoryPage.getInventario());
    }

    @Test(groups = {regresion, sauceDemo})
    public void loginLockedUser(){
        navigateTo(url);
        sendsKeys(loginPage.getUsername(), lockedUser);
        sendsKeys(loginPage.getPassword(), password);
        clickElement(loginPage.getBtnLogin());
        String mensajeError = waitVisible(loginPage.getMessageError()).getText();
        Assert.assertEquals(mensajeError, "Epic sadface: Sorry, this user has been locked out.", "El mensaje esperado no es el correcto, se visualiza el siguiente mensaje: " + mensajeError);
    }

    @Test(groups = {regresion, sauceDemo})
    public void loginProblemUser(){
        navigateTo(url);
        sendsKeys(loginPage.getUsername(), problemUser);
        sendsKeys(loginPage.getPassword(), password);
        clickElement(loginPage.getBtnLogin());
        waitVisible(inventoryPage.getInventario());
    }

    @Test(groups = {regresion, sauceDemo})
    public void loginPerformanceUser(){
        navigateTo(url);
        sendsKeys(loginPage.getUsername(), performanceUser);
        sendsKeys(loginPage.getPassword(), password);
        clickElement(loginPage.getBtnLogin());
        waitVisible(inventoryPage.getInventario());
    }

    @Test(groups = {regresion, sauceDemo})
    public void loginErrorUser(){
        navigateTo(url);
        sendsKeys(loginPage.getUsername(), errorUser);
        sendsKeys(loginPage.getPassword(), password);
        clickElement(loginPage.getBtnLogin());
        waitVisible(inventoryPage.getInventario());
    }

    @Test(groups = {regresion, sauceDemo})
    public void loginVisualUser(){
        navigateTo(url);
        sendsKeys(loginPage.getUsername(), visualUser);
        sendsKeys(loginPage.getPassword(), password);
        clickElement(loginPage.getBtnLogin());
        waitVisible(inventoryPage.getInventario());
    }
}
