import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TqsStackTest {

    private static TqsStack<Integer> testStack;

    @BeforeAll
    static void setup() {
        testStack = new TqsStack<>();
        for (int i = 0; i < 4; i++) {
            testStack.push((i + 1) * 4);
        }
    }

    @AfterAll
    public static void clear() {
        testStack.clear();
    }

    @Test
    @DisplayName("A stack is empty on construction")
    public void testInitEmpty() {
        assertTrue(new TqsStack<Integer>().isEmpty(), "Stack should be empty on construction, and it's not");
    }

    @Test
    @DisplayName("A stack is not full on construction")
    public void testInitFull() {
        assertFalse(new TqsStack<Integer>().isFull(), "Stack should not be full on construction, and it is");
    }

    @Test
    @DisplayName("A stack has size 0 on construction")
    public void testInitSize() {
        assertEquals(0, new TqsStack<Integer>().size(), "Stack should have size 0 on construction, and it doesn't");
    }

    @Test
    @DisplayName("A stack is full when it has achieve it's bounded space")
    public void testBoundedFull() {
        TqsStack<Integer> boundedStack = new TqsStack<>(100);

        this.pushN(boundedStack, 100);
        assertTrue(boundedStack.isFull(), "Stack should be full, and it's not");
    }

    @Test
    @DisplayName("After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
    public void testPushSize() {
        TqsStack<Integer> newStack = new TqsStack<>();
        this.pushN(newStack, 4);
        assertFalse(newStack.isEmpty(), "Stack shouldn't be empty");
        assertEquals(4, newStack.size(), "Stack size is not 4, the expected size");
    }

    @Test
    @DisplayName("If one pushes x then pops, the value popped is x")
    public void testPushThenPop() {
        testStack.push(10);
        assertEquals(10, testStack.pop(), "The popped value is not the expected one");
    }

    @Test
    @DisplayName("If one pushes x then peeks, the value returned is x, but the size stays the same")
    public void testPushThenPeek() {
        testStack.push(10);
        int originalSize = testStack.size();
        assertEquals(10, testStack.peek(), "The peeked value is not the expected one");
        assertEquals(originalSize, testStack.size(), "The peek operation should not change the size, but it did");
    }

    @Test
    @DisplayName("If the size is n, then after n pops, the stack is empty and has a size 0")
    public void testPushNPopN() {
        testStack.clear();
        assertTrue(testStack.isEmpty(), "After clear operation, stack should be empty, and it's not");
        this.popN(testStack, testStack.size());
        assertTrue(testStack.isEmpty(), "After the multiple pop operations, stack should be empty, and it's not");
    }

    @Test
    @DisplayName("Popping from an empty stack does throw a NoSuchElementException")
    public void testPopEmptyStack() {
        testStack.clear();
        assertTrue(testStack.isEmpty(), "After clear operation, stack should be empty, and it's not");
        assertThrows(NoSuchElementException.class, () -> {
            testStack.pop();
        });
    }

    @Test
    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    public void testPeekEmptyStack() {
        testStack.clear();
        assertTrue(testStack.isEmpty(), "After clear operation, stack should be empty, and it's not");
        assertThrows(NoSuchElementException.class, () -> {
            testStack.peek();
        });
    }

    @Test
    @DisplayName("For bounded stacks only, pushing onto a full stack does throw an IllegalStateException")
    public void testPushFullBoundedStack() {
        TqsStack<Integer> boundedStack = new TqsStack<>(100);

        this.pushN(boundedStack, 100);
        assertThrows(IllegalStateException.class, () -> {
            boundedStack.push(1);
        });
    }

    private void pushN(TqsStack<Integer> stack, int n) {
        for (int i = 0; i < n; i++) {
            stack.push((i + 1) * 5);
        }
    }

    private void popN(TqsStack<Integer> stack, int n) {
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
    }


}