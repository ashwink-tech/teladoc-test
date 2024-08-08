package com.teladoc.framework.utilities;

import com.teladoc.framework.helper.SeleniumHelper;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

import static com.teladoc.framework.browser.Browser.getDriver;

public class WebElementAssertUtility extends AbstractAssert<WebElementAssertUtility, WebElement> {

  public WebElementAssertUtility(String locator) {
    super(SeleniumHelper.getElement(getDriver.get(), locator), WebElementAssertUtility.class);
  }

  public static WebElementAssertUtility asserts(String locator) {
    return new WebElementAssertUtility(locator);
  }

  public WebElementAssertUtility isEqualTo(String text) {
    isNotNull();
    if (!actual.getText().equals(text)) {
      failWithMessage("Expected text " + text + "is not equal to " + actual.getText());
    }
    return this;
  }
}
