public enum Goods {
    CHIPS("Chips", 80),
    CHOCOLATE_BAR("Chocolate bar", 55),
    CRACKERS("Crackers", 35),
    SODA("Soda", 25),
    WATER("Water", 20);

    private final String name;
    private final int price;

    Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
