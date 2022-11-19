package addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        if (app.getGroupHelper().isElementMissing(By.name("selected[]"))) {
            app.getGroupHelper().createGroup(new GroupData("GroupToDelete", "GroupHeaderToDelete", "GroupFiiterToDelete"));
        }
        app.getGroupHelper().deleteGroup();
        app.returnToGroupPageAndLogout();
    }
}