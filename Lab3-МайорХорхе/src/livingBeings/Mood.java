package livingBeings;

public enum Mood {

    NEUTRAL("Neutral"),
    HUNGRY("Hungry"),
    HAPPY("Happy"),
    SAD("Sad"),
    CONFUSED("Confused"),
    THOUGHTFUL("Thoughtful"),
    ANGRY("Angry"),
    BORED("Bored");

    private final String name;

    Mood(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

