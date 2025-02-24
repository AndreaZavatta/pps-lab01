package tdd;

import java.util.LinkedList;
import java.util.Queue;

public class CircularQueueImpl implements CircularQueue{
    private int capacity;
    Queue<Integer> queue;

    public CircularQueueImpl(final int capacity){
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    @Override
    public void enQueue(Integer elem) {
        queue.add(elem);
    }

    @Override
    public int deQueue() {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return queue.size();
    }
}
