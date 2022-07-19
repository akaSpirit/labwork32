public enum Coin {
    ONE(1),
    THREE(3),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50);
    private final int rate;

    Coin(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
