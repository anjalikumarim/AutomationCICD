package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LoadingPage  extends  AbstractComponent {

	
	WebDriver driver;
	public LoadingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements( driver,this);
	}
	//WebElement userEmails = driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement PasswordElement;
	
	@FindBy(id="login")
	WebElement login;
	

	public productCatalogue loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		PasswordElement.sendKeys(password);
		login.click();
		return null;
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
}





