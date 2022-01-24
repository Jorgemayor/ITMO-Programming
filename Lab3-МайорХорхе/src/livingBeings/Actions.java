package livingBeings;

import places.Place;
import things.Thing;

public interface Actions {

    void moves(Place place);
    void eats(Thing thing);
    void speaks(String message);
}
