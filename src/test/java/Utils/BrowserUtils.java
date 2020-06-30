package Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.sql.Driver;
import java.time.Duration;
import java.util.Set;
public class BrowserUtils {
    public static void switchWindowByTitle(WebDriver driver, String targetTitle) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!driver.getTitle().equals(targetTitle)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchWindowByUrl(WebDriver driver, String url) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!driver.getCurrentUrl().contains(url)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void closeWindows(WebDriver driver, String parentId) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!id.equals(parentId)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
    }
    //CREATE A METHOD FOR FLUENT WAIT
    public static WebElement fluentWait(WebDriver driver,long totalSec,long pollingSecond,By locator){

        Wait<WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(totalSec))
                .pollingEvery(Duration.ofSeconds(pollingSecond))
                .ignoring(RuntimeException.class);

        return wait.until(driver1 -> driver1.findElement(By.xpath("")));
    }
    public static WebElement visibilityOf(int timeInSec,WebElement element){
        WebDriverWait wait=new WebDriverWait(Utils.Driver.getDriver(),timeInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement visibilityOfElementLocated(int timeInSec,By locator){

        WebDriverWait wait=new WebDriverWait(Utils.Driver.getDriver(),timeInSec);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}