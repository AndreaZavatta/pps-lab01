package tdd;

import java.util.LinkedList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue{
    private int capacity;
    List<Integer> queue;
    private int pointerPeek;
    private int pointerEnqueue;

    public CircularQueueImpl(final int capacity){
        this.capacity = capacity;
        queue = new LinkedList<>();
        this.pointerPeek = 0;
        this.pointerEnqueue = 0;
    }

    @Override
    public void enQueue(Integer elem) {
        if(queue.size() == this.capacity){
            queue.set(this.pointerEnqueue, elem);
        }else{
            queue.add(elem);
        }
        this.pointerEnqueue++;
        resetPointerEnqueue();
    }

    @Override
    public int deQueue() {
        if(queue.isEmpty()){
            throw new IllegalStateException("you can't dequeue an empty queue");
        }else{
            int ret = queue.get(pointerPeek);
            queue.remove(0);
            return ret;
        }
    }

    @Override
    public int peek() {
        if(queue.isEmpty()){
            throw new IllegalStateException("you can't dequeue an empty queue");
        }else{
            int ret = queue.get(pointerPeek);
            this.pointerPeek++;
            resetPointerPeek();
            return ret;
        }
    }

    private void resetPointerPeek(){
        if(this.pointerPeek >= this.capacity){
            this.pointerPeek = 0;
        }
    }

    private void resetPointerEnqueue(){
        if(this.pointerEnqueue >= this.capacity){
            this.pointerEnqueue = 0;
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
