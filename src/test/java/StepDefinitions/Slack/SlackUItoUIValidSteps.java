package StepDefinitions.Slack;

import Pages.SlackHomePage;
import Pages.SlackLoginPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class SlackUItoUIValidSteps {



    WebDriver driver= Driver.getDriver();
    SlackHomePage slackHomePage = new SlackHomePage(driver);
    SlackLoginPage loginPage=new SlackLoginPage(driver);
    public static String copy;



    @Given("User navigates to Slack WebApp")
    public void user_navigates_to_Slack_WebApp() {
       driver.get(ConfigReader.getProperty("slackURL"));
        loginPage.signInButton.click();
        loginPage.urlPlace.sendKeys(ConfigReader.getProperty("batch4"));
        loginPage.continueButton.click();
        loginPage.email.sendKeys(ConfigReader.getProperty("email"));
        loginPage.password.sendKeys(ConfigReader.getProperty("password"));
        loginPage.signInButton2.click();
        slackHomePage.apiChannel.click();
    }

    @When("User Sends a massage with Selenium {string}")
    public void user_Sends_a_massage_with_Selenium(String message) {
    slackHomePage.messageArea.sendKeys(message);
    slackHomePage.sendButton.click();
    copy=message;
    }

    @Then("User Validates the massage is as expected")
    public void user_Validates_the_massage_is_as_expected() throws InterruptedException {
        Thread.sleep(3000);
       String actual= slackHomePage.userMassages.get(slackHomePage.userMassages.size()-1).getText();
       String expected=copy;
        Assert.assertEquals(expected,actual);
    }

}
