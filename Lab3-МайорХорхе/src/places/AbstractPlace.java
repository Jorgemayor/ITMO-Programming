package places;

import java.util.ArrayList;
import java.util.Objects;

import livingBeings.Plant;

public abstract class AbstractPlace {

    private final String name;
    private ArrayList<Plant> plants;

    public AbstractPlace(String name) {
        this.name = name;
        this.plants = new ArrayList<>();
    }

    public String toString() {
        return name;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void addPlant(Plant plant) {
        this.plants.add(plant);
    }

    public boolean hasPlants() {
        return plants.size() > 0;
    }

    public abstract boolean equals(Object object);

    public int hashCode() {
        return Objects.hash(name, plants);
    }
}
