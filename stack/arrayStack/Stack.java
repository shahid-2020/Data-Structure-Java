package stack.arrayStack;

import stack.IStack;
import stack.StackException;

public class Stack extends AStack implements IStack <Integer>{

    public Stack(){
        super();
    }

    public Stack(int capacity){
        super(capacity);
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public Integer top() throws StackException {
        if(isEmpty()){
            throw new StackException("Empty Stack");
        }
        return data[top];
    }

    @Override
    public void push(Integer element) {
        if(++top == data.length){
            doubleCapacity();
        }
        data[top] = element;
    }

    @Override
    public Integer pop() throws StackException {
        if(isEmpty()){
            throw new StackException("Empty Stack");
        }
        return data[top--];
    }
    @Override
    public void doubleCapacity(){
        int[] temp = new int[data.length*2];
        int i=0;
        for(int element:data){
            temp[i++]=element;
        }
        data=temp;
    }
}
