package places;

import java.util.ArrayList;

import livingBeings.Plant;
import things.Thing;

public abstract class AbstractPlace {

    private String name;
    private ArrayList<Plant> plants;
    private ArrayList<Thing> things;

    public AbstractPlace(String name) {
        this.name = name;
        this.plants = new ArrayList<Plant>();
        this.things = new ArrayList<Thing>();
    }

    public AbstractPlace(String name, ArrayList<Plant> plants) {
        this.name = name;
        this.plants = plants;
        this.things = new ArrayList<Thing>();
    }

    public AbstractPlace(String name, ArrayList<Plant> plants, ArrayList<Thing> things) {
        this.name = name;
        this.plants = plants;
        this.things = things;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public ArrayList<Thing> getThings() {
        return things;
    }

    public void addPlant(Plant plant) {
        this.plants.add(plant);
    }

    public void addThing(Thing thing) {
        this.things.add(thing);
    }

    public boolean hasPlants(Plant plant) {
        return this.getPlants().contains(plant);
    }

    public boolean hasThings(Thing thing) {
        return this.getThings().contains(thing);
    }
}
