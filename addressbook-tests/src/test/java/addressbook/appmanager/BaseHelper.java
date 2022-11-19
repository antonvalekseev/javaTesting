package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseHelper {
    public WebDriver wd;

    public BaseHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String login) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(login);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void select(By locator, String visibleText) {
        Select selector = new Select(wd.findElement(locator));
        selector.selectByVisibleText(visibleText);
    }
}