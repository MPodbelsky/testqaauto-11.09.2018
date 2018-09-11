package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.GoogleSearchPage;

public class BaseTest {
    private WebDriver browser;
    GoogleSearchPage googleSearchPage;
    @BeforeMethod
    @Parameters("browserName")
    public void beforeMethod(@Optional("chrome")String browserName){
        if (browserName.toLowerCase().equals("chrome")){
            browser = new ChromeDriver();
        }
        if (browserName.toLowerCase().equals("firefox")) {
            browser = new FirefoxDriver();
        }
        browser.get("https://www.google.com/");
        googleSearchPage = new GoogleSearchPage(browser);
    }

    @AfterMethod
    public void afterMethod(){
        browser.close();
    }

}
