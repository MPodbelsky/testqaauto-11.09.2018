package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.GoogleSearchPage;

public class BaseTest {
    private WebDriver browser;
    GoogleSearchPage googleSearchPage;
    @BeforeMethod
    public void beforeMethod(){
        browser = new FirefoxDriver();
        browser.get("https://www.google.com/");
        googleSearchPage = new GoogleSearchPage(browser);
    }

    @AfterMethod
    public void afterMethod(){
        browser.close();
    }

}
