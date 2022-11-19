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

    public void fillGroupForm(GroupData gd) {
        type(By.name("group_name"), gd.getName());
        type(By.name("group_header"), gd.getHeader());
        type(By.name("group_footer"), gd.getFooter());
        click(By.name("submit"));
        click(By.linkText("groups"));
    }

    public void deleteGroup() {
        click(By.name("selected[]"));
        click(By.name("delete"));
    }
}