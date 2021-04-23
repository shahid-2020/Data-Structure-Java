package queue;

public interface IQueue <T>{
    int size();
    boolean isEmpty();
    T peek() throws QueueException;
    void enqueue(T element);
    T dequeue() throws QueueException;
}
