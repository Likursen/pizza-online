package page;

import enums.DrinkType;

public class DrinksPage extends AbstractPage {

    public DrinksPage addToShoppingCart(DrinkType type) {
        addToShoppingCart(type.getXpathValue());
        return this;
    }
}