package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonHomePage {

    public AmazonHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "a")
    public List<WebElement> links;

}
