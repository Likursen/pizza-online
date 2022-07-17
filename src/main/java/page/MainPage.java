package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    @FindBy(xpath = "//button[@class='jss85 jss78 custom-modal__close-cta']")
    private WebElement popupBannerLocator;

    public AbstractPage closePopupBanner() {
        popupBannerLocator.click();
        return this;
    }
}