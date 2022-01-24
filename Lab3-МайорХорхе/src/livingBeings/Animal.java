package livingBeings;

import exceptions.PigletException;
import places.Place;
import things.Food;
import things.Thing;

import java.util.ArrayList;

public class Animal implements Actions {

    private String name;
    private TypeAnimal type;
    private Place currentPlace;
    private Mood mood;
    private ArrayList<Thing> foodEated;

    public Animal(String name, TypeAnimal type, Place currentPlace) {
        this.name = name;
        this.type = type;
        this.currentPlace = currentPlace;
        foodEated = new ArrayList<>();
    }

    public void moves(Place place) {

        this.currentPlace = place;
    }

    public void eats(Thing thing) {
        if(!(thing instanceof Food)) {
            System.out.print(this.name + "cannot eat a " + thing.getName());
        }
    }

    public void speaks(String message) {

    }

    public String getName() {
        return this.name;
    }

    public boolean isFat() throws PigletException {

        if(this.getName().equals("Piglet")) {
            throw new PigletException();
        }

        int sizeFoodEaten = 0;
        for(Thing food : foodEated) {
            sizeFoodEaten += food.getSize();
        }

        return sizeFoodEaten > this.type.getBellySize();
    }
}
