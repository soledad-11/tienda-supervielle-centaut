package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MicuentaPage extends BasePage {
    private By headingLocator  = By.className("page-heading");

    public MicuentaPage(WebDriver driver) {
        super(driver);
        this.url += "/mi-cuenta";
    }

    public String getHeadingText() {
		return this.driver.findElement(headingLocator).getText();
    }
}
