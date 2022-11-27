package addressbook.tests;

import addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("GroupName", "GroupHeader", "GroupFooter"));
        }
        app.getNavigationHelper().goToContactPage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData
                    ("Michael", "V", "Jackson", "MJ", "PopStar",
                            "Music", "NY", "NY", "+19991111111", "+19992222222",
                            "+19993333333", "1", "January", "1900"));
        }
        app.getContactHelper().selectFirstContactInList();
        app.getContactHelper().deleteContactAndAccept();
    }
}