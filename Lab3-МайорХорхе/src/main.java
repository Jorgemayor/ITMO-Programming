import livingBeings.*;
import places.Place;

import java.text.ParseException;

public class main {

    public static void main(String[] args) {

        Place forest = new Place("Forest");
        Place dessert = new Place("Dessert");
        Place house = new Place("House");

        try {
            forest.addPlant(new Plant(TypePlants.LEMON_TREE, "12/01/2022"));
            forest.addPlant(new Plant(TypePlants.MANGO_TREE, "12/01/2022"));
            forest.addPlant(new Plant(TypePlants.ORANGE_TREE, "12/01/2022"));
            forest.addPlant(new Plant(TypePlants.HONEY_TREE, "12/01/2022"));
            forest.addPlant(new Plant(TypePlants.CARROT_BUSH, "12/01/2022"));
            forest.addPlant(new Plant(TypePlants.MARGARITA, "12/01/2022"));

            house.addPlant(new Plant(TypePlants.MARGARITA));
        } catch (ParseException exception) {
            System.out.println(exception.getMessage());
        }

        Animal winnie = new Animal("Winnie", TypeAnimal.BEAR, forest);
        Animal piglet = new Animal("Piglet", TypeAnimal.PIG, forest);
        winnie.setMood(Mood.HUNGRY);
        winnie.eats();
        winnie.setMood(Mood.HAPPY);
        winnie.moves(dessert);
        winnie.eats();
        winnie.setMood(Mood.SAD);
    }
}
