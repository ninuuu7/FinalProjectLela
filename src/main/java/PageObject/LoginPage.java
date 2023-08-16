package PageObject;

import org.openqa.selenium.By;

public class LoginPage {


  protected   By

            emailField = By.id("user-name"),
            passwordField = By.id("password"),
            logInButton = By.xpath("//*[@id=\"login-button\"]");
}
