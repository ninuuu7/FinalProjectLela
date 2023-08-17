package StepObject;

import PageObject.CartPage;
import PageObject.HomePage;
import io.qameta.allure.Step;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPageSteps extends CartPage {

    WebDriver driver;

    public CartPageSteps(WebDriver driver) {
        this.driver = driver;


    }

    @Step("Check if the selected product is added to the cart")
    public boolean checkExistanceOfTheSelectedProductInTheCart() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(sauceLabsOnesieInCart)));

            return driver.findElement(sauceLabsOnesieInCart).isDisplayed();
        } catch (Exception NoElementFoundException) {
            return false;
        }
    }

    @Step("Click on the Remove Button from the cart page for the Sauce LabsOnesie Product ")
    public void clickOnRemoveButtonOnTheCart() {
        driver.findElement(removeButtonOfTheProductInTheCart).click();


    }


    @Step("Click on the Checkout Button In The Cart")
    public void clickOnTheCheckoutButtonInTheCart() {
        driver.findElement(checkOutButtonInTheCart).click();
    }


    private void removeButtonOfTheProductInTheCart() {
    }


}



