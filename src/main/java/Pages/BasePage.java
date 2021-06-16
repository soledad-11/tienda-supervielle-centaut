package Pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected String url = "";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.url = "https://supervielle-uat.aper.com";
    }

    public String getUrl() {
        return url;
    }

    public void navigateToThisPage() {
        this.driver.get(this.url);
    }
}
