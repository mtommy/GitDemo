package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {
	WebDriver driver;

	By login  = By.cssSelector("a[id='ul-btn']");
	By title  = By.xpath("//*[contains(text(),'Responding to the Coronavirus')]"); 
	By navbar = By.xpath("//ul[@class='main-menu-list']/li/a");
	
    //Constructor
	public homePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {	
		return driver.findElement(login);	
		
		
	}
	public WebElement getTitle() {
		return driver.findElement(title);

	}
	public WebElement getNavbar() {
		return driver.findElement(navbar);
	}

}