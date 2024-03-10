package rahulshettyacademy.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.pageobjects.LoadingPage;
import rahulshettyacademy.pageobjects.productCatalogue;

public class stepDefinitionImpl extends BaseTest{
	public productCatalogue ProductCatalogue;
	public LoadingPage loadingPage;
	@Given ("I landed on Ecommerce page")
	public void  I_landed_on_Ecommerce_page() throws IOException
	{
		 loadingPage = launchApplication();
		 //code
	}
	
	@Given ("^Logged in username(.+) and password(.+)$")
	public void Logged_in_username_and_password(String username, String password)
	{
		 ProductCatalogue = loadingPage.loginApplication(username, password);
	}
	
	@When ("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products = ProductCatalogue.getProductList();
		ProductCatalogue.addProductToCart(productName);
	}
	}

	
	


