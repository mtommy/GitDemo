package project;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class mainPageTest extends base{
	//public WebDriver driver;
	public static Logger log = LogManager.getLogger(mainPageTest.class.getName());
	
	@DataProvider
	public Object[][] data(){
		Object [][]obj=new Object[2][2];
		obj[0][0]="nick@gmail.com";
		obj[0][1]="positive";
		
		obj[1][0]="negative@gmail.com";
		obj[1][1]="negative";
		
		return obj;
	}
	
	@Test (dataProvider = "data")
	public void home(String email, String password) throws IOException {
		initializer();
		log.info("Driver is initialized");
		String url = props.getProperty("url");
		driver.get(url);
		log.info("Navigated to homepage");

		homePage hp = new homePage(driver);
		hp.getLogin().click();
		log.info("Login button clicked");
		
		loginSteps ls = new loginSteps(driver);
		ls.getEmail().sendKeys(email);
		log.info("login email entered");

		if(driver.findElement(By.cssSelector("*[id='btnNext']")).isDisplayed()) {
		loginSteps lsp = new loginSteps(driver);
		lsp.getNext().click();
		log.info("next button clicked");
		}
		
		ls.getPassword().sendKeys(password);
		log.info("login password is entered");

		ls.getSubmit().click();
		log.info("submit button is clicked");
		getScreenShotPath();
		driver.close();
}


}
