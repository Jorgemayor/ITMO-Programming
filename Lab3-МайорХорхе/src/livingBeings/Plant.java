package livingBeings;

import things.Food;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Plant {

    private final Date dateOfBirth;
    private final TypePlants type;

    public Plant(TypePlants type) {
        this.type = type;
        this.dateOfBirth = new Date();
    }

    public Plant(TypePlants type, String dateOfBirth) throws ParseException {
        this.type = type;
        this.dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
    }

    public String toString() {
        return type.toString();
    }

    public int getRemainingDaysToSprout() {

        Date date = new Date();
        long difference = date.getTime() - dateOfBirth.getTime();
        int days = (int) TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
        int daysToSprout = type.getDaysToSprout();

        return daysToSprout - days;
    }

    public boolean hasFruits() {
        return this.getRemainingDaysToSprout() <= 0 && this.type.hasFruits();
    }

    public Food getFruit() {
        return this.type.getFruit();
    }
}
