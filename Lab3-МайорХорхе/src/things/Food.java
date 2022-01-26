package things;

public enum Food implements Thing {

    MANGO("Mango", 1),
    ORANGE("Orange", 1),
    LEMON("Lemon", 3),
    HONEY("Honey", 2),
    CARROT("Carrot", 3);

    private final String name;
    private final int size;

    Food(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String toString() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }
}
