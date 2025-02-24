package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {
    /**
     * add a number to the queue.
     * if the queue is full, the oldest value will be removed
     * @param elem the element that will be inserted
     */
    void enQueue(Integer elem);

    /**
     * remove the oldest number inserted from the queue.
     * @return the value just removed
     * @throws IllegalStateException if the stack is empty.
     */
    int deQueue();
    /**
     * get the oldest number inserted from the queue.
     * @return the value found
     * @throws IllegalStateException if the stack is empty.
     */
    int peek();
    /**
     * get the max capacity of the queue.
     * @return the size
     */
    int getCapacity();
    /**
     * check if the queue is empty
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();
    /**
     * check if the queue is full
     * @return true if the queue is full, false otherwise
     */
    boolean isFull();
    /**
     * get the actual size of the queue
     * @return the actual size of the queue
     */
    int size();
}