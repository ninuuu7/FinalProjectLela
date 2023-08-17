import DataObject.HomePageData;
import DataObject.LogInData;
import StepObject.CartPageSteps;
import StepObject.HomePageSteps;
import StepObject.LoginSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest implements LogInData {

    WebDriver driver;

    @BeforeMethod
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

    @Test
    public void isProductAddedToTheCart() {

        HomePageSteps homePage = new HomePageSteps(driver);
        CartPageSteps cartPage = new CartPageSteps(driver);

        homePage.addSauceLabsOnesieShirtToTheCart();
        homePage.clickOnCartIcon();
        Assert.assertTrue(cartPage.checkExistanceOfTheSelectedProductInTheCart());

    }

    @Test
    public void ifTheProductIsRemovedFromTheCart() {
        HomePageSteps homePage = new HomePageSteps(driver);
        CartPageSteps cartPage = new CartPageSteps(driver);
        homePage.addSauceLabsOnesieShirtToTheCart();
        homePage.clickOnCartIcon();
        cartPage.clickOnRemoveButtonOnTheCart();
        Assert.assertFalse(cartPage.checkExistanceOfTheSelectedProductInTheCart());
    }

    @Test
    public void goToTheCheckoutPage() {
        HomePageSteps homePage = new HomePageSteps(driver);
        CartPageSteps cartPae = new CartPageSteps(driver);
        homePage.addSauceLabsOnesieShirtToTheCart();
        homePage.clickOnCartIcon();
        cartPae.clickOnTheCheckoutButtonInTheCart();
    }


    @AfterMethod
    public void endTest() {
        driver.quit();
    }


}
