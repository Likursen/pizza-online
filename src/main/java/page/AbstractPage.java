package page;

import config.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    protected final static WebDriver webDriver = SingletonWebDriver.getDriver();

    public AbstractPage() {
        PageFactory.initElements(webDriver, this);
    }
}