package livingBeings;

import things.Food;

public enum TypePlants {

    MANGO_TREE("Mango tree", 1, Food.MANGO),
    ORANGE_TREE("Orange tree", 2, Food.ORANGE),
    LEMON_TREE("Lemon tree", 3, Food.LEMON),
    HONEY_TREE("Honey tree", 6, Food.HONEY),
    CARROT_BUSH("Carrot bush", 4, Food.CARROT),
    MARGARITA("Margarita", 4, null);

    private final String name;
    private final int daysToSprout;
    private final Food food;

    TypePlants(String name, int daysToSprout, Food food) {
        this.name = name;
        this.daysToSprout = daysToSprout;
        this.food = food;
    }

    public int getDaysToSprout() {
        return daysToSprout;
    }

    public boolean hasFruits() {
        return food != null;
    }

    public String toString() {
        return name;
    }

    public Food getFruit() {
        return food;
    }
}
