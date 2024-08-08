package pages.teladoc.webtables;

import com.teladoc.framework.exceptionhandling.TelaDocCustomException;
import org.apache.commons.collections4.map.MultiKeyMap;
import pages.BasePage;

import static com.teladoc.framework.config.Constants.*;
import static com.teladoc.framework.controls.BrowserNavigation.*;
import static com.teladoc.framework.controls.BrowserValidation.*;
import static com.teladoc.framework.factories.GetBaseUrlFactory.*;


public class WebTable extends BasePage<WebTable> {

    private static MultiKeyMap<String, String> webTableMultiLocs = new MultiKeyMap<>();

    public WebTable() {
        navigateToUrl.accept(driver, getBaseUrl());
    }

    @Override
    protected void isLoaded() {
        if (!isDisplayed(driver, getLocators("Add", BUTTON))) {
            throw new TelaDocCustomException("Web Table was not successfully loaded");
        }
    }

    @Override
    public String getLocators(String locator, String elementType) {
        return webTableMultiLocs.get(locator, elementType);
    }

    static {
        webTableMultiLocs.put("Add", BUTTON, "//button[@type='add']");
        webTableMultiLocs.put("Delete", BUTTON, "//button[contains(@ng-click,'delUser')]");
        webTableMultiLocs.put("First Name", TEXT, "//td[@class='smart-table-data-cell']");
        webTableMultiLocs.put("Delete Specific User", BUTTON, "//td[text()='novak']//following-sibling::td/button[contains(@ng-click, 'delUser')]");
        webTableMultiLocs.put("User Name Novak", TEXT, "//td[text()='novak' and @class='smart-table-data-cell']");
        webTableMultiLocs.put("Ok", BUTTON, "//button[text()='OK']");
    }
}
