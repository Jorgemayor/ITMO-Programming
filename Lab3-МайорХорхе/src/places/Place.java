package places;

import java.util.ArrayList;

import livingBeings.Plant;

public class Place extends AbstractPlace {

    public Place(String name) {
        super(name);
    }

    public boolean equals(Object object) {
        if (!(object instanceof Place))
            return false;
        if (object == this)
            return true;

        Place placeObject = (Place) object;
        ArrayList<Plant> placePlants = this.getPlants();
        ArrayList<Plant> placeObjectPlants = placeObject.getPlants();

        return this.toString().equals(placeObject.toString()) &&
                this.getPlants().size() == placeObject.getPlants().size() &&
                placePlants.equals(placeObjectPlants);
    }
}
