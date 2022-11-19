package addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class ContactCreationTests {
    private WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        wd = new ChromeDriver();
        wd.get("http://antonalekseev.ru/addressbook/");
        login("admin", "secret");
    }

    private void login(String login, String password) {
        wd.findElement(By.xpath("//input[@name='user']")).sendKeys(login);
        wd.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void testContactCreation() {
        fillContactForm(new ContactData("Michael", "V", "Jackson", "MJ", "PopStar", "Music", "NY", "NY", "+19991111111", "+19992222222", "+19993333333", "1", "January", "1900"));
        saveForm();
        logout();
    }

    private void fillContactForm(ContactData cd) {
        wd.findElement(By.xpath("//a[normalize-space()='add new']")).click();
        wd.findElement(By.name("firstname")).sendKeys(cd.getFirstname());
        wd.findElement(By.name("middlename")).sendKeys(cd.getMiddlename());
        wd.findElement(By.name("lastname")).sendKeys(cd.getLastname());
        wd.findElement(By.name("nickname")).sendKeys(cd.getNickname());
        wd.findElement(By.name("title")).sendKeys(cd.getTitle());
        wd.findElement(By.name("company")).sendKeys(cd.getCompany());
        wd.findElement(By.name("address")).sendKeys(cd.getAddress());
        wd.findElement(By.name("home")).sendKeys(cd.getHome());
        wd.findElement(By.name("mobile")).sendKeys(cd.getMobile());
        wd.findElement(By.name("work")).sendKeys(cd.getWork());
        wd.findElement(By.name("fax")).sendKeys(cd.getFax());
        Select birthdayDay = new Select(wd.findElement(By.name("bday")));
        birthdayDay.selectByVisibleText(cd.getBday());
        Select birthdayMonth = new Select(wd.findElement(By.name("bmonth")));
        birthdayMonth.selectByVisibleText(cd.getBmonth());
        wd.findElement(By.name("byear")).sendKeys(cd.getYear());
    }

    private void saveForm() {
        wd.findElement(By.name("submit")).click();
    }

    public void logout() {
        wd.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        wd.quit();
    }
}