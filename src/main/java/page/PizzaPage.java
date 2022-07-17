package page;

import enums.PizzaType;

public class PizzaPage extends AbstractPage {

    public PizzaPage addToShoppingCart(PizzaType type) {
        addToShoppingCart(type.getXpathValue());
        return this;
    }
}