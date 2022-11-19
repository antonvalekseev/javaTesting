package addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        app.getContactHelper().selectFirstContactInList();
        app.getContactHelper().deleteContactAndAccept();
    }
}