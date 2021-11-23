package setup;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface IPageObject {

    WebElement getWebElement(String weName) throws NoSuchFieldException, IllegalAccessException,
            InstantiationException;

    List<WebElement> getWebElements(String elementsName) throws NoSuchFieldException,
            IllegalAccessException, InstantiationException;

}

