package addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class GroupCreationTests {
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
    public void testGroupCreation() throws Exception {
        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("Gname", "Gheader", "Gfooter"));
        deleteAnyCreatedGroup();
        returnToGroupPageAndLogout();
    }

    private void goToGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    private void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    private void fillGroupForm(GroupData gd) {
        wd.findElement(By.name("group_name")).sendKeys(gd.getName());
        wd.findElement(By.name("group_header")).sendKeys(gd.getHeader());
        wd.findElement(By.name("group_footer")).sendKeys(gd.getFooter());
        wd.findElement(By.name("submit")).click();
        wd.findElement(By.linkText("groups")).click();
    }

    private void deleteAnyCreatedGroup() {
        wd.findElement(By.name("selected[]")).click();
        wd.findElement(By.name("delete")).click();
    }

    private void returnToGroupPageAndLogout() {
        wd.findElement(By.linkText("groups")).click();
        wd.findElement(By.linkText("Logout")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();
    }
}