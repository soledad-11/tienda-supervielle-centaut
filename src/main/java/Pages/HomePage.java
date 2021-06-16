package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By loginLink = By.cssSelector("#block_top_menu .login");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLink() {
        this.driver.findElement(loginLink).click();
    }
}
