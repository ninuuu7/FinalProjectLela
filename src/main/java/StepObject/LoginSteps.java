package StepObject;

import PageObject.LoginPage;
import io.qameta.allure.Step;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class LoginSteps extends LoginPage {
    WebDriver driver;

    public LoginSteps(WebDriver driver1) {
        driver = driver1;

    }


    public void emailInput(String s) {
        driver.findElement(emailField).sendKeys(s);

    }

    public void passwordInput(String s) {

        driver.findElement(passwordField).sendKeys(s);
    }


    public void clickOnLogInButton() {
        driver.findElement(logInButton).click();
    }


    @Step ("Check if the Current URL comes in accordance with the Home Page URL")
    public boolean checkIfCurrentURLIsHomePageURL() {
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = driver.getCurrentUrl();
        return Objects.equals(expectedURL, actualURL);
    }
}