package queue.arrayQueue;

import queue.IQueue;
import queue.QueueException;

public class Queue implements IQueue <Integer> {
    private int[] data;
    private int front;
    private int rear;
    private int size;

    public Queue(){
        this(10);
    }
    public Queue(int capacity){
        data = new int[capacity];
        front=-1;
        rear=-1;
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Integer peek() throws QueueException {
        if(isEmpty()){
            throw new QueueException("Empty Queue");
        }
        return data[front];
    }

    @Override
    public void enqueue(Integer element) {
        if(size() == data.length){
            doubleCapacity();
        }
        if(front == -1){
            front++;
        }
        rear = (rear+1) % data.length;
        data[rear]=element;
        size++;
    }

    @Override
    public Integer dequeue() throws QueueException {
        if(isEmpty()){
            throw new QueueException("Empty Queue");
        }

        int temp = data[front];
        front = (front+1)% data.length;
        size--;
        if(size == 0){
            front = -1;
            rear = -1;
        }
        return temp;
    }

    public void doubleCapacity(){
        int[] temp = new int[data.length*2];
        int index=0;
        for(int i=front; i<data.length; i++){
            temp[index++]=data[i];
        }

        for(int i=0; i<front; i++){
            temp[index++]=data[i];
        }
        front=0;
        rear=data.length-1;
        data=temp;
    }
}
