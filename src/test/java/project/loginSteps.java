package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginSteps {
	By email = By.cssSelector("input[id='email']");
	By password = By.cssSelector("input[id='password']");
	By next = By.cssSelector("*[id='btnNext']");
	By submit = By.cssSelector("button[id='btnLogin']");
	

	WebDriver driver;


	public loginSteps(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {	
		return driver.findElement(email);		
	}
	
	public WebElement getNext() {	
		
		return driver.findElement(next);	

	}

	public WebElement getPassword() {	
		return driver.findElement(password);		
	}

	public WebElement getSubmit() {	
		return driver.findElement(submit);		
	}
}
