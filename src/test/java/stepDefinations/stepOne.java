package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class stepOne {
	public WebDriver driver;
	LoginPage page;
	
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		page = new LoginPage(driver);
	    	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		driver.get(url);
	    }

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
		page.setUserName(email);
		page.setPassword(password);
	    }

	@When("Click on Login")
	public void click_on_Login() {
		page.clickLogin();
	    }

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(title, driver.getTitle());
		}
	    }

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException {
		page.clickLogout();
	    }

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	    }

}
