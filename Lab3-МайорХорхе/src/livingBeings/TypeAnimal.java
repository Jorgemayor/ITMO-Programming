package livingBeings;

public enum TypeAnimal {

    PIG("Pig", 3),
    BEAR("Bear", 5),
    HUMAN("Human", 4),
    TIGER("Tiger", 4),
    DONKEY("Donkey", 3),
    KANGAROO("Kangaroo", 4),
    RABBIT("Rabbit", 2),
    OWL("Owl", 1);

    private final String name;
    private final int bellySize;

    TypeAnimal(String name, int bellySize) {
        this.name = name;
        this.bellySize = bellySize;
    }

    public String getName() {
        return this.name;
    }

    public int getBellySize() {
        return this.bellySize;
    }

}
