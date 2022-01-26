import livingBeings.Plant;
import livingBeings.TypePlants;
import places.Place;

import java.text.ParseException;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        try {
            Place bosque = new Place("bosque", new ArrayList<>() {
                {
                    new Plant(TypePlants.LEMON_TREE, "12/01/2022");
                    new Plant(TypePlants.MANGO_TREE, "12/01/2022");
                    new Plant(TypePlants.ORANGE_TREE, "12/01/2022");
                    new Plant(TypePlants.HONEY_TREE, "12/01/2022");
                    new Plant(TypePlants.CARROT_BUSH, "12/01/2022");
                    new Plant(TypePlants.MARGARITA, "12/01/2022");
                }
            });
        } catch (ParseException exception) {
            System.out.print(exception.getMessage());
        }


    }

}
