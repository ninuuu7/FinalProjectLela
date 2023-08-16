package StepObject;

import PageObject.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageSteps extends HomePage {

    WebDriver driver;

    public HomePageSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on burger menu")
    public void clickOnBurgerMenu() {
        driver.findElement(burgerMenu).click();
    }

    @Step("Click on the About")
    public void clickOnAboutButton() {
        driver.findElement(aboutButton).click();
    }

    @Step("Check if the burger menu is opened")
    public boolean isBurgerMenuOpened() {
        try {
            return driver.findElement(burgerMenuElementAbout).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
