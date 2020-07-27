package project;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class validateTitleTest extends base {
	//public WebDriver driver;
	public static Logger log = LogManager.getLogger(mainPageTest.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		initializer();
		String url = props.getProperty("url");
		driver.get(url);
	}
	
	@Test
	public void home() throws IOException {

		homePage hp = new homePage(driver);
		String title = hp.getTitle().getText();
		assertEquals(title, "Responding to the Coronavirus");
		log.info("Title is true");
		getScreenShotPath();
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}
