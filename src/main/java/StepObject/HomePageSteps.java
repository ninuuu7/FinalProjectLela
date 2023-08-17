package StepObject;

import PageObject.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
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

    @Step("Check if the burger menu is opened, by checking the elements of it")
    public boolean presenceOfBurgerMenuItem() {
        try {
            return driver.findElement(aboutButton).isDisplayed();
        }   catch (Exception e) {
            return false;
        }
    }

    @Step("Close The Burger Menu By X Button")
    public void closeBurgerMenuByXButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(closeBurgerMenuButton)));
        driver.findElement(closeBurgerMenuButton).click();


}
    @Step("Click on the About")
    public void clickOnAboutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(aboutButton)));
        driver.findElement(aboutButton).click();
    }

    @Step("Log out from the button which is in the Burger Menu")
    public void clickOnLogOutFromBurgerMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(logOutButtonFromBurgerMenu)));
        driver.findElement(logOutButtonFromBurgerMenu).click();


    }

    @Step("Click on the cart Icon On The Homepage")
    public void clickOnCartIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(cartIcon)));
        driver.findElement(cartIcon).click();
    }

    @Step("Click on the add button of the Sauce Labs Onesie Shirt on the Homepage")
    public void addSauceLabsOnesieShirtToTheCart() {
        driver.findElement(sauceLabsOnesieShirtAddToCart).click();
    }

    }




