package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LoadingPage;
import rahulshettyacademy.pageobjects.productCatalogue;

public class SubmitOrderTest {
	
	public static <LoandingPage> void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		String productName = "ADIDAS ORIGINAL" ;
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds( 10));
		
		LoadingPage loadingPage = new LoadingPage(driver);
		loadingPage.goTo();
		loadingPage.loginApplication("kanu12@gmail.com", "Abc@1234567890");
		
		productCatalogue ProductCatalogue = new productCatalogue(driver);
		List<WebElement> products = ProductCatalogue.getProductList();
		ProductCatalogue.addProductToCart(productName);
		
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List<WebElement> cartProducts = driver.findElements(By.xpath("//*[@class='cartSection']/ h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//*[@class='totalRow']/button")).click();
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit ")).click();
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//driver.close();
}
	}
