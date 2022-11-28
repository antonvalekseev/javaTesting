package learn.addressbook.tests;

import learn.addressbook.model.ContactData;
import learn.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testsContactCreation() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("GroupName", "GroupHeader", "GroupFooter"));
        }
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().gotoAddContactFormPage();
        ContactData contact = new ContactData("Michael", "Jackson", "NY", "+19991111111",
                "mj@test.com", "GroupName");
        app.getContactHelper().fillContactForm(contact,true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomepage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (contact1, contact2) -> Integer.compare(contact1.getId(), contact2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}