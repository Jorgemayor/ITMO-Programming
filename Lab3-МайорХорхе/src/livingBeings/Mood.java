package livingBeings;

import java.net.SocketAddress;

public enum Mood {

    NEUTRAL("Neutral"),
    HUNGRY("Hungry"),
    HAPPY("Happy"),
    SAD("Sad"),
    CONFUSED("Confused"),
    THOUGHTFUL("Thoughtful");

    private final String name;

    Mood(String name) {
        this.name = name;
    }

    public String getFeeling() {
        return this.name;
    }

}

