package livingBeings;

import things.Food;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Plant {

    private final Date dateOfBirth;
    private final TypePlants type;

    public Plant(TypePlants type) {
        this.type = type;
        dateOfBirth = new Date();
    }

    public Plant(TypePlants type, String dateOfBirth) throws ParseException {
        this.type = type;
        this.dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
    }

    public int getRemainingDaysToSprout() {

        Date date = new Date();
        long difference = date.getTime() - dateOfBirth.getTime();
        int days = (int) TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
        int daysToSprout = type.getDaysToSprout();

        return daysToSprout - days;
    }

    public boolean hasSprouted() {
        return this.getRemainingDaysToSprout() <= 0;
    }

    public boolean hasFruits() {
        return this.hasSprouted() && type.hasFruits();
    }

    public Food getFruit() {
        return type.getFruit();
    }

    public String toString() {
        return type.toString() + " " + dateOfBirth;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Plant plant = (Plant) object;
        return Objects.equals(dateOfBirth, plant.dateOfBirth) && type == plant.type;
    }

    public int hashCode() {
        return Objects.hash(dateOfBirth, type);
    }
}
