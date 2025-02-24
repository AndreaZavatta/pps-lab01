package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    public static final int SIZE = 3;
    public static final int INIT_SIZE = 0;
    public static final int SIZE_AFTER_ADDING_AN_ELEMENT = 1;
    public static final int ELEM = 5;
    CircularQueue queue;
    @BeforeEach
    public void setup(){
        queue = new CircularQueueImpl(SIZE);
    }
    @Test
    public void testSize() {
        assertEquals(INIT_SIZE, queue.size());
        queue.enQueue(ELEM);
        assertEquals(SIZE_AFTER_ADDING_AN_ELEMENT, queue.size());
    }

    @Test
    public void testDequeue(){
        queue.enQueue(ELEM);
        assertEquals(ELEM, queue.deQueue());
        assertEquals(INIT_SIZE, queue.size());
    }

    @Test
    public void shouldThrowExceptionIfDequeueWhenEmpty(){
        assertThrows(IllegalStateException.class, ()->queue.deQueue());
    }
    @Test
    public void testPeek(){
        queue.enQueue(ELEM);
        assertEquals(ELEM, queue.peek());
        assertEquals(SIZE_AFTER_ADDING_AN_ELEMENT, queue.size());
    }


}
