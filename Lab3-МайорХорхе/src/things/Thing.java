package things;

public class Thing {

    private final String name;
    private final int size;

    public Thing(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return 0;
    }
}
