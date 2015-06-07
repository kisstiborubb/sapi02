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

public class SCRUMAddWorkStepDefinition {
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^I open the scrum tool sprints list to add work$")
	public void I_open_the_scrum_tool_sprints_list() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/sprint/list");
	}
	
	@When("^I click on the last sprint and then I click on the Add work button and I fill in the data for the Work hour and hit save$")
	public void I_click_on_the_last_sprint_and_then_I_click_on_the_Add_work_button_and_I_fill_in_the_data_for_the_Work_hour_and_hit_save() throws Throwable {
		WebElement sprintListDiv = driver.findElement(By.id("sprint-list"));
		WebElement a = sprintListDiv.findElement(By.cssSelector(".well:last-child a:last-child"));
		
		a.click();
		
		WebElement addButtonA = driver.findElement(By.id("add-button"));
		addButtonA.click();
		
		WebElement nameInput = driver.findElement(By.id("name"));
		nameInput.sendKeys("name1");
		
		WebElement startInput = driver.findElement(By.id("start"));
		startInput.sendKeys("10/10/2015 10:00");
		
		WebElement endInput = driver.findElement(By.id("end"));
		endInput.sendKeys("10/10/2015 11:30");
		
		WebElement submitButton = driver.findElement(By.tagName("button"));
		submitButton.click();
	}

	@Then("^I should be redirected to the works list and see the newly created work$")
	public void I_should_be_redirected_to_the_works_list_and_see_the_newly_created_work() throws Throwable {
		List<WebElement> wellDiv = driver.findElements(By.cssSelector(".well"));
	
		Assert.assertTrue(wellDiv.size() > 0);	
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
