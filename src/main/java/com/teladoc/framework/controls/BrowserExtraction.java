package com.teladoc.framework.controls;

import org.openqa.selenium.logging.LogEntry;

import java.util.List;

import static com.teladoc.framework.browser.Browser.getDriver;
import static com.teladoc.framework.utilities.LogUtil.info;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class BrowserExtraction {

  private BrowserExtraction() {
    throw new IllegalStateException("BrowserExtraction class");
  }

  public static List<LogEntry> getConsoleLogs() {
    info("Getting the Console Log Errors");
    return getDriver.get().manage().logs().get(BROWSER).getAll();
  }
}
