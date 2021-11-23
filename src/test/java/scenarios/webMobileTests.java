package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.WebPageObject;
import setup.BaseTest;
import util.DataProviderForWeb;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class webMobileTests extends BaseTest {

    @Test(enabled = false, groups = {"web"}, description = "Make sure that we've opened IANA homepage")
    public void simpleWebTest() throws InterruptedException {
        getDriver().get("http://iana.org"); // open IANA homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        // Check IANA homepage title
        assert ((WebDriver) getDriver()).getTitle().equals("Internet Assigned Numbers Authority") : "This is not IANA homepage";

        // Log that test finished
        System.out.println("Site opening done");
    }

    @Test(groups = {"web"}, description = "Google search test with some data input",
            dataProvider = "dataProviderForWebTest", dataProviderClass = DataProviderForWeb.class)
    public void testGoogleSearch(String url, String keyWord) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getDriver().get(url);
        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        WebPageObject webPageObject = new WebPageObject(getDriver());
        final WebElement searchField = webPageObject.getSearchField();
        searchField.click();
        searchField.sendKeys(keyWord, Keys.ENTER);
        List<WebElement> searchResults = webPageObject.getSearchResults();
        assertTrue(searchResults
                .stream()
                .anyMatch(r -> r.getText().contains(keyWord)));
    }
}
