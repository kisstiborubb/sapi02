package ro.sapientia.mesteri2015.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMStoryListEditDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^After adding a story and a sprint, I open the scrum tool sprint's story list edit page$")
	public void After_adding_a_story_and_a_sprint_I_open_the_scrum_tool_sprint_s_story_list_edit_page() throws Throwable {
		//accessing scrum
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
		
		//add story
		WebElement addStoryButton = driver.findElement(By.id("add-button"));
		addStoryButton.click();
		WebElement titleField = driver.findElement(By.id("story-title"));		
		titleField.sendKeys("story 1");
		WebElement submitButton = driver.findElement(By.id("add-story-button"));
		submitButton.click();
		
		//accessing sprint list
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/sprint/list");
		
		//add sprint
		WebElement addSprintButton = driver.findElement(By.id("add-button"));
		addSprintButton.click();		
		WebElement sprintTitleField = driver.findElement(By.id("sprint-title"));		
		sprintTitleField.sendKeys("sprint 1");		
		WebElement submitSprintButton = driver.findElement(By.id("add-sprint-button"));
		submitSprintButton.click();
		
		//accessing sprint's story list edit page
		WebElement storyListEditButton = driver.findElement(By.id("story-list-edit"));
		storyListEditButton.click();		
	}

	@When("^I check \"([^\"]*)\" checkbox and I push the save button$")
	public void I_check_checkbox_and_I_push_the_save_button(String arg1) throws Throwable {
		WebElement storyCheckboxField = driver.findElement(By.id("story-1"));		
		storyCheckboxField.click();
		
		WebElement saveButton = driver.findElement(By.id("save-button"));		
		saveButton.click();		
	}

	@Then("^I should get result \"([^\"]*)\" added to sprint's stories list$")
	public void I_should_get_result_added_to_sprint_s_stories_list(String arg1) throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement sprintUpdateLink = driver.findElement(By.id("sprint-update-1"));		
		sprintUpdateLink.click();		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
}
