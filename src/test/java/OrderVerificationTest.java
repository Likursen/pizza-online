import enums.Categories;
import enums.DrinkType;
import enums.PizzaType;
import org.junit.Assert;
import org.junit.Test;
import page.DrinksPage;
import page.MainPage;
import page.PizzaPage;
import utils.Utilities;

import java.util.Arrays;
import java.util.List;

public class OrderVerificationTest extends AbstractTest {

    @Test
    public void orderVerification() {
        MainPage mainPage = new MainPage();
        mainPage.closePopupBanner()
                .openCategory(Categories.PIZZA);
        PizzaPage pizzaPage = new PizzaPage();
        pizzaPage.addToShoppingCart(PizzaType.MARGARITA)
                .openCategory(Categories.DRINKS);
        Utilities.sleep(2);
        DrinksPage drinksPage = new DrinksPage();
        drinksPage.addToShoppingCart(DrinkType.COCA_COLA_1L);
        List<String> actualOrderPositionName = drinksPage.openShoppingCart()
                .getOrderPositionNameFromShoppingCart();
        List<String> expectedOrderPositionName = Arrays.asList(PizzaType.MARGARITA.getName(), DrinkType.COCA_COLA_1L.getName());
        Assert.assertEquals(expectedOrderPositionName, actualOrderPositionName);
    }
}