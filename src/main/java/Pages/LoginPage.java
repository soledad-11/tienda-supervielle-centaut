package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

public class LoginPage extends BasePage {
    private By emailLocator = By.id("email");
    private By passwordLocator = By.id("passwd");
    private By loginButtonLocator = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.url += "/inicio-sesion?back=my-account";
    }

    public void login(String email, String password) {
        this.driver.findElement(emailLocator).sendKeys(email);
        this.driver.findElement(passwordLocator).sendKeys(password);
        this.driver.findElement(loginButtonLocator).click();
    }

    /**
     * Se loguea en la aplicacion usando datos validos de email y contraseña.
     */
    public void loginWithValidData() {
        PropertyReader data = new PropertyReader(PropertyReader.DataSource.login);
        this.login(data.getProperty("validEmail"), data.getProperty("validPassword"));
    }
}
