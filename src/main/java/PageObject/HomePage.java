package PageObject;

import DataObject.HomePageData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected By
            aboutButton = By.id("about_sidebar_link"),
            burgerMenu = By.xpath("//*[@id=\"react-burger-menu-btn\"]"),
            cartIcon = By.xpath("//*[@id=\"shopping_cart_container\"]"),
            sauceLabsOnesieShirtAddToCart = By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]"),
            addToCartButton = By.id("add-to-cart-sauce-labs-onesie"),
            removeButton = By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]"),
            logOutButtonFromBurgerMenu = By.xpath("//*[@id=\"logout_sidebar_link\"]"),
            closeBurgerMenuButton = By.id("react-burger-cross-btn");


}


