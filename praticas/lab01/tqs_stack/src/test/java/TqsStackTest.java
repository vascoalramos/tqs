import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TqsStackTest {

    private static TqsStack stack = new TqsStack();

    @BeforeAll
    public static void init() {
        for(int i = 0; i < 4; i++) {
            stack.push((i+1)*4);
        }
    }

    @Test
    @DisplayName("A stack is empty on construction")
    void isEmptyOnConstruction() {
        TqsStack stackOnConstr = new TqsStack();
        assertTrue(stackOnConstr.isEmpty());
    }

    @Test
    @DisplayName("A stack has size 0 on construction")
    void sizeZeroOnConstruction() {
        TqsStack stackOnConstr = new TqsStack();
        assertEquals(0, stackOnConstr.size());
    }

    @Test
    @DisplayName("After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
    void nPushes() {
        TqsStack newStack = new TqsStack();
        for(int i=0; i < 4; i++) {
            newStack.push(i*3);
        }
        assertFalse(newStack.isEmpty());
        assertEquals(4, newStack.size());
    }

    @Test
    @DisplayName("If one pushes x then pops, the value popped is x")
    void pushThenPop() {
        stack.push(10);
        assertEquals(10, stack.pop());
    }

    @Test
    @DisplayName("If one pushes x then peeks, the value returned is x, but the size stays the same")
    void pushThenPeeks() {
        stack.push(10);
        int originalSize = stack.size();
        assertEquals(10, stack.peek());
        assertEquals(originalSize, stack.size());
    }

    @Test
    @DisplayName("If the size is n, then after n pops, the stack is empty and has a size 0")
    void nPops() {
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            stack.pop();
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("Popping from an empty stack does throw a NoSuchElementException")
    void popFromEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> {
            TqsStack newStack = new TqsStack();
            newStack.pop();
        });
    }

    @Test
    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    void peekFromEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> {
            TqsStack newStack = new TqsStack();
            newStack.peek();
        });
    }


}