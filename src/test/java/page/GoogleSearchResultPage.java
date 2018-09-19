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
    private WebElement linkToNextPage;

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement counterAllResults;

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResults;


    public GoogleSearchResultPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible (counterAllResults, 10);
    }

    public boolean isLoaded() {
        return counterAllResults.isDisplayed()
                &&getCurrentPageTitle().toLowerCase().contains("selenium")
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
        linkToNextPage.click();
        return new GoogleSearchResultPage(browser);
    }
}
