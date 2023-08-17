import DataObject.HomePageData;
import DataObject.LogInData;
import PageObject.HomePage;
import PageObject.LoginPage;
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

public class HomepageTest implements LogInData {


    WebDriver driver;

    @BeforeMethod (groups = "Actions From Homepage")
    @Description(" Openingg Chrome Browser and Log in to the system")
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

    @Test (enabled = false, priority = 1, groups = "Actions From Homepage")
    @Description(" This test is about checking if the Burger Menu is opened on the homepage by clicking on it")
    @Severity(SeverityLevel.MINOR)
    public void isBurgerMenuOpened() {
        HomePageSteps homePage = new HomePageSteps(driver);
        homePage.clickOnBurgerMenu();
        Assert.assertTrue(homePage.presenceOfBurgerMenuItem(),"Burger menu is not opened");
    }

    @Test (priority = 2, groups = "Actions From Homepage")
    @Description("This test is about opening About page from the burger menu")
    @Severity(SeverityLevel.MINOR)
        public void clickOnTheAboutButton(){
        HomePageSteps homePage = new HomePageSteps(driver);
        homePage.clickOnBurgerMenu();
        homePage.clickOnAboutButton();
    }
    @Test (priority = 5, groups = "Actions From Homepage")
    @Description("This test is about adding the product in the cart by clicking on the Add Button on the Product")
    @Severity(SeverityLevel.NORMAL)
        public void clickOnTheAddButtonOnTheProduct(){
            HomePageSteps homePage = new HomePageSteps(driver);
            homePage.addSauceLabsOnesieShirtToTheCart();
    }


    @Test (priority = 3, groups = "Actions From Homepage")
    @Description("This test is about Logging out from the system by clicking on the Log Out button from the Burger Menu")
    @Severity(SeverityLevel.CRITICAL)
        public void clickOnTheLogoutButtonFromTheBurgerMenu(){
            HomePageSteps homePage = new HomePageSteps(driver);
            homePage.clickOnBurgerMenu();
            homePage.clickOnLogOutFromBurgerMenu();
    }
    @Test (priority = 4, groups = "Actions From Homepage")
    @Description("This test is about losing the Burger menu on the Homepage by clicking on the X button in it")
    @Severity(SeverityLevel.MINOR)
        public void closeTheBurgerMenuWithXButton(){
        HomePageSteps homePage = new HomePageSteps(driver);
        homePage.clickOnBurgerMenu();
        homePage.closeBurgerMenuByXButton();
    }
    @Test (priority = 5,groups = "Actions From Homepage")
    @Description("This test is about opening the Cart page when there is product added by clicking on the Cart Icon on th homepage")
    @Severity(SeverityLevel.CRITICAL)

        public void openCartPage (){
        HomePageSteps homePage = new HomePageSteps(driver);
        CartPageSteps cartPage = new CartPageSteps(driver);
        homePage.addSauceLabsOnesieShirtToTheCart();
        homePage.clickOnCartIcon();
    }



    @AfterMethod (groups = "Actions From Homepage")
    @Description("Closing the browser")
    public void endTest() {
        driver.quit();
    }


}