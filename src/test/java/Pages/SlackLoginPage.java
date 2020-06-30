package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SlackLoginPage {
    public SlackLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//a[.='Sign in'])[1]")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@class='input_inline align_right small_right_margin team_name_input']")
    public WebElement urlPlace;
    @FindBy(xpath = "//button[@id='submit_team_domain']")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@id='signin_btn']")
    public WebElement signInButton2;


}
