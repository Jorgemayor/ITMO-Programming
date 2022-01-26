import exceptions.NoCellphoneException;
import exceptions.PigletException;
import exceptions.SproutedException;
import livingBeings.*;
import places.Place;

import java.text.ParseException;

public class main {

    public static void main(String[] args) {

        Place forest = new Place("Forest");
        Place dessert = new Place("Dessert");
        Place house = new Place("House");
        Place garden = new Place("Garden");

        Plant acorn = new Plant(TypePlants.HONEY_TREE);

        try {
            forest.addPlant(new Plant(TypePlants.LEMON_TREE, "12/01/2022"));
            forest.addPlant(new Plant(TypePlants.MANGO_TREE, "12/01/2022"));
            forest.addPlant(new Plant(TypePlants.ORANGE_TREE, "12/01/2022"));
            forest.addPlant(new Plant(TypePlants.HONEY_TREE, "12/01/2022"));
            forest.addPlant(new Plant(TypePlants.CARROT_BUSH, "12/01/2022"));
            forest.addPlant(new Plant(TypePlants.MARGARITA, "12/01/2022"));

            house.addPlant(new Plant(TypePlants.MARGARITA));

            garden.addPlant(acorn);
        } catch (ParseException exception) {
            System.out.println(exception.getMessage());
        }

        Animal winnie = new Animal("Winnie", TypeAnimal.BEAR, forest);
        Animal piglet = new Animal("Piglet", TypeAnimal.PIG, garden);
        Animal robbin = new Animal("Robbin", TypeAnimal.HUMAN, forest);
        Animal tigger = new Animal("tigger", TypeAnimal.TIGER, forest);
        Animal donkey = new Animal("Donkey", TypeAnimal.DONKEY, forest);
        Animal kanga = new Animal("Kanga", TypeAnimal.KANGAROO, forest);
        Animal roo = new Animal("Roo", TypeAnimal.KANGAROO, forest);
        Animal rabbit = new Animal("Rabbit", TypeAnimal.RABBIT, forest);
        Animal owl = new Animal("Owl", TypeAnimal.OWL, forest);


        System.out.println("\nSTORY 1:");
        winnie.setMood(Mood.HUNGRY);
        winnie.eats();
        winnie.setMood(Mood.HAPPY);
        winnie.moves(dessert);
        winnie.eats();
        winnie.setMood(Mood.SAD);

        System.out.println("\nSTORY 2:");
        winnie.moves(garden);
        winnie.speaks("неважно, чем он занят, так как он толстеть не станет, а ведь он толстеть не станет");
        piglet.setMood(Mood.THOUGHTFUL);
        piglet.speaks("How much time does the acorn need to sprout?");
        try {
            if(acorn.hasSprouted()) {
                throw new SproutedException();
            }
            int days = acorn.getRemainingDaysToSprout();
            System.out.println("The acorn needs " + days + " days to sprout.");
        } catch(SproutedException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            piglet.isFat();
        } catch(PigletException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("\nSTORY 3:");
        robbin.setMood(Mood.BORED);
        boolean callNotmade = true;
        while(callNotmade) {
            if (robbin.hasCellphone()) {
                try {
                    robbin.call(tigger, "Hi! Let's play outside.");
                    callNotmade = false;
                } catch (NoCellphoneException exception) {
                    System.out.println(exception.getMessage());
                    robbin.setMood(Mood.CONFUSED);
                    tigger.buyCellphone();
                }
            } else {
                robbin.buyCellphone();
            }
        }
        robbin.setMood(Mood.HAPPY);

        System.out.println("\nSTORY 4:");
        try {
            while(!roo.isFat()) {
                roo.eats();
            }
        } catch (PigletException exception) {
            System.out.println(exception.getMessage());
        }
        roo.setMood(Mood.HAPPY);
        System.out.println("Roo got fat!");
        kanga.setMood(Mood.ANGRY);
        kanga.speaks("You cannot eat more!");
        roo.setMood(Mood.SAD);
    }
}
