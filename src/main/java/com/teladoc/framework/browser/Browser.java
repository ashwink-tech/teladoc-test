package com.teladoc.framework.browser;

import com.teladoc.framework.utilities.LogUtil;
import org.openqa.selenium.WebDriver;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Browser {

  private Browser() {
    throw new IllegalStateException("Browser class");
  }

  private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

  private static final Consumer<WebDriver> setDriver = webDriver::set;

  public static final Supplier<WebDriver> getDriver = webDriver::get;

  public static final Consumer<String> setBrowser =
    browser -> {
         LogUtil.info("Setting the WebDriver for " + browser + " Browser");
         var driver = BrowserType.getDriver.apply(browser);
         setDriver.accept(driver);
  };
  
  public static void removeWebdriver() {
    webDriver.remove();
  }
}
