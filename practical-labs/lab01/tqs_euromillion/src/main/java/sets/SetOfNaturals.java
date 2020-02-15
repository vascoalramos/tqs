package sets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class SetOfNaturals implements Iterable<Integer> {

    public static final int MIN_BOUND_NATURAL_NUMBER = 1;
    private ArrayList<Integer> collection = new ArrayList<>();

    public static SetOfNaturals fromArray(int[] values) {
        SetOfNaturals newSet = new SetOfNaturals();
        for (int n : values) {
            newSet.addFromArray(n);
        }
        return newSet;
    }

    public void addFromArray(int element) {
        if (this.collection.contains(element) || element < MIN_BOUND_NATURAL_NUMBER) {
            return;
        }
        collection.add(element);
    }

    public void add(int element) {
        if (this.collection.contains(element)) {
            throw new IllegalArgumentException("duplicate value: " + element);
        }

        if (element < MIN_BOUND_NATURAL_NUMBER) {
            throw new IllegalArgumentException("Illegal argument: not a natural number");
        }

        collection.add(element);
    }

    public void add(int[] numbers) {
        for (int number : numbers) {
            this.add(number);
        }
    }

    public int size() {
        return this.collection.size();
    }

    public boolean intersects(SetOfNaturals subset) {
        return false;
    }

    public boolean contains(Integer element) {
        return collection.contains(element);
    }

    @Override
    public Iterator<Integer> iterator() {
        return collection.iterator();
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.collection);
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

        final SetOfNaturals other = (SetOfNaturals) obj;
        return Objects.equals(this.collection, other.collection);
    }

    @Override
    public String toString() {
        return "SetOfNaturals{" +
                "collection=" + collection +
                '}';
    }
}
