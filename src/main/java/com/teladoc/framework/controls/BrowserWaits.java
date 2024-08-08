package com.teladoc.framework.controls;

import com.teladoc.framework.config.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.teladoc.framework.controls.BrowserValidation.isElementClickable;
import static com.teladoc.framework.helper.SeleniumHelper.getElement;
import static com.teladoc.framework.helper.SeleniumHelper.getSelect;
import static com.teladoc.framework.helper.WaitHelper.pollInterval;
import static java.time.Duration.ofSeconds;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BrowserWaits {

    private BrowserWaits() {
        throw new IllegalStateException("BrowserWaits class");
    }

    public static final Function<WebDriver, WebDriverWait> getLongWait =
      driver -> new WebDriverWait(driver, ofSeconds(Constants.LONG_WAIT));

    public static final Function<WebDriver, WebDriverWait> getMediumWait =
      driver -> new WebDriverWait(driver, ofSeconds(Constants.MEDIUM_WAIT));

    public static final BiConsumer<WebDriverWait, String> waitForPresence = (wait, sLocator) -> {
        wait.until(visibilityOfElementLocated(xpath(sLocator)));
        wait.until(presenceOfElementLocated(xpath(sLocator)));
      };

    public static final BiConsumer<WebDriver, String> waitMethod = (driver, sLocator) ->
        waitForPresence.accept(getLongWait.apply(driver), sLocator);

    public static final BiConsumer<WebDriver, String> waitTillElementNotPresent =
      (driver, sLocator) -> getLongWait.apply(driver)
      .until(invisibilityOfElementLocated(xpath(sLocator)));

    public static final BiConsumer<WebDriver, String> waitForClickableElement =
      (driver, sLocator) -> pollInterval
        .apply("Waiting for an element to be clickable")
        .ignoreExceptions()
        .untilAsserted(() -> assertThat(isElementClickable(driver, sLocator)).isTrue());

    public static final BiConsumer<WebDriver, String> waitForDropdownOptions =
      (driver, sLocator) -> pollInterval
        .apply("Waiting for dropdown to be present")
        .until(() -> getSelect(driver, sLocator).getOptions().size() > 1);
}
