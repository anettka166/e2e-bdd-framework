package com.academy.techcenture.step_definitions;

import com.academy.techcenture.config.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class UserLoginStepDefinitions {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    @Before
    public  void setUp(){
        driver = Driver.getDriver();
    }

    @After
    public void cleanUp(){
        if (driver != null){
            driver.quit();
        }
    }






    @Given("user is on the home page")
    public void user_is_on_the_home_page() {

        driver.get("https://automationpractice.com");
        String actualTitle = driver.getTitle();
        assertEquals("Titles do not match", "My Store", actualTitle);

        WebElement logo = driver.findElement(By.xpath("//img[contains(@class,'logo')]"));
        assertTrue("Logo is not displayed", logo.isDisplayed());


    }

    @When("user clicks on the sigh in link")
    public void user_clicks_on_the_sigh_in_lonk() {

        WebElement signInLink = driver.findElement(By.partialLinkText("Sign in"));
        assertTrue("Sign in link is not displayed", signInLink.isDisplayed());
        actions.click(signInLink).perform();

    }

    @When("user should be navigated to login screen")
    public void user_should_be_navigated_to_login_screen() {
        String loginTitle = driver.getTitle();
        assertEquals("Titles are not matching", "Login - My Store", loginTitle);
        WebElement loginForm = driver.findElement(By.id("login_form"));
        assertTrue("Login form is not displayed", loginForm.isDisplayed());

    }
    @And("user enters {string} and {string} in the credentials input")
    public void userEntersAndInTheCredentialsInput(String username, String password) {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
    }


    @When("user clicks on login button")
    public void user_clicks_on_login_button() {

        WebElement loginBtn = driver.findElement(By.id("SubmitLogin"));
        assertTrue("Login btn is not enables", loginBtn.isDisplayed());
        loginBtn.click();


    }

    @When("user should be navigated to account page")
    public void user_should_be_navigated_to_account_page() {
        String myAccountTitle = driver.getTitle();
        assertEquals("Titles do not match", "My account - My Store", myAccountTitle);
        WebElement header = driver.findElement(By.xpath("//h1[contains(@class,'page-heading')]"));
        assertTrue("My account Headed is not displayed", header.isDisplayed());
        String[] expectedOptions = {"Order history and details", "My credit slips", "My addresses", "My personal information", "My wishlists"};
        List<WebElement> accountOptions = driver.findElements((By.xpath("//ul[@class='myaccount-link-list']/li/a/span")));

        for (int i = 0; i < accountOptions.size(); i++) {
            assertEquals("Account options do not match", expectedOptions[i].toUpperCase(), accountOptions.get(i).getText().toUpperCase().trim());
        }

    }

    @Then("user should be able to see their name on top")
    public void user_should_be_able_to_see_their_name_on_top() {
        WebElement userName = driver.findElement(By.xpath("//a[@class='account']/span"));
        assertTrue(userName.isDisplayed());
        String userNameTxt = userName.getText();

        assertEquals("User name does not match", "Kevin Lee", userNameTxt);

    }


    @And("user clicks on sign out link")
    public void userClicksOnSignOutLink() {
        WebElement signOutLink = driver.findElement(By.partialLinkText("Sign out"));
        assertTrue(signOutLink.isDisplayed());
        actions.click(signOutLink).perform();

    }



}
