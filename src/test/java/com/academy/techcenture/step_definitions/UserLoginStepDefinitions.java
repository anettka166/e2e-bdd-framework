package com.academy.techcenture.step_definitions;

import com.academy.techcenture.config.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.UserAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class UserLoginStepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private UserAccountPage userAccountPage;

    @Before
    public  void setUp(){
        driver = Driver.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        userAccountPage = new UserAccountPage(driver);
    }


    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        homePage.navigateToHomePage();
    }

    @When("user clicks on the sigh in link")
    public void user_clicks_on_the_sigh_in_lonk() {
        homePage.clickSingInLink();
    }

    @When("user should be navigated to login screen")
    public void user_should_be_navigated_to_login_screen() {
        loginPage.verifyUserIsOnLoginPage();
    }

    @And("user enters valid username and password in the credentials input")
    public void userEntersCredentials() {
      loginPage.enterUserName();
      loginPage.enterPassword();
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
     loginPage.clickOnLoginBtn();
    }

    @When("user should be navigated to account page")
    public void user_should_be_navigated_to_account_page() {
       userAccountPage.verifyUserIsOnAccountPage();
       userAccountPage.verifyAccountOptions();
    }

    @Then("user should be able to see {string} name on top")
    public void user_should_be_able_to_see_their_name_on_top(String userName) {
        userAccountPage.verifyUserName(userName);
    }

    @And("user clicks on sign out link")
    public void userClicksOnSignOutLink() {
       userAccountPage.signOut();
    }

    @After
    public void cleanUp(){
        if (driver != null){
            driver.quit();
        }
    }

}
