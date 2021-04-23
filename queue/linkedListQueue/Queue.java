package queue.linkedListQueue;

import queue.IQueue;
import queue.QueueException;

public class Queue <T> implements IQueue <T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public Queue(){
        front=null;
        rear=null;
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
    public T peek() throws QueueException {
        if(isEmpty()){
            throw new QueueException("Empty Queue");
        }
        return front.data;
    }

    @Override
    public void enqueue(T element) {
        size++;
        Node<T> newNode = new Node<>(element);
        if(front == null){
            front = newNode;
            rear = newNode;
            return;
        }
            rear.next = newNode;
            rear = rear.next;
    }

    @Override
    public T dequeue() throws QueueException {
        if(isEmpty()){
            throw new QueueException("Empty Queue");
        }
        size--;
        T temp = front.data;
        front = front.next;
        return temp;
    }
}
