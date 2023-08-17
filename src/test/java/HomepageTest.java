import DataObject.HomePageData;
import DataObject.LogInData;
import PageObject.HomePage;
import PageObject.LoginPage;
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

public class HomepageTest implements LogInData {


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

    @Test (priority = 1)
    public void isBurgerMenuOpened() {
        HomePageSteps homePage = new HomePageSteps(driver);
        homePage.clickOnBurgerMenu();
        Assert.assertTrue(homePage.presenceOfBurgerMenuItem(),"Burger menu is not opened");
    }

    @Test (priority = 2)
        public void clickOnTheAboutButton(){
        HomePageSteps homePage = new HomePageSteps(driver);
        homePage.clickOnBurgerMenu();
        homePage.clickOnAboutButton();
    }
    @Test (priority = 5)
        public void clickOnTheAddButtonOnTheProduct(){
            HomePageSteps homePage = new HomePageSteps(driver);
            homePage.addSauceLabsOnesieShirtToTheCart();
    }


    @Test (priority = 3)
        public void clickOnTheLogoutButtonFromTheBurgerMenu(){
            HomePageSteps homePage = new HomePageSteps(driver);
            homePage.clickOnBurgerMenu();
            homePage.clickOnLogOutFromBurgerMenu();
    }
    @Test (priority = 4)
        public void closeTheBurgerMenuWithXButton(){
        HomePageSteps homePage = new HomePageSteps(driver);
        homePage.clickOnBurgerMenu();
        homePage.closeBurgerMenuByXButton();
    }
    @Test
        public void openCartPage (){
        HomePageSteps homePage = new HomePageSteps(driver);
        CartPageSteps cartPage = new CartPageSteps(driver);
        homePage.addSauceLabsOnesieShirtToTheCart();
        homePage.clickOnCartIcon();
    }



    @AfterMethod
    public void endTest() {
        driver.quit();
    }


}