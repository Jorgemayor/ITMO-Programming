package exceptions;

public class NoFoodException extends Exception {
    public NoFoodException() {
        super("There is no food in this place!");
    }
}
