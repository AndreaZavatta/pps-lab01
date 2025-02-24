package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack{
    Stack<Integer> stack;

    public MinMaxStackImpl(){
        stack = new Stack<>();
    }

    @Override
    public void push(int value) {
        stack.push(value);
    }

    @Override
    public int pop() {
        return stack.pop();
    }

    @Override
    public int peek() {
        return stack.peek();
    }

    @Override
    public int getMin() {
        return stack.stream().mapToInt(Integer::intValue).min().orElseThrow(() -> new RuntimeException("Stack is empty"));
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
