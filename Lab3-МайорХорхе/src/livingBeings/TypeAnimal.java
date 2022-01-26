package livingBeings;

import things.Food;

public enum TypeAnimal {

    PIG("Pig", 3, Food.MANGO),
    BEAR("Bear", 5, Food.HONEY),
    HUMAN("Human", 4, Food.ORANGE),
    TIGER("Tiger", 4, Food.LEMON),
    DONKEY("Donkey", 3, Food.MANGO),
    KANGAROO("Kangaroo", 4, Food.ORANGE),
    RABBIT("Rabbit", 2, Food.CARROT),
    OWL("Owl", 1, Food.MANGO);

    private final String name;
    private final int bellySize;
    private final Food preferredFood;

    TypeAnimal(String name, int bellySize, Food preferredFood) {
        this.name = name;
        this.bellySize = bellySize;
        this.preferredFood = preferredFood;
    }

    public String getName() {
        return this.name;
    }

    public int getBellySize() {
        return this.bellySize;
    }

    public Food getPreferredFood() {
        return this.preferredFood;
    }
}
