package scenarios;

import org.testng.annotations.Test;
import setup.BaseTest;

import static util.TestProperties.getProperty;
import static org.assertj.core.api.Assertions.assertThat;

public class nativeMobileTests extends BaseTest {

    @Test(enabled = false, groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPo().getWebElement("signInBtn").click();
        System.out.println("Simplest Android native test done");
    }

    @Test(groups = {"native"}, description = "Register a new account, sign in and check for Budget Activity page appearance")
    public void testRegistrationSignInAreSuccessful() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPo().getWebElement("registerAccountBtn").click();
        getPo().getWebElement("registrationEmail").sendKeys(getProperty("email"));
        getPo().getWebElement("registrationName").sendKeys(getProperty("name"));
        getPo().getWebElement("registrationPass").sendKeys(getProperty("pass"));
        getPo().getWebElement("registrationConfirmPass").sendKeys(getProperty("pass"));
        getPo().getWebElement("registerNewAccountBtn").click();

        getPo().getWebElement("loginField").sendKeys(getProperty("email"));
        getPo().getWebElement("passwordField").sendKeys(getProperty("pass"));
        getPo().getWebElement("signInBtn").click();
        assertThat(getPo().getWebElement("budgetActivityBar").getText()).isEqualTo(getProperty("title"));
    }
}
