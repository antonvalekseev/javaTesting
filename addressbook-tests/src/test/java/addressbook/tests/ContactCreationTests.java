package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.annotations.*;
import addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("GroupName", "GroupHeader", "GroupFooter"));
        }
        app.getNavigationHelper().goToContactPage();
        app.getContactHelper().createContact(new ContactData("Michael", "V", "Jackson",
                "MJ", "PopStar", "Music", "NY", "NY", "+19991111111",
                "+19992222222", "+19993333333", "1", "January", "1900"));
        app.logout();
    }
}