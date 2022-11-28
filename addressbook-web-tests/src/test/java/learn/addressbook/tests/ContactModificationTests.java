package learn.addressbook.tests;

import learn.addressbook.model.ContactData;
import learn.addressbook.model.Contacts;
import learn.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase{

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
                    .withMobile("+19991111111")
                    .withEmail("mj@test.com")
                    .withGroup("Group Name"));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifyContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifyContact.getId())
                .withFirstname("Michael_UPD")
                .withLastname("Jackson_UPD")
                .withAddress("NY_UPD")
                .withMobile("+19997777777")
                .withEmail("mj_UPD@test.com")
                .withGroup("Group Name");
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
    }
}
