package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import addressbook.model.GroupData;

public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void fillGroupForm(GroupData gd) {
        type(By.name("group_name"), gd.getName());
        type(By.name("group_header"), gd.getHeader());
        type(By.name("group_footer"), gd.getFooter());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
        click(By.linkText("groups"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void deleteGroup() {
        click(By.name("selected[]"));
        click(By.name("delete"));
    }

    public void createGroup(GroupData gd) {
        initGroupCreation();
        fillGroupForm(gd);
        submitGroupCreation();
    }
}