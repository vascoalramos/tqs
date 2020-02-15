package euromillions;

import sets.SetOfNaturals;

import java.util.Objects;
import java.util.Random;

/**
 * A set of 5 numbers and 2 starts according to the Euromillions ranges.
 *
 * @author ico0
 */
public class Dip {

    public static final int NUMBER_OF_NUMBERS = 5;
    public static final int NUMBER_OF_STARS = 2;
    public static final int MAX_RANGE_NUMBERS = 50;
    public static final int MAX_RANGE_STARS = 10;
    private SetOfNaturals numbers;
    private SetOfNaturals starts;

    public Dip() {
        numbers = new SetOfNaturals();
        starts = new SetOfNaturals();
    }

    public Dip(int[] arrayOfNumbers, int[] arrayOfStarts) {
        this();

        if (arrayOfNumbers.length != NUMBER_OF_NUMBERS || (arrayOfStarts.length != NUMBER_OF_STARS)) {
            throw new IllegalArgumentException("wrong number of elements in numbers/stars");
        } else {
            numbers.add(arrayOfNumbers);
            starts.add(arrayOfStarts);
        }

    }

    public static Dip generateRandomDip() {
        Random generator = new Random();

        Dip randomDip = new Dip();
        for (int i = 0; i < NUMBER_OF_NUMBERS; ) {
            int candidate = generator.nextInt(MAX_RANGE_NUMBERS - 1) + 1;
            if (!randomDip.getNumbersColl().contains(candidate)) {
                randomDip.getNumbersColl().add(candidate);
                i++;

            }
        }
        for (int i = 0; i < NUMBER_OF_STARS; ) {
            int candidate = generator.nextInt(MAX_RANGE_STARS - 1) + 1;
            if (!randomDip.getStarsColl().contains(candidate)) {
                randomDip.getStarsColl().add(candidate);
                i++;
            }
        }
        return randomDip;
    }

    public SetOfNaturals getNumbersColl() {
        return numbers;
    }

    public SetOfNaturals getStarsColl() {
        return starts;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.numbers);
        hash = 29 * hash + Objects.hashCode(this.starts);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dip other = (Dip) obj;
        if (!Objects.equals(this.numbers, other.numbers)) {
            return false;
        }
        return Objects.equals(this.starts, other.starts);
    }


    /**
     * prepares a string representation of the data structure, formatted for
     * printing
     *
     * @return formatted string with data
     */
    public String format() {
        StringBuilder sb = new StringBuilder();
        sb.append("N[");
        for (int number : getNumbersColl()) {
            sb.append(String.format("%3d", number));
        }
        sb.append("] S[");
        for (int star : getStarsColl()) {
            sb.append(String.format("%3d", star));
        }
        sb.append("]");
        return sb.toString();
    }
}
