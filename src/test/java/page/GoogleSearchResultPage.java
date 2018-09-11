package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultPage extends BasePage{
    @FindBy(xpath = "//a[@aria-label='Page 2']")
    WebElement linkToPageTwo;

    public GoogleSearchResultPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible (counterAllResults, 10);
    }

    public boolean isLoaded() {
        return counterAllResults.isDisplayed()
                &&getCurrentPageTitle().contains("Selenium - Поиск в Google")
                &&getCurrentPageUrl().contains("https://www.google.com/search");
    }
    public int getSearchResultCount(){
        return searchResults.size();
    }
    public List<String> getSearchResultsList() {
        List<String> searchResultList = new ArrayList<String>();
        for (WebElement searchResult: searchResults){
            ((JavascriptExecutor)browser).executeScript("arguments[0].scrollIntoView();", searchResult);
            searchResultList.add(searchResult.getText());
        }
        return searchResultList;
    }

    public GoogleSearchResultPage clickNext() {
        linkToPageTwo.click();
        return new GoogleSearchResultPage(browser);
    }
}
