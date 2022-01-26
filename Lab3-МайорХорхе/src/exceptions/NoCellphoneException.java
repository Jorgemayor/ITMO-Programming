package exceptions;

public class NoCellphoneException extends Exception {
    public NoCellphoneException(String name) {
        super(name + " does not have a cellphone.");
    }
}
