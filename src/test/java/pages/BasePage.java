package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.teladoc.framework.browser.Browser.getDriver;
import static com.teladoc.framework.controls.BrowserActions.click;
import static com.teladoc.framework.controls.BrowserActions.input;
import static com.teladoc.framework.utilities.LogUtil.info;
import static com.teladoc.framework.utilities.WebElementAssertUtility.asserts;

public abstract class BasePage<T extends BasePage<T>> extends LoadableComponent<T> {

  protected WebDriver driver;

  public BasePage() {
    this.driver = getDriver.get();
  }

  public String getLocators(String locator, String elementType) {
    return "";
  }

  public void clickOnElement(String locator, String elementType) {
    click(driver, getLocators(locator, elementType));
  }

  public void enterValue(String value, String locator) {
    input(driver, value, locator);
  }

  public void isEqualTo(String locator, String elementType, String text) {
    info("checking if " + text + " is present in " + locator);
    asserts(getLocators(locator, elementType)).isEqualTo(text);
  }

  @Override
  protected void load() {}

  @Override
  protected void isLoaded() throws Error {}
}
