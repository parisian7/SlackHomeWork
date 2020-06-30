package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SlackHomePage {

    public SlackHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='ql-editor ql-blank']")
    public WebElement messageArea;

    @FindBy(xpath = "//div[@class='p-rich_text_section']")
    public List<WebElement> userMassages;

    @FindBy(xpath = "//button[@aria-label='Send message']")
    public WebElement sendButton;

    @FindBy(xpath = "//span[.='api_channel']")
    public WebElement apiChannel;
}
