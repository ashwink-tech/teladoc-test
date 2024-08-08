package com.teladoc.framework.controls;

import org.openqa.selenium.WebDriver;

import static com.teladoc.framework.controls.BrowserWaits.*;
import static com.teladoc.framework.helper.SeleniumHelper.*;
import static com.teladoc.framework.utilities.LogUtil.*;

@SuppressWarnings("ALL")
public class BrowserActions {

  private BrowserActions() {
     throw new IllegalStateException("BrowserActions class");
  }

  private static final String CLICK_ACTION_LOG = "Clicking on an element ";

  public static void click(WebDriver driver, String sLocator) {
    info(CLICK_ACTION_LOG + sLocator);
    getElementToClick(driver, sLocator).click();
  }

  public static void input(WebDriver driver, String inputValue, String sLocator) {
    info("Entering " + inputValue + "in an input field " + sLocator);
    getElement(driver, sLocator).sendKeys(inputValue);
  }

  public static void selectByFirstIndex(WebDriver driver, String sLocator) {
    info("Selecting First value from the dropdown " + sLocator);
      waitForDropdownOptions.accept(driver, sLocator);
      getSelect(driver, sLocator).selectByIndex(1);
  }
}
