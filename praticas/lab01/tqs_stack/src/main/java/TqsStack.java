import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TqsStack<E> {

    public static final int MIN_SIZE = 1;
    private List<E> stack;
    private int max_size;

    public TqsStack() {
        this.stack = new ArrayList<E>();
        this.max_size = -1;
    }

    public TqsStack(int max_size) {
        if (max_size < MIN_SIZE) {
            throw new IllegalArgumentException("Max Size: Stack max size should be an integer value bigger than 0");
        }
        this.stack = new ArrayList<E>();
        this.max_size = max_size;
    }

    public boolean push(E e) {
        if (this.isFull()) {
            throw new IllegalStateException("Max Size: Stack is full");
        }
        return this.stack.add(e);
    }

    public E pop() {
        try {
            return this.stack.remove(this.stack.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    public E peek() {
        if (this.stack.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.stack.get(this.stack.size() - 1);
    }

    public int size() {
        return this.stack.size();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public boolean isFull() {
        return (this.max_size != -1) && (this.size() >= this.max_size);
    }

    public void clear() {
        this.stack.clear();
    }

    public void setMaxSize(int max_size) {
        this.max_size = max_size;
    }

}
