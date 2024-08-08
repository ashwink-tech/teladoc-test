package com.teladoc.framework.helper;

import com.teladoc.framework.controls.BrowserWaits;
import com.teladoc.framework.utilities.LogUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static com.teladoc.framework.utilities.LogUtil.info;
import static org.openqa.selenium.By.xpath;

public class SeleniumHelper {

  private SeleniumHelper() {
    throw new IllegalStateException("SeleniumHelper class");
  }

  public static WebElement getElement(WebDriver driver, String sLocator) {
    LogUtil.info("Waiting for an element " + sLocator);
    return findElement(driver, sLocator);
  }

  public static WebElement getElementToClick(WebDriver driver, String sLocator) {
    BrowserWaits.waitForClickableElement.accept(driver, sLocator);
    return findElement(driver, sLocator);
  }

  public static WebElement findElement(WebDriver driver, String sLocator) {
    BrowserWaits.waitMethod.accept(driver, sLocator);
    return driver.findElement(xpath(sLocator));
  }

  public static Select getSelect(WebDriver driver, String sLocator) {
    return new Select(getElement(driver, sLocator));
  }

  public static List<WebElement> getElementsWithoutWait(WebDriver driver, String sLocator) {
    return driver.findElements(xpath(sLocator));
  }
  public static ChromeOptions getChromeOptions() {
    return new ChromeOptions();
  }
}
