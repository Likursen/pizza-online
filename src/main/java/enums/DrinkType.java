package enums;

public enum DrinkType {
    COCA_COLA_1L("KK1", "Кока-Кола 1 л");

    public final String xpathValue;
    public final String name;

    DrinkType(String xpathValue, String name) {
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