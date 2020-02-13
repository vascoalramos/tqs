import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TqsStack {

    private ArrayList<Integer> stack;

    public TqsStack() {
        stack = new ArrayList<>();
    }

    public boolean push(int x) {
        stack.add(x);
        return true;
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }
        return stack.remove(stack.size()-1);
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }
        return stack.get(0);
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }


}
