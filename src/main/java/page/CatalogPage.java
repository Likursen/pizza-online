package page;

import enums.Categories;
import enums.ProductType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CatalogPage extends AbstractPage {
    @FindBy(xpath = "//button[@class='jss85 jss78 custom-modal__close-cta']")
    private WebElement popupBanner;
    @FindBy(xpath = "//button[@class='custom-button custom-button--secondary custom-button--size-medium cart-button__button']")
    private WebElement shoppingCart;
    @FindBy(xpath = "//div[@class='order-products__added-products']//descendant::div[@class='product-card__title']")
    private List<WebElement> ordersPositionFromShoppingCart;

    public CatalogPage addToShoppingCart(ProductType type) {
        String xpathPattern = "//div[@data-code='%s']//descendant::button[@data-action='a2b']";
        String xpath = String.format(xpathPattern, type.getXpathValue());
        webDriver.findElement(By.xpath(xpath))
                .click();
        return this;
    }

    public CatalogPage openCategory(Categories category) {
        String xpathCategoryValue = category.getXpathValue();
        String xpathPattern = "//a[@href='/%s']";
        String xpath = String.format(xpathPattern, xpathCategoryValue);
        webDriver.findElement(By.xpath(xpath))
                .click();
        return this;
    }

    public CatalogPage openShoppingCart() {
        shoppingCart.click();
        return this;
    }

    public CatalogPage closePopupBanner() {
        popupBanner.click();
        return this;
    }

    public List<ProductType> getOrderPositionFromShoppingCart() {
        List<ProductType> ordersPositionName = new ArrayList<>();
        for (WebElement position : ordersPositionFromShoppingCart) {
            String positionName = position.getText();
            ordersPositionName.add(getOrderPositionType(positionName));
        }
        return ordersPositionName;
    }

    private ProductType getOrderPositionType(String name) {
        for (ProductType value : ProductType.values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }
}