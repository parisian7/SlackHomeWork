package StepDefinitions.Amazon;

import Pages.AmazonHomePage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AmazonLinkVerSteps {
    WebDriver driver= Driver.getDriver();
    AmazonHomePage amazonHomePage= new AmazonHomePage(driver);
    List<String> linkList=new ArrayList<>();
    List<String> successfulUrls=new ArrayList<>();
    @Given("User navigates to Amazon HomePage")
    public void user_navigates_to_Amazon_HomePage() {
        driver.get(ConfigReader.getProperty("amazonUrl"));

    }


    @When("User gets all Urls from Amazon homePage")
    public void user_gets_all_Urls_from_Amazon_homePage() {
        
        for (WebElement link :
                amazonHomePage.links) {

            if(link.getAttribute("href")!=null){
                linkList.add(link.getAttribute("href"));

            }
        }
    }

    @Then("User Validates if links are broken and store")
    public void user_Validates_if_links_are_broken_and_store() {

        for (String url :
                linkList) {
            
        
        try {
            //Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
            URL link = new URL(url);
            // Create a connection using URL object (i.e., link)
            HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
            //Set the timeout for 2 seconds
            httpConn.setConnectTimeout(2000);
            //connect using connect method
            httpConn.connect();
            //use getResponseCode() to get the response code. 
            if(httpConn.getResponseCode()== 200) {
                successfulUrls.add(url);
            }
//            if(httpConn.getResponseCode()== 404) {
//                System.out.println(url+" - "+httpConn.getResponseMessage());
//            }
        }
        //getResponseCode method returns = IOException - if an error occurred connecting to the server. 
        catch (Exception e) {
            //e.printStackTrace();
        }
    }
    }

    @Then("User printOuts the working links")
    public void user_printOuts_the_working_links() {
        for (String url :
                successfulUrls) {
            System.out.println(url);
        }
    }

}
