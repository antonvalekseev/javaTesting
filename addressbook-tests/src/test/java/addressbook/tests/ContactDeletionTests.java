package addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{
    @Test
    public void testContactDeletion() {
        if (app.getContactHelper().isElementMissing(By.name("selected[]"))) {
            app.getContactHelper().createContact(new ContactData
                    ("Michael", "V", "Jackson", "MJ", "PopStar",
                            "Music", "NY", "NY", "+19991111111", "+19992222222",
                            "+19993333333", "1", "January", "1900"));
        }
        app.getContactHelper().selectFirstContactInList();
        app.getContactHelper().deleteContactAndAccept();
    }
}