package pages.teladoc.webtables;

import com.teladoc.framework.exceptionhandling.TelaDocCustomException;
import io.cucumber.datatable.DataTable;
import org.apache.commons.collections4.map.MultiKeyMap;
import pages.BasePage;

import java.util.Map;

import static com.teladoc.framework.controls.BrowserActions.*;
import static com.teladoc.framework.controls.BrowserValidation.isDisplayed;
import static com.teladoc.framework.helper.CucumberHelper.*;

public class AddUser extends BasePage<AddUser> {

    private static MultiKeyMap<String, String> addUserMultiLocs = new MultiKeyMap<>();

    @Override
    protected void isLoaded() {
        if (!isDisplayed(driver, IP_FIRST_NAME)) {
            throw new TelaDocCustomException("Add User pop up was not successfully loaded");
        }
    }

    public void addUser(DataTable userDetails) {
        for (Map<String, String> dataTableColumns : getDataTable(userDetails)) {
            enterValue(dataTableColumns.get("Username"), IP_FIRST_NAME);
            enterValue(dataTableColumns.get("Lastname"), IP_LAST_NAME);
            enterValue(dataTableColumns.get("Username"), IP_USER_NAME);
            enterValue(dataTableColumns.get("Password"), IP_PASSWORD);
            click(driver, RO_COMPANY);
            selectByFirstIndex(driver, DD_ROLE);
            enterValue(dataTableColumns.get("Email"), IP_EMAIL);
            enterValue(dataTableColumns.get("Phone"), IP_PHONE);
        }
        click(driver, BTN_SAVE);

    }

    @Override
    public String getLocators(String locator, String elementType) {
        return addUserMultiLocs.get(locator, elementType);
    }

    private static final String IP_FIRST_NAME = "//input[@name='FirstName']";
    private static final String IP_LAST_NAME  = "//input[@name='LastName']";
    private static final String IP_USER_NAME  = "//input[@name='UserName']";
    private static final String IP_PASSWORD  = "//input[@name='Password']";
    private static final String RO_COMPANY  = " //input[@value='15']";
    private static final String DD_ROLE = "//select[@name='RoleId']";
    private static final String IP_EMAIL = "//input[@name='Email']";
    private static final String IP_PHONE = "//input[@name='Mobilephone']";
    private static final String BTN_SAVE = "//button[contains(@ng-click,'save')]";
}
