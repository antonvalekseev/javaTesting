package learn.addressbook.tests;

import learn.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import learn.addressbook.model.ContactData;
import learn.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().isEmpty()) {
            app.group().create(new GroupData()
                    .withName("Group Name"));
        }
        app.goTo().gotoHomePage();
        if (app.contact().all().isEmpty()) {
            app.contact().create(new ContactData()
                    .withFirstname("Michael")
                    .withLastname("Jackson")
                    .withAddress("NY")
                    .withMobilephone("+19991111111")
                    .withEmail("mj@test.com")
                    .withGroup("Group Name"));
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(deletedContact)));
    }
}