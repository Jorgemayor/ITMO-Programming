package livingBeings;

import places.Place;

public interface Actions {

    void moves(Place place);
    void eats();
    void speaks(String message);
    void buyCellphone();
}
