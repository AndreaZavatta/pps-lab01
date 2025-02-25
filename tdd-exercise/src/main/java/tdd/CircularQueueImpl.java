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
        if(queue.isEmpty()){
            throw new IllegalStateException("you can't dequeue an empty queue");
        }else{
            return queue.poll();
        }
    }

    @Override
    public int peek() {
        if(queue.isEmpty()){
            throw new IllegalStateException("you can't dequeue an empty queue");
        }else{
            return queue.peek();
        }
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean isFull() {
        return queue.size() == capacity;
    }

    @Override
    public int size() {
        return queue.size();
    }
}
