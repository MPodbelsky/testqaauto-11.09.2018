package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleSearchResultPage;
import page.GoogleSearchResultPageTwo;

import java.util.List;


public class GoogleSearchTest extends BaseTest {
    @Test
    public void basicSearchTest() {
        Assert.assertTrue(googleSearchPage.isLoaded(), "Google search page is not loaded");
        GoogleSearchResultPage googleSearchResultPage = googleSearchPage.enterSearchTerm("Selenium");
        Assert.assertTrue(googleSearchResultPage.isLoaded(), "Google search result page is not loaded");
        String serchTerm = "selenium";
        List<String> searchResults = googleSearchResultPage.getSearchResultsList();
        for (String searchResult : searchResults) {
            Assert.assertTrue(searchResult.toLowerCase().contains(serchTerm), "searchTerm" + "not found in:  \n" + searchResult);
        }
        Assert.assertEquals(googleSearchResultPage.getSearchResultCount(), 9, "Search results count is wrong");

        GoogleSearchResultPageTwo googleSearchResultPageTwo = googleSearchResultPage.clickNext();
        List<String> searchResultsTwo = googleSearchResultPageTwo.getSearchResultsList();
        for (String searchResult : searchResultsTwo) {
            Assert.assertTrue(searchResult.toLowerCase().contains(serchTerm), "searchTerm" + "not found in:  \n" + searchResult);
        }
        Assert.assertEquals(googleSearchResultPageTwo.getSearchResultCount(), 10, "Search results count is wrong");
    }
}
