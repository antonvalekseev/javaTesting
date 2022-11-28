package learn.addressbook.tests;

import learn.addressbook.model.ContactData;
import learn.addressbook.model.Contacts;
import learn.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().isEmpty()) {
            app.group().create(new GroupData()
                    .withName("Group Name"));
        }
    }

    @Test
    public void testContactCreation() {
        app.goTo().gotoHomePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("Michael")
                .withLastname("Jackson")
                .withAddress("NY")
                .withMobile("+19991111111")
                .withEmail("mj@test.com")
                .withGroup("Group Name");
        app.contact().create(contact);
        app.goTo().gotoHomePage();
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((cont) -> cont.getId()).max().getAsInt()))));
    }
}