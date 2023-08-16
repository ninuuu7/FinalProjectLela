import StepObject.LoginSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static DataObject.LogInData.*;

public class LogIn {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(URL);
        driver.manage().window().maximize();
    }

    @Test
    public void LoginWithIncorrectData() throws InterruptedException {

        LoginSteps step1 = new LoginSteps(driver);
        step1.emailInput(incorrectEmailData);
        step1.passwordInput(incorrectPasswordData);
        step1.clickOnLogInButton();


        Thread.sleep(5000);



    }

    @Test

    public void LoginWithCorrectData() throws InterruptedException {


        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.emailInput(correctEmailData);
        loginSteps.passwordInput(correctPasswordData);
        loginSteps.clickOnLogInButton();

        Assert.assertTrue(loginSteps.checkIfCurrentURLIsHomePageURL(), "The user was not directed to the Home Page after successful Log In");

    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }


}
