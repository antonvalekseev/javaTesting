package addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("GroupName", "GroupHeader", "GroupFooter"));
        }
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("GroupNameUpdated", "HeaderUpdated", "FooterUpdated"));
        app.getGroupHelper().submitGroupModification();
    }
}