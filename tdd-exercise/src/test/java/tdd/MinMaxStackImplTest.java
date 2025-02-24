package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    public static final int VALUE_TO_PUSH = 10;
    public static final int SIZE_AFTER_POP = 1;
    public static final int SMALLER_VALUE = 5;
    MinMaxStack minMaxStack;

    @BeforeEach
    public void setup(){
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    public void testPushPeek() {
        minMaxStack.push(VALUE_TO_PUSH);
        assertEquals(VALUE_TO_PUSH ,minMaxStack.peek());
    }

    @Test
    public void testPop(){
        minMaxStack.push(VALUE_TO_PUSH);
        minMaxStack.push(VALUE_TO_PUSH);
        minMaxStack.pop();
        assertEquals(SIZE_AFTER_POP, minMaxStack.size());
    }

    @Test
    public void testIsEmpty(){
        assertTrue(minMaxStack.isEmpty());
        minMaxStack.push(VALUE_TO_PUSH);
        assertFalse(minMaxStack.isEmpty());
    }

    @Test
    public void testMin(){
        minMaxStack.push(VALUE_TO_PUSH);
        minMaxStack.push(SMALLER_VALUE);
        assertEquals(SMALLER_VALUE, minMaxStack.getMin());
    }

    @Test
    public void shouldThrowExceptionGetMinWithoutValues(){
        assertThrows(RuntimeException.class, () -> minMaxStack.getMin());
    }

    @Test
    public void testMax(){
        minMaxStack.push(VALUE_TO_PUSH);
        minMaxStack.push(SMALLER_VALUE);
        assertEquals(VALUE_TO_PUSH, minMaxStack.getMax());
    }

    @Test
    public void shouldThrowExceptionGetMaxWithoutValues(){
        assertThrows(RuntimeException.class, () -> minMaxStack.getMax());
    }
}