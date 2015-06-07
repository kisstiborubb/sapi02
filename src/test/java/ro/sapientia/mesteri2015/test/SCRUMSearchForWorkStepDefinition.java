package ro.sapientia.mesteri2015.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMSearchForWorkStepDefinition {
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^I open the scrum tool work hours search$")
	public void I_open_the_scrum_tool_work_hours_search() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/work/search");
	}

	@When("^I fill in the start date and the end date and click search$")
	public void I_fill_in_the_start_date_and_the_end_date_and_click_search() throws Throwable {
		WebElement startInput = driver.findElement(By.id("start"));
		startInput.sendKeys("10/10/2015 9:00");
		
		WebElement endInput = driver.findElement(By.id("end"));
		endInput.sendKeys("10/10/2015 11:40");
		
		WebElement submitButton = driver.findElement(By.tagName("button"));
		submitButton.click();
	}

	@Then("^I should be able to see a work hour$")
	public void I_should_be_able_to_see_a_work_hour() throws Throwable {
		List<WebElement> wellDiv = driver.findElements(By.cssSelector(".well"));
		
		Assert.assertTrue(wellDiv.size() > 0);
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
