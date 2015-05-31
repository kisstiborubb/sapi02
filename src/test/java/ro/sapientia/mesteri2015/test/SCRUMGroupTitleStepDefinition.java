package ro.sapientia.mesteri2015.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMGroupTitleStepDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open the scrum tool group add page$")
	public void I_open_the_scrum_tool_group_add_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/group/list");
	}

	@When("^I enter \"([^\"]*)\" in  the description textbox and I push the add button$")
	public void I_enter_in_the_description_textbox_and_I_push_the_add_button(String arg1) throws Throwable {
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();

		WebElement titleTextBox = driver.findElement(By.id("group-description"));
		titleTextBox.clear();
		titleTextBox.sendKeys(arg1);
		
		WebElement searchButton = driver.findElement(By.id("add-group-button"));
		searchButton.click();
	}

	@Then("^I should get result \"([^\"]*)\" in groups list$")
	public void I_should_get_result_in_groups_list(String arg1) throws Throwable {
		WebElement calculatorTextBox = driver.findElement(By.id("group-description"));
		String result = calculatorTextBox.getText();
		
		Assert.assertEquals(result, arg1);

		driver.close();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
}
