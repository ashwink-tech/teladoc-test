package steps.webtables;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.teladoc.webtables.AddUser;

public class AddUserSteps {

    AddUser addUser;

    public  AddUserSteps(AddUser addUser) {
        this.addUser = addUser.get();
    }

    @When("The user adds the user to the table")
    public void addUserToTable(DataTable table) {
        addUser.addUser(table);
    }
}
