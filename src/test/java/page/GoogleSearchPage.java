package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage extends BasePage {
    @FindBy(xpath = "//input[@name='q']")
    WebElement queryField;

    public GoogleSearchPage(WebDriver browser){
    this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public boolean isLoaded() {
        return queryField.isDisplayed()
                &&getCurrentPageTitle().contains("Google")
                &&getCurrentPageUrl().contains("google.com");
    }

    public GoogleSearchResultPage enterSearchTerm(String searchTerm) {
        queryField.sendKeys(searchTerm);
        queryField.sendKeys(Keys.ENTER);
        return new GoogleSearchResultPage(browser);
    }
}
