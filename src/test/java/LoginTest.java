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

import java.util.PriorityQueue;

import static DataObject.LogInData.*;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod(groups = "Login Tests")
    @Description(" Chrome Browser is opened")
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(URL);
        driver.manage().window().maximize();
    }

    @Test(priority = 1, groups = "Login Tests")
    @Description(" The tests is about Login to the system with Incorrect Email and Password")
    @Severity(SeverityLevel.NORMAL)

    public void LoginWithIncorrectData() {

        LoginSteps step1 = new LoginSteps(driver);
        step1.emailInput(incorrectEmailData);
        step1.passwordInput(incorrectPasswordData);
        step1.clickOnLogInButton();


    }

    @Test(priority = 2, groups = "Login Tests")
    @Description("The test is about Log In to the system with correct Email and Password")
    @Severity(SeverityLevel.BLOCKER)

    public void LoginWithCorrectData() throws InterruptedException {

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.emailInput(correctEmailData);
        loginSteps.passwordInput(correctPasswordData);
        loginSteps.clickOnLogInButton();
        Assert.assertTrue(loginSteps.checkIfCurrentURLIsHomePageURL(), "The user was not directed to the Home Page after successful Log In");

    }

    @AfterMethod(groups = "Login Tests")
    @Description("Chrome Browser Is Closed")
    public void endTest() {
        driver.quit();
    }


}
