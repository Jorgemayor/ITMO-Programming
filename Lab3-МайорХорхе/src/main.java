import livingBeings.*;
import places.Place;

import java.text.ParseException;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        Place bosque = null;

        try {
            bosque = new Place("bosque", new ArrayList<>() {
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

        Place dessert = new Place("Dessert");

        Animal winnie = new Animal("Winnie", TypeAnimal.BEAR, bosque);
        winnie.setMood(Mood.HUNGRY);
        winnie.eats();
        winnie.setMood(Mood.HAPPY);
        winnie.moves(dessert);
        winnie.eats();
        winnie.setMood(Mood.SAD);
    }
}
