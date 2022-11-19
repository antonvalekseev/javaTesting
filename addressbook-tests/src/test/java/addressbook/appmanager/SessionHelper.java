package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends BaseHelper {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String login, String password) {
        type(By.xpath("//input[@name='user']"), login);
        type(By.xpath("//input[@name='pass']"), password);
        click(By.xpath("//input[@value='Login']"));
    }
}