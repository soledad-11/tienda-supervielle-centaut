package TestCases;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MicuentaPage;
import Repositories.Repo_Template;
import junit.framework.Assert;

public class LoginTest {
	WebDriver driver;

	@Test
	public boolean Test(Datasources data, Reports report, DriverManager DM, int iteration, String name) {
		// validation var
		boolean result = true;
		try {
			System.out.println("Configuring");

			// SELECT THE DRIVER AND PATH
			driver = DM.CreateDriver(DM.CHROME); 
			report.SetDriver(driver);

			// SET THE REPOSITORIES TO USE
			Repo_Template repo = new Repo_Template();
			repo.setDriver(driver);

			System.out.println("Initializating test");

			// SET THE URL
			driver.get("https://supervielle-uat.aper.com");
			HomePage home = new HomePage(driver);
			home.navigateToThisPage();
			home.clickOnLoginLink();
			LoginPage login = new LoginPage(driver);
			Assert.assertTrue(
				"Las URLs no concuerdan!\nEsperado: " + home.getUrl() + login.getUrl() + "\nObservado: " + driver.getCurrentUrl(),
				driver.getCurrentUrl().contains(login.getUrl())
			);
			login.loginWithValidData();
			MicuentaPage miCuenta = new MicuentaPage(driver);
			Assert.assertTrue(
				"Las URLs no concuerdan!\nEsperado: " + home.getUrl() + miCuenta.getUrl() + "\nObservado: " + driver.getCurrentUrl(),
				driver.getCurrentUrl().contains(miCuenta.getUrl())
			);
			+ "\nObservado: " + driver.getCurrentUrl(), driver.getCurrentUrl().contains(miCuenta.getUrl()));
			Assert.assertEquals("La pagina mostrada no es la correcta!", "Mi cuenta", miCuenta.getHeadingText());
			// ADD THE STEPS BELOW
			report.AddLine("Get to the home page");
			report.Screenshot(name);
			System.out.println("test :" + iteration + " " + data.getValueFromDataSource("search", iteration));
			report.AddLine("Search for " + data.getValueFromDataSource("search", iteration));
			repo.get_obj_txtsearch().sendKeys(data.getValueFromDataSource("search", iteration));
			repo.get_obj_btnsearch().click();

			// ADD VALIDATIONS AT THE END
			report.Screenshot(name);
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			report.AddLineAssertionError(e.getStackTrace()[0].toString());
			report.AddLineAssertionError(e.getMessage());
			report.Screenshot(name);
			result = false;
		}
		// return the test result
		return result;
	}
}
