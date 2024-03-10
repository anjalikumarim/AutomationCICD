 package rahulshettyacademy.TestComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LoadingPage;

public class BaseTest {
	public WebDriver driver;
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
				"\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.Properties");		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
		} 
		else if (browserName.equalsIgnoreCase("firefox")) {
			// firefox
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			 driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	public LoadingPage launchApplication() throws IOException
	{
	 driver	= initializeDriver();
	 LoadingPage loadingPage = new LoadingPage(driver);
		loadingPage.goTo();
		return loadingPage;

	}
}