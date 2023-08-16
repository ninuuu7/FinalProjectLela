import DataObject.LogInData;
import PageObject.HomePage;
import PageObject.LoginPage;
import StepObject.HomePageSteps;
import StepObject.LoginSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static DataObject.LogInData.URL;

public class Homepage implements LogInData {


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
    public void isBurgerMenuClickable() {
        HomePageSteps homePage = new HomePageSteps(driver);
        homePage.clickOnBurgerMenu();
        Assert.assertTrue(homePage.isBurgerMenuOpened(), "Burger menu was not opened");
    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }


}