package enums;

public enum Categories {
    PIZZA("pizza"),
    DRINKS("drinks");

    private final String xpathValue;

    Categories(String category) {
        xpathValue = category;
    }

    public String getXpathValue() {
        return xpathValue;
    }
}