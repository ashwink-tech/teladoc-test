package steps.webtables;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.teladoc.webtables.WebTable;

import static com.teladoc.framework.browser.Browser.*;
import static com.teladoc.framework.controls.BrowserValidation.isElementNotPresent;
import static org.assertj.core.api.Assertions.assertThat;

public class WebTableSteps {

    WebTable webTable;
    public WebTableSteps(WebTable webTable) {
        this.webTable = webTable.get();
    }

    @When("The user clicks on {string}:{string} on WebTable Page")
    public void clickOnElement(String locator, String elementType) {
        webTable.clickOnElement(locator, elementType);
    }

    @Then("Verify {string}:{string} {string} is present on WebTable Page")
    public void verifyTextPresent(String locator, String elementType, String text) {
        webTable.isEqualTo(locator, elementType, text);
    }

    @Then("Verify {string}:{string} is not present on WebTable Page")
    public void elementNotPresent(String locator, String elementType) {
        assertThat(isElementNotPresent(getDriver.get(),
           webTable.getLocators(locator, elementType))).isTrue();
    }
}
