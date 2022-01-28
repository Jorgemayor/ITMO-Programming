package places;

import java.util.List;

import livingBeings.Plant;

public class Place extends AbstractPlace {

    public Place(String name) {
        super(name);
    }

    public boolean equals(Object object) {
        if(!(object instanceof Place))
            return false;
        if(object == this)
            return true;

        Place placeObject = (Place) object;
        List<Plant> placePlants = this.getPlants();
        List<Plant> placeObjectPlants = placeObject.getPlants();

        return this.toString().equals(placeObject.toString()) &&
                this.getPlants().size() == placeObject.getPlants().size() &&
                placePlants.equals(placeObjectPlants);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
