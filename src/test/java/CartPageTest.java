import DataObject.LogInData;
import StepObject.CartPageSteps;
import StepObject.HomePageSteps;
import StepObject.LoginSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest implements LogInData {

    WebDriver driver;

    @BeforeMethod (groups = "Actions on Cart Page")
    @Description ( "Chrome Browser Is Opened and User Is Logged in to the system")
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.emailInput(correctEmailData);
        loginSteps.passwordInput(correctPasswordData);
        loginSteps.clickOnLogInButton();
    }

    @Test (priority = 1, groups = "Actions on Cart Page")
    @Description("This test is about checking if this product is added to the cart")
    @Severity(SeverityLevel.MINOR)
    public void isProductAddedToTheCart() {

        HomePageSteps homePage = new HomePageSteps(driver);
        CartPageSteps cartPage = new CartPageSteps(driver);

        homePage.addSauceLabsOnesieShirtToTheCart();
        homePage.clickOnCartIcon();
        Assert.assertTrue(cartPage.checkExistanceOfTheSelectedProductInTheCart());

    }

    @Test (priority = 2, groups = "Actions on Cart Page")
    @Description ("This test is about checking if the product is removed from the cart")
    @Severity(SeverityLevel.MINOR)
    public void ifTheProductIsRemovedFromTheCart() {
        HomePageSteps homePage = new HomePageSteps(driver);
        CartPageSteps cartPage = new CartPageSteps(driver);
        homePage.addSauceLabsOnesieShirtToTheCart();
        homePage.clickOnCartIcon();
        cartPage.clickOnRemoveButtonOnTheCart();
        Assert.assertFalse(cartPage.checkExistanceOfTheSelectedProductInTheCart());
    }

    @Test (priority = 3, groups = "Actions on Cart Page")
    @Description("This test is about going to the Checkout Page ")
    @Severity(SeverityLevel.MINOR)
    public void goToTheCheckoutPage() {
        HomePageSteps homePage = new HomePageSteps(driver);
        CartPageSteps cartPae = new CartPageSteps(driver);
        homePage.addSauceLabsOnesieShirtToTheCart();
        homePage.clickOnCartIcon();
        cartPae.clickOnTheCheckoutButtonInTheCart();
    }


    @AfterMethod (groups = "Actions on Cart Page")
    @Description(" Closing the Browser")
    public void endTest() {
        driver.quit();
    }


}
