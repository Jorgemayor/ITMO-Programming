package places;

import java.util.ArrayList;

import livingBeings.Plant;
import things.Thing;

public class Place extends AbstractPlace {

    public Place(String name) {
        super(name);
    }

    public Place(String name, ArrayList<Plant> plants) {
        super(name, plants);
    }

    public Place(String name, ArrayList<Plant> plants, ArrayList<Thing> things) {
        super(name, plants, things);
    }

    public boolean equals(Object object) {
        if (!(object instanceof Place))
            return false;
        if (object == this)
            return true;

        Place placeObject = (Place) object;
        ArrayList<Plant> placePlants = this.getPlants();
        ArrayList<Thing> placeThings = this.getThings();
        ArrayList<Plant> placeObjectPlants = placeObject.getPlants();
        ArrayList<Thing> placeObjectThings = placeObject.getThings();
        boolean areEqual = this.getName().equals(placeObject.getName()) &&
                this.getThings().size() == placeObject.getThings().size() &&
                this.getPlants().size() == placeObject.getPlants().size() &&
                placePlants.equals(placeObjectPlants) &&
                placeThings.equals(placeObjectThings);

        return areEqual;
    }
}
