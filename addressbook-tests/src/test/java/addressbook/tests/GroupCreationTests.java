package addressbook.tests;

import org.testng.annotations.*;
import addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("GroupName", "GroupHeader", "GroupFooter"));
        app.getGroupHelper().deleteGroup();
        app.returnToGroupPageAndLogout();
    }
}