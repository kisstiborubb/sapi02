package ro.sapientia.mesteri2015.test;

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

public class SRUMAddSprintStepDefinition {
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^I open the scrum tool sprints list$")
	public void I_open_the_scrum_tool_sprints_list() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/sprint/list");
	}

	@When("^I click on the Add button and I fill in the data for the new sprint and click save$")
	public void I_click_on_the_Add_button_and_I_fill_in_the_data_for_the_new_sprint_and_click_save() throws Throwable {
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();

		WebElement titleTextBox = driver.findElement(By.id("story-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys("sprint1");

		// Click on searchButton
		WebElement searchButton = driver.findElement(By.id("add-story-button"));
		searchButton.click();
	}

	@Then("^I should be redirected to the sprints list and see the newly created sprint$")
	public void I_should_be_redirected_to_the_sprints_list_and_see_the_newly_created_sprint() throws Throwable {
		WebElement sprintListDiv = driver.findElement(By.id("sprint-list"));
		WebElement lastA = sprintListDiv.findElement(By.cssSelector(".well:last-child a:first-child"));
		
		Assert.assertEquals("sprint1", lastA.getAttribute("innerHTML"));
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
