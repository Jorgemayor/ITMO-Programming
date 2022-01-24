package livingBeings;

public enum TypePlants {

    MANGO_TREE(1, false, true),
    ORANGE_TREE(2, false, true),
    LEMON_TREE(3, false, true),
    MARGARITA(4, true, false);

    private final int daysToSprout;
    private final boolean hasFlowers;
    private final boolean hasFruits;

    TypePlants(int daysToSprout, boolean hasFlowers, boolean hasFruits) {
        this.daysToSprout = daysToSprout;
        this.hasFlowers = hasFlowers;
        this.hasFruits = hasFruits;
    }

    public int getDaysToSprout() {
        return this.daysToSprout;
    }
}
