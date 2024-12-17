package pages.sauceDemo;

import org.openqa.selenium.By;

public class LoginPage {
    // username
    private final By username = By.id("user-name");
    // Password
    private final By password = By.id("password");
    // Btn login
    private final By btnLogin = By.id("login-button");
    // Mensaje error
    private final By messageError = By.cssSelector("h3[data-test='error']");
    
    // GETTERS
    public By getUsername(){
        return username;
    }
    public By getPassword(){
        return password;
    }
    public By getBtnLogin(){
        return btnLogin;
    }
    public By getMessageError(){
        return messageError;
    }
}
