package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebPageObject extends PageObject {

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;
    @FindBy(xpath = "//div[@id='rso']/div")
    List<WebElement> searchResult;

    public WebElement getSearchField() {
        return searchField;
    }

    public List<WebElement> getSearchResults() {
        return searchResult;
    }

    public WebPageObject(AppiumDriver<? extends WebElement> appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }
}
