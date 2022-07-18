import enums.Categories;
import enums.ProductType;
import org.junit.Assert;
import org.junit.Test;
import page.CatalogPage;
import utils.Utilities;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

    public class OrderVerificationTest extends AbstractTest {

        @Test
        public void OrderVerification() {
            CatalogPage catalogPage = new CatalogPage();
            catalogPage.closePopupBanner()
                    .openCategory(Categories.PIZZA)
                    .addToShoppingCart(ProductType.MARGARITA)
                    .openCategory(Categories.DRINKS);
            Utilities.sleep(2);
            catalogPage.addToShoppingCart(ProductType.COCA_COLA_1L);
            List<ProductType> actualPosition = catalogPage.openShoppingCart()
                    .getOrderPositionFromShoppingCart();
            List<ProductType> expectedPosition = Arrays.asList(ProductType.MARGARITA, ProductType.COCA_COLA_1L);
            actualPosition.sort(Comparator.naturalOrder());
            expectedPosition.sort(Comparator.naturalOrder());
            Assert.assertEquals(expectedPosition, actualPosition);
        }
    }