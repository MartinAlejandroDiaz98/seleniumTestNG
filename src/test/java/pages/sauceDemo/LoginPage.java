package pages.sauceDemo;

import org.openqa.selenium.By;

import lombok.Getter;
import utilities.BasePage;

public class LoginPage extends BasePage{
    @Getter private final By username = By.id("user-name");
    @Getter private final By password = By.id("password");
    @Getter private final By btnLogin = By.id("login-button");
    @Getter private final By messageError = By.cssSelector("h3[data-test='error']");
    @Getter private final String url = "https://www.saucedemo.com/";
    @Getter private final String passLogin = "secret_sauce";
    @Getter private final String standardUser = "standard_user";
    @Getter private final String lockedUser = "locked_out_user";
    @Getter private final String problemUser = "problem_user";
    @Getter private final String performanceUser = "performance_glitch_user";
    @Getter private final String errorUser = "error_user";
    @Getter private final String visualUser = "visual_user";
    // Login 
    public void login(String user, String pass, String url){
        navigateTo(url);
        sendsKeys(username, user);
        sendsKeys(password, pass);
        clickElement(btnLogin);
    }

}
