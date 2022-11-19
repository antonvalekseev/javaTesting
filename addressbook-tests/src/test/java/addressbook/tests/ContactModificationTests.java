package addressbook.tests;

import org.testng.annotations.Test;
import addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().openExistingContact();
        app.getContactHelper().fillContactForm(new ContactData("Michael_Upd", "V_Upd",
                "Jackson_Upd", "MJ_Upd", "PopStar_Upd", "Music_Upd",
                "NY_Upd", "NY_Upd", "+19997777777", "+19998888888",
                "+19999999999", "31", "December", "1999"));
        app.saveForm();
    }
}