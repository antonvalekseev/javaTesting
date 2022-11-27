package addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("GroupName", "GroupHeader", "GroupFooter"));
        }
        app.getGroupHelper().deleteGroup();
        app.returnToGroupPageAndLogout();
    }
}