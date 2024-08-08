package com.teladoc.framework.browser;

import com.teladoc.framework.helper.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.lang.System.setProperty;
import static java.util.Map.of;
import static org.openqa.selenium.PageLoadStrategy.NORMAL;


public class BrowserType {

  private BrowserType() {
       throw new IllegalStateException("BrowserType class");
    }
    private static final String silentLog = "webdriver.chrome.silentOutput";

    private static final Supplier<WebDriver> chromeDriverSupplier =
      () -> {
        var chromeOptions = SeleniumHelper.getChromeOptions();
        chromeOptions.setPageLoadStrategy(NORMAL);
        setProperty(silentLog, "true");
        return new ChromeDriver(chromeOptions);
      };

  private static final Map<String, Supplier<WebDriver>> browserDrivers =
      of("Chrome", chromeDriverSupplier);

  // return a new driver from the map
  public static final Function<String, WebDriver> getDriver =
      browser -> browserDrivers.get(browser).get();
}
