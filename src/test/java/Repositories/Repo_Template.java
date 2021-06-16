package Repositories;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Repo_Template {
	WebDriver driver = null;
	WebDriverWait waitt;

	public void setDriver(WebDriver d) {
		driver = d;
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	//
	public String[] get_def_txtsearch() {
	   return new String[] {"id","//input[@class='gLFyf gsfi']"};
   	};
	public WebElement get_obj_txtsearch(){		
		return driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
	}
	//
	public String[] get_def_btnsearch() {
	   return new String[] {"id","//input[@name='btnK']"};
	};
	public WebElement get_obj_btnsearch() {
		return driver.findElement(By.xpath("//input[@name='btnK']"));
	}
	//
	public String[] get_def_lblcite(String value) {
	   return new String[] {"id","(//cite[contains(text(),'"+value+"')])[1]"};
	};
	public WebElement get_obj_lblcite(String value) {
		return driver.findElement(By.xpath("(//cite[contains(text(),'"+value+"')])[1]"));
	}
	//
}
