package enums;

public enum PizzaType {
    MARGARITA("MGRC", "Маргарита");

    public final String xpathValue;
    public final String name;

    PizzaType(String xpathValue, String name) {
        this.xpathValue = xpathValue;
        this.name = name;
    }

    public String getXpathValue() {
        return xpathValue;
    }

    public String getName() {
        return name;
    }
}