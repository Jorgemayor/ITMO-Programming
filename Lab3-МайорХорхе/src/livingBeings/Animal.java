package livingBeings;

import exceptions.NoFoodException;
import exceptions.PigletException;
import places.Place;
import things.Cellphone;
import things.Food;

public class Animal implements Actions {

    private final String name;
    private final TypeAnimal type;
    private Place currentPlace;
    private Mood mood;
    private final Food preferredFood;
    private int sizeEatenFood;
    private Cellphone cellphone;

    public Animal(String name, TypeAnimal type, Place currentPlace) {
        this.name = name;
        this.type = type;
        this.currentPlace = currentPlace;
        this.mood = Mood.NEUTRAL;
        preferredFood = type.getPreferredFood();
        sizeEatenFood = 0;
        cellphone = null;
    }

    public void moves(Place place) {
        System.out.println(name + " has gone from " + currentPlace.toString() + " to " + place.toString() + ".");
        this.currentPlace = place;
    }

    public void eats() {

        Food food = null;

        if(currentPlace.hasPlants())
            for(Plant plant : currentPlace.getPlants())
                if(plant.hasFruits()) {
                    if(plant.getFruit().equals(preferredFood)) {
                        food = preferredFood;
                        break;
                    } else if(food == null) {
                        food = plant.getFruit();
                    }
                }

        try {
            if(food == null)
                throw new NoFoodException();
            sizeEatenFood += food.getSize();
            System.out.println(name + " ate a(n) " + food + ".");
        } catch (NoFoodException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void speaks(String message) {
        System.out.println(this.name + " says \"" + message + "\".");
    }

    public String getName() {
        return this.name;
    }

    public void buyCellphone() {
        this.cellphone = new Cellphone(this.getName());
        System.out.print(name + " now has a cellphone.");
    }

    public boolean hasCellphone() {
        return this.cellphone == null;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
        System.out.println(name + " is feeling " + mood.toString());
    }

    public boolean isFat() throws PigletException {

        if(this.getName().equals("Piglet")) {
            throw new PigletException();
        }

        return this.sizeEatenFood > this.type.getBellySize();
    }
}
