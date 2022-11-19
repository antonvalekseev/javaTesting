package addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();
        if (app.getGroupHelper().isElementMissing(By.name("selected[]"))) {
            app.getGroupHelper().createGroup(new GroupData("GroupToDelete", "GroupHeaderToDelete", "GroupFiiterToDelete"));
        }
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("GroupNameUpdated", "HeaderUpdated", "FooterUpdated"));
        app.getGroupHelper().submitGroupModification();
    }
}