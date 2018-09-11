package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {
        WebDriver browser;
    @FindBy(xpath = "//div[@id='resultStats']")
    WebElement counterAllResults;

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    List<WebElement> searchResults;

    public abstract boolean isLoaded();

    public String getCurrentPageTitle(){
        return browser.getTitle();
    }
    public String getCurrentPageUrl(){
        return browser.getCurrentUrl();
    }
    public WebElement waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(browser, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }
}
