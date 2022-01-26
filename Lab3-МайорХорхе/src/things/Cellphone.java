package things;

import exceptions.NoCellphoneException;
import livingBeings.Animal;

import java.util.Objects;

public class Cellphone implements Thing {

    private final String userName;

    public Cellphone (String userName) {
        super();
        this.userName = userName;
    }

    public void call(Animal caller, Animal receiver, String message) throws NoCellphoneException {

        if(caller.equals(receiver)) {
            System.out.println(caller.getName() + " cannot call himself.");
            return;
        }

        String callerName = caller.getName();
        String receiverName = receiver.getName();
        System.out.println(callerName + " is callling " + receiverName + "...");

        if(!receiver.hasCellphone()) {
            throw new NoCellphoneException(receiverName);
        }

        caller.speaks(message);
    }

    public int getSize() {
        return 0;
    }

    public String toString() {
        return this.userName;
    }

    public boolean equals(Object object) {
        if(!(object instanceof Cellphone))
            return false;

        Cellphone cellphone = (Cellphone) object;
        return this.toString().equals(cellphone.toString());
    }

    public int hashCode() {
        return Objects.hash(userName);
    }
}
