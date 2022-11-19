package addressbook.tests;

import org.testng.annotations.*;
import addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().fillContactForm(new ContactData("Michael", "V", "Jackson", "MJ", "PopStar", "Music", "NY", "NY", "+19991111111", "+19992222222", "+19993333333", "1", "January", "1900"));
        app.saveForm();
        app.logout();
    }
}