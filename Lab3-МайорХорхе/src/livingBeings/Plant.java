package livingBeings;

import exceptions.SproutedException;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Plant {

    private Date dateOfBirth;
    private TypePlants type;

    public Plant(TypePlants type, Date dateOfBirth) {

        this.type = type;
        this.dateOfBirth = dateOfBirth;
    }

    public int getRemainingDaysToSprout() throws SproutedException {

        Date date = new Date();
        long difference = date.getTime() - dateOfBirth.getTime();
        int days = (int) TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
        int daysToSprout = type.getDaysToSprout();

        if(days >= daysToSprout) {
            throw new SproutedException();
        }
        return daysToSprout - days;
    }

    public boolean hasFruits() throws SproutedException {
        return this.getRemainingDaysToSprout() <= 0 && this.hasFruits();
    }

    public boolean hasFlowers() throws SproutedException {
        return this.getRemainingDaysToSprout() <= 0 && this.hasFlowers();
    }
}
