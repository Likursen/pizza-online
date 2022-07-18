import config.SingletonWebDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class AbstractTest {
    private static final WebDriver webDriver = SingletonWebDriver.getDriver();
    private static final String URL = "https://dominos.by/";

    @Before
    public void openSite() {
        webDriver.get(URL);
    }

    @After
    public void afterTest() {
        SingletonWebDriver.driverQuit();
    }
}