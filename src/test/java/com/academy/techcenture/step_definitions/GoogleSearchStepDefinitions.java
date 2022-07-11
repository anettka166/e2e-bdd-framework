package com.academy.techcenture.step_definitions;

import com.academy.techcenture.config.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchStepDefinitions {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = Driver.getDriver();
    }

    @Given("user goes to google search page")
    public void user_goes_to_google_search_page() {
        driver.get("https://www.google.com");
        String googleTitle = driver.getTitle();
        Assert.assertEquals("Titles don't match", "Google", googleTitle);
    }

    @When("user enters {string} in the search input box")
    public void user_enters_in_the_search_input_box(String string) {
    }

    @When("user presses enter key")
    public void user_presses_enter_key() {
    }

    @Then("user shoud see results for searched item")
    public void user_shoud_see_results_for_searched_item() {
    }

    @After
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }

    }
}