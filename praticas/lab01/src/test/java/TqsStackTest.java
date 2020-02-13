import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TqsStackTest {

    private final TqsStack stack = new TqsStack();

    @Test
    void isEmptyOnConstruction() {
        TqsStack stackOnConstr = new TqsStack();
        assertTrue(stackOnConstr.isEmpty());
    }

    @Test
    void sizeZeroOnConstruction() {
        TqsStack stackOnConstr = new TqsStack();
        assertEquals(0, stackOnConstr.size());
    }

    @Test
    void nPushes() {
        TqsStack newStack = new TqsStack();
        for(int i=0; i < 4; i++) {
            newStack.push(i*3);
        }
        assertFalse(newStack.isEmpty());
        assertEquals(4, newStack.size());
    }

    @Test
    void pushThenPop() {
        stack.push(10);
        assertEquals(10, stack.pop());
    }

    @Test
    void pushThenPeeks() {
        stack.push(10);
        int originalSize = stack.size();
        assertEquals(10, stack.peek());
        assertEquals(originalSize, stack.size());
    }

    @Test
    void nPops() {
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            stack.pop();
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    void popFromEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> {
            TqsStack newStack = new TqsStack();
            newStack.pop();
        });
    }

    @Test
    void peekFromEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> {
            TqsStack newStack = new TqsStack();
            newStack.peek();
        });
    }


}