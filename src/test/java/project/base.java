package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;

public class base {
	public WebDriver driver;
	public Properties props; 

	
	public WebDriver initializer() throws IOException {
		
		props = new Properties();
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"./globalData/data.properties");
		props.load(fis);
		String webDriver = props.getProperty("driver");
		if (webDriver.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\MTame\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (webDriver.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\MTame\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\MTame\\IEDriver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	public void getScreenShotPath() throws IOException {
		TakesScreenshot ts =(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String SS = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.png'").format(new Date());
		File destination = new File (".\\screenShot\\"+SS);
		Files.copy(source, destination);
		
	}

}