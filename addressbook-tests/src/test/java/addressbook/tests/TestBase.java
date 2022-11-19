package addressbook.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import addressbook.appmanager.ApplicationManager;

public class TestBase {
    public final ApplicationManager app = new ApplicationManager(Browser.EDGE);

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }
}