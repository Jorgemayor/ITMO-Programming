package things;

public enum Food implements Thing {

    MANGO("Mango"),
    ORANGE("Orange"),
    LEMON("Lemon"),
    HONEY("Honey"),
    CARROT("Carrot");

    private final String name;

    Food(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public int getSize() {
        return 0;
    }
}
