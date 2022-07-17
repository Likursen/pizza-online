package page;

import config.SingletonWebDriver;
import enums.Categories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AbstractPage {
    protected final static WebDriver webDriver = SingletonWebDriver.getDriver();
    @FindBy(xpath = "//button[@class='custom-button custom-button--secondary custom-button--size-medium cart-button__button']")
    private WebElement shoppingCart;
    @FindBy(xpath = "//div[@class='order-products__added-products']//descendant::div[@class='product-card__title']")
    private List<WebElement> ordersPositionFromShoppingCart;

    public AbstractPage() {
        PageFactory.initElements(webDriver, this);
    }

    protected AbstractPage addToShoppingCart(String xpathValue) {
        String xpathPattern = "//div[@data-code='%s']//descendant::button[@data-action='a2b']";
        String xpath = String.format(xpathPattern, xpathValue);
        webDriver.findElement(By.xpath(xpath))
                .click();
        return this;
    }

    public void openCategory(Categories category) {
        String xpathCategoryValue = category.getXpathValue();
        String xpathPattern = "//a[@href='/%s']";
        String xpath = String.format(xpathPattern, xpathCategoryValue);
        webDriver.findElement(By.xpath(xpath))
                .click();
    }

    public AbstractPage openShoppingCart() {
        shoppingCart.click();
        return this;
    }

    public List<String> getOrderPositionNameFromShoppingCart() {
        List<String> ordersPositionName = new ArrayList<String>();
        for (WebElement position : ordersPositionFromShoppingCart) {
            ordersPositionName.add(position.getText());
        }
        return ordersPositionName;
    }
}