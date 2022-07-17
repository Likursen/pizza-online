package enums;

public enum ProductType {
    MARGARITA("MGRC", "Маргарита"),
    COCA_COLA_1L("KK1", "Кока-Кола 1 л");
    private final String xpathValue;
    private final String name;

    ProductType(String xpathValue, String name) {
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